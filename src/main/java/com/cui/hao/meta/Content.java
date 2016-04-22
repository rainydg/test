package com.cui.hao.meta;

public class Content {
	
private int id;
	
	private double price;
	
	private double buyprice;
	
	private String title;
	
	private String image;
	
	private long buyTime;
	
	private String summary;
	
	private String detail;
	
	private boolean isBuy;
	
	private boolean isSell;

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

	public double getBuyPrice() {
		return buyprice;
	}

	public void setBuyPrice(double buyPrice) {
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

	public String  getDetail() {
		return detail;
	}

	public void setDetail(String  detail) {
		this.detail = detail;
	}

	public boolean isBuy() {
		return isBuy;
	}

	public void setBuy(boolean isBuy) {
		this.isBuy = isBuy;
	}

	public boolean isSell() {
		return isSell;
	}

	public void setSell(boolean isSell) {
		this.isSell = isSell;
	}

}
