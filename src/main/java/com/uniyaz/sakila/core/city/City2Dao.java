package com.uniyaz.sakila.core.city;

import com.uniyaz.sakila.core.common.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class City2Dao extends BaseDao<City> {

    @Autowired
    EntityManager entityManager;

    public City2Dao() {
        super(City.class);
    }

    public List<City> findAll() {
        String hql =
                "Select             city " +
                "from               City city " +
                "Left Join fetch    city.country country";
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }
}