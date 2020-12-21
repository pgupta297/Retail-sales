package com.training.models;

public class Garments extends Product {

	private String size;
	private String material;
	public Garments() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Garments(int pCode, String pName, double unitPrice, int quantity) {
		super(pCode, pName, unitPrice, quantity);
		// TODO Auto-generated constructor stub
	}


	public Garments(int pCode, String pName, double unitPrice, int quantity, String size, String material) {
		super(pCode, pName, unitPrice, quantity);
		this.size = size;
		this.material = material;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
		
	
}
