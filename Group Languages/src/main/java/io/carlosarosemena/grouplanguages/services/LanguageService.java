package io.carlosarosemena.grouplanguages.services;

import io.carlosarosemena.grouplanguages.models.language;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class LanguageService {

    private ArrayList<language> languages = new ArrayList<>(Arrays.asList(
            new language("Java", "Carlos Arosemena", "1.8.11"),
            new language("Python", "Guido van Rossum", "3.6"),
            new language("Javascript", "Brendan Eich", "1.9.5.5")

    ));

    public ArrayList<language> allLanguages(){
        return languages;
    }
}
