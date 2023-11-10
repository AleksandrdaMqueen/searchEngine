package searchengine.Handlers;

import org.apache.lucene.morphology.LuceneMorphology;
import org.apache.lucene.morphology.russian.RussianLuceneMorphology;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class LemmaFinder {

    public HashMap<String, Integer> getLemmas(String text) throws IOException {

        String[] splittedText = text.replaceAll("\\p{P}", "").split(" ");
        HashMap<String, Integer> res = new HashMap<>();
        for (String word: splittedText)

        {
            LuceneMorphology luceneMorph =
                    new RussianLuceneMorphology();

                List<String> wordBaseForms1 =
                        luceneMorph.getMorphInfo(word.toLowerCase(Locale.ROOT));
            if(wordBaseForms1.toString().split(" ").length == 2){
                continue;
            }else {

                List<String> wordBaseForms =
                        luceneMorph.getNormalForms(word.toLowerCase(Locale.ROOT));

                res.put(word, wordBaseForms.size());
            }
        }

        return  res;

    }


    public String  tagCleaner(String url) throws IOException {
        Document doc = Jsoup.connect(url).ignoreHttpErrors(true).get();

        return doc.text();
    }
}
