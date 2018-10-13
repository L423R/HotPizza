package com.zgt.project.my.pizza.dao;

import com.zgt.project.my.pizza.entitys.PizzaEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Repository("PizzaDao")
public class PizzaDaoImpl implements PizzaDAO {

    @PersistenceContext(unitName = "MyPU")
    private EntityManager em;

    @Override
    public PizzaEntity getByName(String name) {
        TypedQuery<PizzaEntity> query = em.createNamedQuery("PIZZA_BY_NAME", PizzaEntity.class);
        query.setParameter("name",name);
        PizzaEntity pizza = null;

        try {
            pizza = query.getSingleResult();
        }catch (Exception e)
        {
            System.out.println("EXCEPTION");
        }
        return pizza;
    }

    @Cacheable(value = "mycache")
    @Override
    public List<PizzaEntity> getAll() {
        TypedQuery<PizzaEntity> query = em.createNamedQuery("GET_ALL_PIZZAS", PizzaEntity.class);
        return query.getResultList();
    }

    @Override
    public PizzaEntity getById(int id) {
        TypedQuery<PizzaEntity> query = em.createNamedQuery("GET_PIZZA_BY_ID", PizzaEntity.class);
        query.setParameter("id", id);
        PizzaEntity pizza = null;

        pizza = query.getSingleResult();

        return pizza;
    }

    @Override
    public PizzaEntity update(PizzaEntity pizza) {
        em.merge(pizza);
        return pizza;
    }


    @Override
    public boolean delete(PizzaEntity pizza) {
        em.remove(pizza);
        return true;
    }



    @Override
    public PizzaEntity save(PizzaEntity pizza) {
        em.persist(pizza);
        return pizza;
    }
}
