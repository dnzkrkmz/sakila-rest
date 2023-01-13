package com.uniyaz.sakila.core.actor;

import com.uniyaz.sakila.core.country.Country;
import com.uniyaz.sakila.core.country.CountrySaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ActorService {
    @Autowired
    ActorDao actorDao;

    public List<Actor> findAll(){ return actorDao.findAll(); }

    public List<Actor> findAllByFirstName(String name){return actorDao.findAllByFirstName(name);}

    public Actor save(ActorSaveDto actorSaveDto){
        String firstName = actorSaveDto.getFirstName();
        String lastName = actorSaveDto.getLastName();

        Actor actor = new Actor();
        actor.setLastUpdate(new Date());
        actor.setFirstName(firstName);
        actor.setLastName(lastName);
        return actorDao.save(actor);
    }
}
