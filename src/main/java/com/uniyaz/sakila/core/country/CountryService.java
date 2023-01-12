package com.uniyaz.sakila.core.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    CountryDao countryDao;

    public List<Country> findAll() {
        return countryDao.findAll();
    }

    public List<Country> findAllByName(String countryName) {
        return countryDao.findAllByName(countryName);
    }

    public Country save(Country country){return countryDao.save(country);}
}