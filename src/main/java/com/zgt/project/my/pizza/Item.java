package com.zgt.project.my.pizza;

import java.util.ArrayList;

public class Item {
    private int id;
	private String name;
	private String description;
	private int price;
	private String imagePath;

	public Item(String name,  int price, String imagePath,String description) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.imagePath = imagePath;
	}

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Item{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				", price=" + price +
				", imagePath='" + imagePath + '\'' +
				'}';
	}


}