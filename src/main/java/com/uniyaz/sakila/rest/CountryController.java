package com.uniyaz.sakila.rest;

import com.uniyaz.sakila.core.country.Country;
import com.uniyaz.sakila.core.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping(path = "/findAll", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Country> findAllCountry() {
        return countryService.findAll();
    }

    @GetMapping(path = "/findAllByName/{name}")
    public List<Country> findAllCountryByName(@PathVariable("name") String countryName) {
        return countryService.findAllByName(countryName);
    }

    @PutMapping(path = "/put")
    public Boolean putCountry(@RequestBody Country country){
        System.out.println("Koyuluyor .." + country.getCountry() +
                country.getId() +
                country.getLastUpdate());
        return true;
    }
    

}