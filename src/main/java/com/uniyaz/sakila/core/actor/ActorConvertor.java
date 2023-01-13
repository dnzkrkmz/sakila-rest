package com.uniyaz.sakila.core.actor;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ActorConvertor {
    public ActorDto actorDtoConvert(Actor actor){
        ActorDto actorDto = new ActorDto();
        actorDto.setFirstName(actor.getFirstName());
        actorDto.setLastName(actor.getLastName());
        actorDto.setId(actor.getId());
        return actorDto;
    }

    public List<ActorDto> convertToActorDto(List<Actor> actorList){
        List<ActorDto> actorDtoList = new ArrayList<>();
        for (Actor actor : actorList) {
            ActorDto actorDto = actorDtoConvert(actor);
            actorDtoList.add(actorDto);
        }
        return actorDtoList;
    }
}
