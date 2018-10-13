package com.zgt.project.my.pizza.dao;

import com.zgt.project.my.pizza.entitys.DrinksEntity;

import java.util.List;

public interface DrinkDao {

    DrinksEntity getByName(String name);
    List<DrinksEntity> getAll();
    DrinksEntity getById(int id);
    DrinksEntity update(DrinksEntity drink);
    boolean delete(DrinksEntity drink);
    DrinksEntity save(DrinksEntity drink);
}
