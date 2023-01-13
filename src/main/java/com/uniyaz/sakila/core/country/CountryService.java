package com.uniyaz.sakila.core.country;

import com.uniyaz.sakila.core.city.City;
import com.uniyaz.sakila.core.city.CitySaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

@Service
public class CountryService {

    private final CountryDao countryDao;

    public CountryService(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    public List<Country> findAll() {
        return countryDao.findAll();
    }

    public List<Country> findAllByName(String countryName) {
        return countryDao.findAllByName(countryName);
    }

    public List<CountryCityCountDto> findCountryCityCountDto() {
        return countryDao.findCountryCityCountDto();
    }

    public Country save(CountrySaveRequestDto countrySaveRequestDto){
        String countryName = countrySaveRequestDto.getName();
        Country country = new Country();
        country.setLastUpdate(new Date());
        country.setCountry(countryName);
        return countryDao.save(country);
    }
}