package com.training.models;


public class Edibles extends Product {

	private String mfg;
	private String exp;
	private String foodType;
	
	public Edibles() {
		super();
	}
		
	public Edibles(int pCode, String pName, double unitPrice, int quantity, String mfg, String exp,
			String foodType) {
		super(pCode, pName, unitPrice, quantity);
		this.mfg = mfg;
		this.exp = exp;
		this.foodType = foodType;
	}
	
	
	public Edibles(int pCode, String pName, double unitPrice, int quantity) {
		super(pCode, pName, unitPrice, quantity);
		// TODO Auto-generated constructor stub
	}

	public String getMfg() {
		return mfg;
	}

	public void setMfg(String mfg) {
		this.mfg = mfg;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	
	

}
