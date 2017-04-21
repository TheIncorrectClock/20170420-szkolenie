package com.example.servlet.webapp;

import com.example.dictionary.translation.DictionaryWord;
import com.example.dictionary.translation.TranslationService;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Controller
public class MyController {

    private final TranslationService service;

    public MyController(TranslationService service) {
        this.service = service;
    }

    @GetMapping("/translations.html")
    public ModelAndView translate(@RequestParam("word") String word) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("translate");
        mv.addObject("word", word);
        mv.addObject("words", service.getTranslationsForWord(word));

        return mv;
    }

    @GetMapping(value = "/translations/{word}",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<List<DictionaryWord>> doTranslations(@PathVariable("word") String word) {
        List<DictionaryWord> words = service.getTranslationsForWord(word);

        return ResponseEntity.ok(words);
    }

    @PostMapping(value = "/translations", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveWord(@RequestBody DictionaryWord word) {
        System.out.println("str = " + word);

        return ResponseEntity.noContent().build();
    }
}
