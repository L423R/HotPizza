package com.zgt.project.my.pizza.dao;

import com.zgt.project.my.pizza.entitys.UserEntity;

public interface UserDao {
    UserEntity getUserById(int id);
    void saveUser(UserEntity user);
    void removeUserById(int id);
    UserEntity getUserByName(String name);

}
