package searcheng.controllers;

import searcheng.model.Page;
import searcheng.model.Site;
import searcheng.model.Status;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import searcheng.repository.PageRepo;
import searcheng.repository.SiteRepo;
import searcheng.tools.UrlJoiner;

import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.ForkJoinPool;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("read-data-from-yml")
public class RestController {


    private SiteRepo siteRepo;

    private PageRepo pageRepo;


    private Site site;
    private Page page;


    @GetMapping("/api/startIndexing")
    public void startIndexing() throws IOException {
        String url = "http://www.playback.ru/";
        Document doc = Jsoup.connect(url).get();
        site.setName(url);
        site.setStatus_time(LocalDate.now());
        site.setStatus(Status.INDEXING);


        siteRepo.save(site);
        String map = new ForkJoinPool().invoke(new UrlJoiner(url));
        System.out.println(map);

    }
}
