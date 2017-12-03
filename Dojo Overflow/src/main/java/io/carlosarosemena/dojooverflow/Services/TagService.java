package io.carlosarosemena.dojooverflow.Services;

import io.carlosarosemena.dojooverflow.Models.Tags;
import io.carlosarosemena.dojooverflow.Repositories.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {

    @Autowired
    TagsRepository tagsRepository;

    //Check split tag
    //Analyze that there are no more than 3 tags
    //Check that tag doesnt exist

    public List<Tags> FindOrCreateTags(String tags){

        List<Tags> AllTags = new ArrayList<>();
        String rawTags = tags;
        String rawTagsTrim = rawTags.trim();
        String [] tagList = rawTagsTrim.split(",");

        for(int i =0; i<tagList.length;i++){
            Tags tagByName = tagsRepository.findBySubject(tagList[i]);
            if(tagByName == null){
                Tags tag = new Tags();
                tag.setSubject(tagList[i]);
                tagsRepository.save(tag);
                AllTags.add(tag);
            }else {
                AllTags.add(tagByName);
            }

        }
        return AllTags;
    }
}
