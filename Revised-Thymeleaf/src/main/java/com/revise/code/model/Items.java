package com.revise.code.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="items")
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int item_id;
	
	@NotNull(message="is Required")
	@Size(min = 3,message="Size must be greater then 3")	
	@Column(name="name")
	private String item_name;	
	
	@Column(name="description")
	@NotNull(message="is required")	
	private String description;	
	
	@Column(name="quantity")
	@NotNull(message = "is Required")
	@Min(value = 1 , message = "muste be greater then or equal to 0")
	@Max(value = 5 , message="must be less then or equal to 5")
	private Integer quantity;
	
	@Column(name="price")
	@Min(value =40 , message="no item cost less then 40")
	private double price;
	
	@Column(name="category")
	private String category;
	
	public Items() {
		super();
	}

	public Items(String item_name, String description, int quantity, double price, String category) {
		super();
		this.item_name = item_name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Items [item_id=" + item_id + ", item_name=" + item_name + ", description=" + description + ", quantity="
				+ quantity + ", price=" + price + ", category=" + category + "]";
	}


	
}
