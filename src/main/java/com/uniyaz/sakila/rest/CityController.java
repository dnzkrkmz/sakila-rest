package com.uniyaz.sakila.rest;

import com.uniyaz.sakila.core.city.*;
import com.uniyaz.sakila.core.common.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "/city")
public class CityController {

    @Autowired
    CityService cityService;
    @Autowired
    CityConvertor cityConvertor;

//    @GetMapping(path = "findAllByCountryName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<City> findAllCountryByName1(@PathVariable String name) {
//        return cityService.findAllByCountryName(name);
//    }

//    @GetMapping(path = "findAllByCountryName", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Object> findAllWithCountryName(String name) {
//        List<City> cityList = cityService.findAllByCountryName(name);
//        List<CitytoCountryFinderDto> citytoCountryFinderDtoList = cityConvertor.convertToCityToCountryDto(cityList);
//        if (!citytoCountryFinderDtoList.isEmpty()) {
//            return ResponseHandler.generateResponse("Successfully reached data!", HttpStatus.OK, citytoCountryFinderDtoList);
//        } else {
//            return ResponseHandler.generateResponse("Unreached data.Please check url.",HttpStatus.BAD_REQUEST,citytoCountryFinderDtoList);
//        }
//    }

    @GetMapping(path = "findAll")
    public ResponseEntity findAll(){
        List<City> cityList = cityService.findAll();
        ResponseEntity responseEntity = new ResponseEntity(cityList, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping(path= "save")
    public ResponseEntity save(@RequestBody CitySaveRequestDto citySaveRequestDto){
        City city = cityService.save(citySaveRequestDto);
        CityDto cityDto = cityConvertor.convertToCityDto(city);
        ResponseEntity responseEntity = new ResponseEntity(cityDto, HttpStatus.OK);
        return responseEntity; // country id ve name ile citySaveRequestDto un içindeki değerler girilerek kayıt oluyor ama yeni bir ülke ekleyemiyorum sadece id olarak ekleniyor aynı anda ülkede eklemek için cascade merge yapıyoruz
    }

    @PostMapping(path= "saveCascade")
    public ResponseEntity saveCascade(@RequestBody CityCascadeSaveRequestDto cityCascadeSaveRequestDto){
        City city = cityService.save(cityCascadeSaveRequestDto);
        CityDto cityDto = cityConvertor.convertToCityDto(city);
        ResponseEntity responseEntity = new ResponseEntity(cityDto, HttpStatus.OK);
        return responseEntity;
    }


}
