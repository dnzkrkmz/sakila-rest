package com.uniyaz.sakila.core.city;

import com.uniyaz.sakila.core.common.BaseService;
import com.uniyaz.sakila.core.country.Country;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CityService extends BaseService<City, City2Dao> {


//    public List<City> findAllByCountryName(String countryName) {
//        return cityDao.findAllByCountryName(countryName);
//    }

    public City save(CitySaveRequestDto citySaveRequestDto) {
        String cityName = citySaveRequestDto.getName();

        Country country = new Country();
        country.setId(citySaveRequestDto.getCountryId());

        City city = new City();
        city.setCity(cityName);
        city.setCountry(country);
        city.setLastUpdate(new Date());
        return super.save(city);
    }

    public City save(CityCascadeSaveRequestDto cityCascadeSaveRequestDto) {
        String cityName = cityCascadeSaveRequestDto.getCityName();
        String countryName = cityCascadeSaveRequestDto.getCountryName();

        Country country = new Country();
        country.setCountry(countryName);
        country.setLastUpdate(new Date());

        City city = new City();
        city.setCity(cityName);
        city.setCountry(country);
        city.setLastUpdate(new Date());
        return super.save(city);
    }

}
