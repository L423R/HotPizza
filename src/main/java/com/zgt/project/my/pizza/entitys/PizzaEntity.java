package com.zgt.project.my.pizza.entitys;

import com.zgt.project.my.pizza.Item;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pizza", schema = "red_pizza")
@NamedQueries({
        @NamedQuery(name="PIZZA_BY_NAME",query = "SELECT p FROM PizzaEntity p WHERE p.name = :name"),
        @NamedQuery(name="GET_ALL_PIZZAS",query = "SELECT p FROM PizzaEntity p"),
		@NamedQuery(name="GET_PIZZA_BY_ID",query = "SELECT p FROM PizzaEntity p WHERE p.id = :id")
})
public class PizzaEntity extends Item {
    private int id;
    private String name;
    private int price;
    private String description;
    private String imgPath;
    private int priceBig;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price_little")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "img_path")
    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Basic
    @Column(name = "price_big")
    public int getPriceBig() {
        return priceBig;
    }

    public void setPriceBig(int priceBig) {
        this.priceBig = priceBig;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PizzaEntity that = (PizzaEntity) o;
        return id == that.id &&
                price == that.price &&
                priceBig == that.priceBig &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(imgPath, that.imgPath);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, price, description, imgPath, priceBig);
    }

    @Override
    public String toString() {
        return "PizzaEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", priceBig=" + priceBig +
                '}';
    }
}
