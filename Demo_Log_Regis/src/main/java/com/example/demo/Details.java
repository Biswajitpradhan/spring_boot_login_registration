package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Details {
	@Id
	private Integer cardId;
	private String name;
	private String password;
	private String fee;
	private String address;
	
	public Integer getCardid() {
		return cardId;
	}
	public void setCardid(Integer cardid) {
		this.cardId = cardid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
