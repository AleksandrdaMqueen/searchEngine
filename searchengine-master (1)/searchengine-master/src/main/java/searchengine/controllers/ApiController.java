package searchengine.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import searchengine.Handlers.LemmaFinder;
import searchengine.Handlers.UrlJoiner;
import searchengine.dto.statistics.DetailedStatisticsItem;
import searchengine.dto.statistics.StatisticsData;
import searchengine.dto.statistics.StatisticsResponse;
import searchengine.dto.statistics.TotalStatistics;
import searchengine.model.*;
import searchengine.repository.IndexRepo;
import searchengine.repository.LemmaRepo;
import searchengine.repository.PageRepo;
import searchengine.repository.SiteRepo;
import searchengine.services.StatisticsService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

@RestController
@RequestMapping("/api")
public class ApiController {

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
        StatisticsResponse response = new StatisticsResponse();


        return response;
    }

    @SneakyThrows
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam  String query, @RequestParam String site, @RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "20") int limit){
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

        return null;
    }
    @GetMapping("/startIndexing")
    public void startIndexing() throws IOException {
        Site site = new Site();

        String url = "http://www.playback.ru/";

        site.setName(url);
        site.setStatus_time(LocalDate.now());
        site.setStatus(Status.INDEXING);

        siteRepo.save(site);

        String map = new ForkJoinPool().invoke(new UrlJoiner(url));
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
            page.setSiteId(site.getId());
            page.setPath(newArr[i]);
            Document doc = Jsoup.connect(newArr[i]).ignoreHttpErrors(true).get();

            page.setContent(doc.toString());



            pageRepo.save(page);
        }



    }
    @SneakyThrows
    @PostMapping("/indexPage")
    public void indexPage(String url){
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
