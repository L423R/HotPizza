package com.zgt.project.my.pizza.dao;

import com.zgt.project.my.pizza.entitys.OrderEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("OrderDao")
public class OrderDaoImpl implements OrderDao {

    @PersistenceContext(unitName = "MyPU")
    private EntityManager em;

    private OrderEntity order;

    @Override
    public OrderEntity getOrder() {
        if (order==null) {
            return new OrderEntity();
        } else {
            return order;
        }
    }

    @Override
    public void saveOrder(OrderEntity order) {
        em.persist(order);
    }
}
