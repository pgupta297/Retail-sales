package com.training.models;

public class Electronics extends Product {

	private String size;
	private int warranty;
	private double wattage;
	public Electronics() {
		super();
	}
	public Electronics(int pCode, String pName, double unitPrice, int quantity, String size, int warranty,
			double wattage) {
		super(pCode, pName, unitPrice, quantity);
		this.size = size;
		this.warranty = warranty;
		this.wattage = wattage;
	}
	
	public Electronics(int pCode, String pName, double unitPrice, int quantity) {
		super(pCode, pName, unitPrice, quantity);
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getWarranty() {
		return warranty;
	}
	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}
	public double getWattage() {
		return wattage;
	}
	public void setWattage(double wattage) {
		this.wattage = wattage;
	}
		
}
