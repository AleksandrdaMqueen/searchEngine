package controllers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.PageRepo;
import repository.SiteRepo;

import java.io.IOException;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("read-data-from-yml")
public class RestController {
    @Autowired
    private SiteRepo siteRepo;

    private PageRepo pageRepo;


    private String site;


    @GetMapping("/api/startIndexing")
    public String startIndexing() throws IOException {
        Document doc = Jsoup.connect("http://www.playback.ru/").get();

        return site;
    }
}
