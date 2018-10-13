package com.zgt.project.my.pizza.entitys;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order", schema = "red_pizza", catalog = "")
public class OrderEntity {
    private int id;
    private String items;
    private int amount;
    private int userId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "items")
    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    @Basic
    @Column(name = "amount")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return id == that.id &&
                amount == that.amount &&
                userId == that.userId &&
                Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, items, amount, userId);
    }
}
