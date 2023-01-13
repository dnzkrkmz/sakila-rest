package com.uniyaz.sakila.core.actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorDao extends JpaRepository<Actor, Long> {

    @Query("select actor from Actor actor where actor.firstName = :firstName")
   public List<Actor> findAllByFirstName(@Param("firstName") String name);

}
