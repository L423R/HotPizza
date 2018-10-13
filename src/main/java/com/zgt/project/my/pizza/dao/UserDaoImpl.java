package com.zgt.project.my.pizza.dao;

import com.zgt.project.my.pizza.entitys.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {

    @PersistenceContext(unitName = "MyPU")
    private EntityManager em;


    @Override
    public UserEntity getUserById(int id) {
        return em.find(UserEntity.class,id);
    }

    @Override
    public void saveUser(UserEntity user) {

    }

    @Override
    public void removeUserById(int id) {

    }

    @Override
    public UserEntity getUserByName(String name) {
        return null;
    }
}
