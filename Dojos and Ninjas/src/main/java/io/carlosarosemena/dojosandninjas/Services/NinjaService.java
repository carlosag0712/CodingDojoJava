package io.carlosarosemena.dojosandninjas.Services;

import io.carlosarosemena.dojosandninjas.Models.Ninja;
import io.carlosarosemena.dojosandninjas.Repositories.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NinjaService {
    @Autowired
    NinjaRepository ninjaRepository;

    public Ninja createNinja(Ninja ninja){
        return ninjaRepository.save(ninja);
    }
}
