package com.uniyaz.sakila.rest;

import com.uniyaz.sakila.core.actor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/actor")
public class ActorController {
    @Autowired
    ActorService actorService;

    @Autowired
    ActorConvertor actorConvertor;

    @GetMapping(path = "findAllByFirstName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findAllWithCountryName(String name) {
        List<Actor> actors = actorService.findAllByFirstName(name);
        List<ActorDto> actorDtoList = actorConvertor.convertToActorDto(actors);
        if (!actorDtoList.isEmpty()) {
            ResponseEntity responseEntity = new ResponseEntity(actorDtoList, HttpStatus.OK);
            return responseEntity;
        } else {
            ResponseEntity responseEntity = new ResponseEntity(HttpStatus.NO_CONTENT);
            return responseEntity;
        }
    }

    @PostMapping("save")
    public ResponseEntity saveActor(@RequestBody  ActorSaveDto actorSaveDto){
        Actor actor = actorService.save(actorSaveDto);
        ActorDto actorDto1 = actorConvertor.actorDtoConvert(actor);
        ResponseEntity responseEntity = new ResponseEntity(actorDto1,HttpStatus.OK);
        return responseEntity;
    }
}
