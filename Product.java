package com.springbackend.Springbackend.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue; //order
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
	
	//@GeneratedValue
	@Id
	@Column(name="product_id")
 	@GeneratedValue(strategy = GenerationType.AUTO)
	private int product_id;
	@Column(name="p_name")
	private String p_name;
	@Column(name="description")
	private String description;
	@Column(name="price")
	private int price;
	@Column(name="available")
	private String available;
	@Column(name="free_delivery")
	private String free_Delivery;
	@Column(name="category")
	private String category;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_id")
//	private Register user;
	
	public Product(int product_id,String p_name, String description,int price,String available,String free_delivery,String category) {
        super();
        this.p_name = p_name;
        this.description = description;
        this.price = price;
        this.available = available;
        this.free_Delivery=free_delivery;
        this.category = category;
       
        
    }
	
	
	
	
	public String getFree_Delivery() {
		return free_Delivery;
	}




	public void setFree_Delivery(String free_Delivery) {
		this.free_Delivery = free_Delivery;
	}




	public int getProduct_id() {
		return product_id;
	}




	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}




	public String getP_name() {
		return p_name;
	}




	public void setP_name(String p_name) {
		this.p_name = p_name;
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




	public String getAvailable() {
		return available;
	}




	public void setAvailable(String available) {
		this.available = available;
	}




	public String getCategory() {
		return category;
	}




	public void setCategory(String category) {
		this.category = category;
	}




	public Product() {
		// TODO Auto-generated constructor stub
	}
	
}