package com.zgt.project.my.pizza.entitys;

import com.zgt.project.my.pizza.Item;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "drinks", schema = "red_pizza", catalog = "")
@NamedQueries({
        @NamedQuery(name="DRINK_BY_NAME",query = "SELECT d FROM DrinksEntity d WHERE d.name = :name"),
        @NamedQuery(name="GET_ALL_DRINKS",query = "SELECT d FROM DrinksEntity d"),
})
public class DrinksEntity extends Item {
    private int id;
    private String name;
    private int price;
    private String imgPath;
    private String description;

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
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrinksEntity that = (DrinksEntity) o;
        return id == that.id &&
                price == that.price &&
                Objects.equals(name, that.name) &&
                Objects.equals(imgPath, that.imgPath) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, price, imgPath, description);
    }

    @Override
    public String toString() {
        return "DrinksEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", imgPath='" + imgPath + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
