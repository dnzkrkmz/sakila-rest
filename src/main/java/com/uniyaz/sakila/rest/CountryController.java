package com.uniyaz.sakila.rest;

import com.uniyaz.sakila.core.country.Country;
import com.uniyaz.sakila.core.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping(path = "findAll", produces = MediaType.APPLICATION_PDF_VALUE)
    public List<Country> findAllCountry() {
        return countryService.findAll();
    }
}