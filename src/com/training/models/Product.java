package com.training.models;

public abstract class Product {
	
	private int pCode;
	private String pName;
	private double unitPrice;
	private int quantity;
	
	public Product() {
		super();
	}

	public Product(int pCode, String pName, double unitPrice, int quantity) {
		super();
		this.pCode = pCode;
		this.pName = pName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}


	public double calculateAmount() {
		
		return unitPrice*quantity;
	}

	public int getpCode() {
		return pCode;
	}

	public void setpCode(int pCode) {
		this.pCode = pCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "	" + pName + "		" + unitPrice + "		" + quantity + "		" + unitPrice*quantity;
	}
	
	
}
