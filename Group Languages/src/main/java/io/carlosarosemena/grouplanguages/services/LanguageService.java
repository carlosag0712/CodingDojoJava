package io.carlosarosemena.grouplanguages.services;

import io.carlosarosemena.grouplanguages.models.language;
import io.carlosarosemena.grouplanguages.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class LanguageService {
    @Autowired
    private LanguageRepository languageRepository;



    public List<language> allLanguages(){

        return languageRepository.findAll();
    }

    public language findOne(Long id){
      return languageRepository.findOne(id);
    }

    public void addLanguage(language language){

        languageRepository.save(language);

    }

    public void updateLanguage(Long id, language language){
        languageRepository.save(language);
    }

    public void deleteLanguage(Long id){
        languageRepository.delete(id);
    }

}
