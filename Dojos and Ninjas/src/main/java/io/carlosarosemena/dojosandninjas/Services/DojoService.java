package io.carlosarosemena.dojosandninjas.Services;


import io.carlosarosemena.dojosandninjas.Models.Dojo;
import io.carlosarosemena.dojosandninjas.Repositories.DojoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DojoService {

    @Autowired
    DojoRepository dojoRepository;

    public void createDojo(Dojo dojo){
        dojoRepository.save(dojo);
    }

    public List<Dojo> getAll(){
        return dojoRepository.findAll();
    }

    public Dojo findDojo(Long id){
        return dojoRepository.findOne(id);
    }
}
