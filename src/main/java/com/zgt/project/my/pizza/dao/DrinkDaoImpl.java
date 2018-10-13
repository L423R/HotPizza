package com.zgt.project.my.pizza.dao;

import com.zgt.project.my.pizza.entitys.DrinksEntity;
import com.zgt.project.my.pizza.entitys.PizzaEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository("DrinkDao")
public class DrinkDaoImpl implements DrinkDao {

    @PersistenceContext(unitName = "MyPU")
    private EntityManager em;

    @Override
    public DrinksEntity getByName(String name) {
        TypedQuery<DrinksEntity> query = em.createNamedQuery("DRINK_BY_NAME", DrinksEntity.class);
        query.setParameter("name",name);
        DrinksEntity drink = null;

        try {
            drink = query.getSingleResult();
        }catch (Exception e)
        {
            System.out.println("EXCEPTION");
        }
        return drink;
    }

    @Cacheable(value = "mydrink")
    @Override
    public List<DrinksEntity> getAll() {
        TypedQuery<DrinksEntity> query = em.createNamedQuery("GET_ALL_DRINKS", DrinksEntity.class);
        return query.getResultList();
    }

    @Override
    public DrinksEntity getById(int id) {
        return em.find(DrinksEntity.class,id);
    }

    @Override
    public DrinksEntity update(DrinksEntity drink) {
        em.merge(drink);
        return drink;
    }

    @Override
    public boolean delete(DrinksEntity drink) {
        em.remove(drink);
        return true;
    }


    @Override
    public DrinksEntity save(DrinksEntity drink) {
        em.persist(drink);
        return drink;
    }
}
