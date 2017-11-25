package io.carlosarosemena.relationships.services;

import io.carlosarosemena.relationships.models.License;
import io.carlosarosemena.relationships.models.Person;
import io.carlosarosemena.relationships.repositories.LicenseRepository;
import io.carlosarosemena.relationships.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DMVService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private LicenseRepository licenseRepository;

    public List<Person> allPersons(){
        return personRepository.findAll();
    }

    public Person createPerson(Person person){
        return personRepository.save(person);
    }

    public Person getPerson(Long id){
        return personRepository.findOne(id);

    }

    public License createLicense(License license){
        Long personId = license.getPerson().getId();

        String licNumber = String.format("%06d", personId);

        license.setNumber(licNumber);
        License lic = licenseRepository.save(license);

        return lic;
    }

}
