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
@Table(name="transaction")
public class Transaction {
	@Id
	//@GeneratedValue
	@Column(name="trans_id")
 	@GeneratedValue(strategy = GenerationType.AUTO)
	private int trans_id;
	@Column(name="price")
	private int price;
	@Column(name="status")
	private String status;
	
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Order order;
	
	
	public Transaction(int trans_id,int price,String status) {
        super();
        this.status = status;
        this.price = price;
        
       
        
    }
	
	


	public Transaction() {
		// TODO Auto-generated constructor stub
	}




	public int getTrans_id() {
		return trans_id;
	}




	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
	}




	public int getPrice() {
		return price;
	}




	public void setPrice(int price) {
		this.price = price;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




//	public Register getUser() {
//		return user;
//	}
//
//
//
//
//	public void setUser(Register user) {
//		this.user = user;
//	}




	public Order getOrder() {
		return order;
	}




	public void setOrder(Order order) {
		this.order = order;
	}
	
}