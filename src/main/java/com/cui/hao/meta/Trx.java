package com.cui.hao.meta;

public class Trx {
	
	int id;
	
	int contentId;
	
	int personId;
	
	double price;
	
	long time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return contentId;
	}

	public void setProductId(int contentId) {
		this.contentId = contentId;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int userId) {
		this.personId = userId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getBuyTime() {
		return time;
	}

	public void setTime(long buyTime) {
		this.time = buyTime;
	}

}
