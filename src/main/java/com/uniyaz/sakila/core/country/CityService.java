package com.uniyaz.sakila.core.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uniyaz.sakila.core.country.City;

import java.util.List;

@Service
public class CityService {
    @Autowired
    CityDao cityDao;

    public List<City> findAllByCountryName(String countryName) {
        return cityDao.findAllByCountryName(countryName);
    }
}
