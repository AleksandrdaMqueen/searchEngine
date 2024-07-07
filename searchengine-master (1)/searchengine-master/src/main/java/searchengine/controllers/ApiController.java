package searchengine.controllers;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import searchengine.Handlers.LemmaFinder;
import searchengine.Handlers.UrlJoiner;
import searchengine.config.Site;
import searchengine.config.SitesList;
import searchengine.dto.statistics.StatisticsResponse;
import searchengine.model.*;
import searchengine.repository.IndexRepo;
import searchengine.repository.LemmaRepo;
import searchengine.repository.PageRepo;
import searchengine.repository.SiteRepo;
import searchengine.services.StatisticsService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ForkJoinPool;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    SitesList sitesList;

    private final LemmaRepo lemmaRepo;

    private final SiteRepo siteRepo;

    private final PageRepo pageRepo;

    private final IndexRepo indexRepo;

    private final StatisticsService statisticsService;

    public ApiController(SiteRepo siteRepo,PageRepo pageRepo, StatisticsService statisticsService,LemmaRepo lemmaRepo, IndexRepo indexRepo) {
        this.siteRepo = siteRepo;
        this.pageRepo = pageRepo;
        this.statisticsService = statisticsService;
        this.lemmaRepo = lemmaRepo;
        this.indexRepo = indexRepo;

    }

    @GetMapping("/statistics")
    public StatisticsResponse statistics() {


        return statisticsService.getStatistics();
    }


    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam  String query, @RequestParam String site, @RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "20") int limit) throws IOException {
        LemmaFinder lemmaFinder = new LemmaFinder();

        ArrayList<Page> pages = (ArrayList<Page>) pageRepo.findAll();
        ArrayList<Page> containsLemma = new ArrayList<>();

        String cleanText = lemmaFinder.tagCleaner(site);
        HashMap<String,Integer> lemmasAndFreq = lemmaFinder.getLemmas(cleanText);
        lemmasAndFreq.entrySet().stream()
                .sorted(Map.Entry.comparingByValue());
        ArrayList<String> lemmas = lemmaFinder.lemmaFreqency(lemmasAndFreq);


        for (int i = 0; i < pages.size(); i++) {
            for (int j = 0; j < lemmas.size(); j++) {

                String content = pages.get(i).getContent();
                if (content.contains(lemmas.get(j))) {
                    containsLemma.add(pages.get(i));
                }
            }
        }
        return new ResponseEntity<>(containsLemma, HttpStatus.OK)  ;
    }
    @GetMapping("/startIndexing")
    public void startIndexing() throws IOException {

        List<Site> sites = sitesList.getSites();

        sites.forEach(site ->{
            SiteModel siteModel = new SiteModel();
            siteModel.setStatus_time(LocalDate.now());
            siteModel.setStatus(Status.INDEXING);
            siteModel.setName(siteModel.getName());
            siteModel.setUrl(site.getUrl());
            siteRepo.save(siteModel);

            String map = new ForkJoinPool().invoke(new UrlJoiner(sites.get(0).getUrl()));
            System.out.println(map);

            String[] siteMap = map.split("\n");

            System.out.println(siteMap.length);
            System.out.println(siteMap[5]);
            String[] newArr = null;
            for (int i = 0; i < siteMap.length-1; i++) {
                if(siteMap[i] ==  siteMap[1]){
                    newArr = new String[siteMap.length - 1];
                    for(int index = 0; index < i; index++){
                        newArr[index] = siteMap[index];
                    }
                    for(int j = i; j < siteMap.length - 1; j++){
                        newArr[j] = siteMap[j+1];
                    }
                    break;
                }
            }
            for (int i = 0; i < newArr.length-1; i++) {
                Page page = new Page();
                siteMap[i].replaceAll("\\s+","");
                page.setCode(HttpStatus.OK.value());
                page.setSiteId(siteModel.getId());
                page.setPath(newArr[i]);
                Document doc = null;
                try {
                    doc = Jsoup.connect(newArr[i]).ignoreHttpErrors(true).get();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                page.setContent(doc.toString());
                pageRepo.save(page);
            }
        });


    }
    @PostMapping("/indexPage")
    public void indexPage(String url) throws IOException {
          LemmaFinder lemmaFinder = new LemmaFinder();

          String cleanText = lemmaFinder.tagCleaner(url);
          HashMap<String,Integer> lemmas = lemmaFinder.getLemmas(cleanText);
          List<String> keys = new ArrayList<String>(lemmas.keySet());
          List<Page> pages = (List<Page>) pageRepo.findAll();
        for (int i = 0; i < pages.size(); i++) {


            for (String s : keys) {
                Page page = new Page();
                Lemma lemma1 = new Lemma();
                Index index = new Index();

                String key = s;
                int value = lemmas.get(key);

                lemma1.setLemma(key);
                lemma1.setSite_id(1);
                index.setLemma_id(lemma1.getId());
                ArrayList<Lemma> lemmasList = (ArrayList<Lemma>) lemmaRepo.findAll();
                if (lemmasList.contains(key.toString())) {
                    lemma1.setLemma(key);
                    lemma1.setFrequency(lemma1.getFrequency() + 1);
                } else {
                    lemma1.setLemma(key);
                    lemma1.setFrequency(1);
                }
                if (page.getContent().contains(s)){
                    index.setPage_id(page.getId());
                    index.setLemma_id(lemma1.getId());
                }

                index.setRankc(value);
                lemmaRepo.save(lemma1);
                indexRepo.save(index);
            }
        }

    }
}
