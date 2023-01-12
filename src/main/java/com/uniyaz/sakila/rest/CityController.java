package com.uniyaz.sakila.rest;

import com.uniyaz.sakila.core.country.City;
import com.uniyaz.sakila.core.country.CityService;
import com.uniyaz.sakila.core.country.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping(path = "/city")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping(path = "findAllByCountryName/{name}", produces = MediaType.APPLICATION_XML_VALUE)
    public List<City> findAllCountryByName(@PathVariable("name") String countryName) {
        return cityService.findAllByCountryName(countryName);
    }
}
