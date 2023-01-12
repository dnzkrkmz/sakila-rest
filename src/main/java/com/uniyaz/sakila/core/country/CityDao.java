package com.uniyaz.sakila.core.country;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.uniyaz.sakila.core.country.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityDao extends JpaRepository<City, Long> {


    @Query("select city from City city where city.country.country = :countryName")
    public List<City> findAllByCountryName(@Param("countryName") String countryName);
}
