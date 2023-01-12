package com.uniyaz.sakila.rest;

import com.uniyaz.sakila.core.country.Country;
import com.uniyaz.sakila.core.country.CountryConverter;
import com.uniyaz.sakila.core.country.CountryDto;
import com.uniyaz.sakila.core.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @Autowired
    CountryConverter countryConverter;

    @GetMapping(path = "findAll")
    public List<Country> findAllCountry() {
        return countryService.findAll();
    }

    @GetMapping(path = "findAllByName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findAllCountry(String name) {
        List<Country> countryList = countryService.findAllByName(name);
        List<CountryDto> countryDtoList = countryConverter.convertToCountryDtoList(countryList);
        if (!countryDtoList.isEmpty()) {
            ResponseEntity responseEntity = new ResponseEntity(countryDtoList, HttpStatus.OK);
            return responseEntity;
        } else {
            ResponseEntity responseEntity = new ResponseEntity(HttpStatus.NO_CONTENT);
            return responseEntity;
        }
    }

    @GetMapping(path = "findAllByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Country> findAllCountryPathVariable(@PathVariable String name) {
        return countryService.findAllByName(name);
    }
}