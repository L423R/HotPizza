package com.zgt.project.my.pizza.dao;

import com.zgt.project.my.pizza.entitys.OrderEntity;

public interface OrderDao {

    OrderEntity getOrder();
    void saveOrder(OrderEntity order);

}
