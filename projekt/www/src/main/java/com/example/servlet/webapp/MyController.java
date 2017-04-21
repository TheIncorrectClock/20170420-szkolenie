package com.example.servlet.webapp;

import com.example.dictionary.translation.DictionaryWord;
import com.example.dictionary.translation.TranslationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Controller
public class MyController {

    private final TranslationService service;

    public MyController(TranslationService service) {
        this.service = service;
    }

    @GetMapping("/translation.html")
    public ModelAndView translate(@RequestParam("word") String word) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("translate");
        mv.addObject("word", word);
        mv.addObject("words", service.getTranslationsForWord(word));

        return mv;
    }

    @PostMapping("/translation/{word}")
    @ResponseBody
    public ResponseEntity doTranslations(@PathVariable("word") String word) {
        List<DictionaryWord> words = service.getTranslationsForWord(word);

        return ResponseEntity.noContent().build();
    }

}
