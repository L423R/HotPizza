package com.zgt.project.my.pizza.dao;

import com.zgt.project.my.pizza.entitys.PizzaEntity;

import java.util.List;

public interface PizzaDAO {


    PizzaEntity getByName(String name);
    List<PizzaEntity> getAll();
    PizzaEntity getById(int id);
    PizzaEntity update(PizzaEntity pizza);
    boolean delete(PizzaEntity pizza);

    PizzaEntity save(PizzaEntity pizza);


}
