package com.uniyaz.sakila.rest;

import com.uniyaz.sakila.core.country.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @GetMapping(path = "findCountryCityCountDto")
    public ResponseEntity findCountryCityCountDto() {
        List<CountryCityCountDto> countryCityCountDtoList = countryService.findCountryCityCountDto();
        ResponseEntity responseEntity = new ResponseEntity(countryCityCountDtoList, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping(path="save")
    public ResponseEntity saveCountry(@RequestBody CountrySaveRequestDto countrySaveRequestDto){
        Country country=countryService.save(countrySaveRequestDto);
        CountryDto countryDto = countryConverter.convertToCountryDto(country);
        ResponseEntity responseEntity = new ResponseEntity(countryDto,HttpStatus.OK);
        return responseEntity;
    }
}