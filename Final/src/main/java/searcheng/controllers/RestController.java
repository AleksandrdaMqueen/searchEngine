package searcheng.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("read-data-from-yml")
public class RestController {


    private String site;


    @GetMapping("/api/startIndexing")
    public String startIndexing(){

        return site;
    }
}
