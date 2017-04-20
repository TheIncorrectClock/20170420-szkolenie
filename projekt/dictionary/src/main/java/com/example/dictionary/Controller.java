package com.example.dictionary;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.example.dictionary.translation.DictionaryWord;
import com.example.dictionary.translation.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

@Component
public class Controller {

    @Autowired
    Validator validator;

	private final TranslationService service;

	public Controller(TranslationService service) {
		this.service = service;
	}

	public void run() {
		boolean ok = true;
		Scanner s = new Scanner(System.in);
		while (ok) {
			System.out.print("dictionary > ");
			CommandParams params = CommandParams.of(s.nextLine());

			if ("search".equals(params.command)) {
                Set<ConstraintViolation<CommandParams>> errors = validator.validate(params);
                if (!errors.isEmpty()) {
                    System.out.println("Błędy walidacji");
                    continue;
                }
                List<DictionaryWord> words = service.getTranslationsForWord(params.args.first());
                words.forEach(System.out::println);
            }

            if ("exit".equals(params.command)) {
				ok = false;
			}
		}
		s.close();
	}
	
}
