package com.uniyaz.sakila.core.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CityDao extends JpaRepository<City, Long> {


    @Query("select city from City city where city.country.country = :countryName")
    public List<City> findAllByCountryName(@Param("countryName") String countryName);

    @Query(
            "Select             city " +
            "from               City city " +
            "Left Join fetch    city.country country") //Left Join olmazsa Lazy Initializr bilmem ne hatası
    List<City> findAll();


}