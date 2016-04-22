package com.cui.hao.meta;

public class Product {
	
	private int id;
	
	private double price;
	
	private double buyprice;
	
	private long buyTime;

	private String title;
	
	private String image;
	
	private String summary;
	
	private  String detail;
	
	private boolean isBuy;
	
	private boolean isSell;
	
	public boolean getisBuy() {
		return isBuy;
	}

	public boolean isBuy() {
		return isBuy;
	}

	public void setisBuy(boolean isBuy) {
		this.isBuy = isBuy;
	}

	public boolean isSell() {
		return isSell;
	}

	public void setisSell(boolean isSell) {
		this.isSell = isSell;
	}

	public long getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(long buyTime) {
		this.buyTime = buyTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getBuyprice() {
		return buyprice;
	}

	public void setBuyprice(double buyPrice) {
		this.buyprice = buyPrice;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public  String getDetail() {
		return detail;
	}

	public void setDetail( String detail) {
		this.detail = detail;
	}


	
}
