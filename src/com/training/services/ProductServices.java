package com.training.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.training.models.Edibles;
import com.training.models.Electronics;
import com.training.models.Garments;
import com.training.models.Product;

public class ProductServices {

//	Logger log = Logger.getLogger(this.getClass().getName());
	
	private Connection connection;

	
	public ProductServices() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductServices(Connection connection) {
		super();
		this.connection = connection;
	}
	
	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}

	public boolean add(Product t) {

		int rowAdded = 0;
		String sql="";
		if(t instanceof Edibles) {
			sql ="insert into Edibles values(?,?,?,?,?)";
		} 
		else if(t instanceof Garments) {
			sql ="insert into Garments values(?,?,?,?,?)";
		}
		else if(t instanceof Electronics){
			sql ="insert into Electronics values(?,?,?,?,?)";
		}
		else {
			log.error("Doesn't belong to your Application... Enjoy!!!!");
		}
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql);){
		
		pstmt.setString(1,t.getpName());
		pstmt.setDouble(2,t.getUnitPrice());
		pstmt.setInt(3,t.getQuantity());
		pstmt.setInt(4,t.getpCode());
				pstmt.setDate(5,getCurrentDate());
				
		rowAdded = pstmt.executeUpdate();
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return rowAdded>0?true:false;
	}
	
	public List<Product> findAll(String obj, String dt) {
		
		String sql = "select * from " + obj +" where dateofPrchs = '"+ dt +"'";
		
		List<Product> list = new ArrayList<Product>();
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql);){
			
	//		pstmt.setString(1, t);
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				
				Product newInv = rowMapper(rs, obj);
				list.add(newInv);
			}
			
		} catch (Exception e) {
			
			log.debug("Catch block interrupted");
			e.printStackTrace();
		}
		
		return list;
	}
	
	private Product rowMapper(ResultSet tableSet, String obj) throws SQLException {
		
		log.info("I m in rowMapper");
		
		int qty = tableSet.getInt("qty");
		String pName = tableSet.getString("productName");
		double unitPrice  = tableSet.getDouble("unitPrice");
		int pCode  = tableSet.getInt("pCode");
		
		Product newInv;
		
		if(obj.equals("Edibles")){
			newInv = new Edibles(pCode, pName, unitPrice, qty);
		}
		else if(obj.equals("Electronics")){
			newInv = new Electronics(pCode, pName, unitPrice, qty);
		}
		else {
			newInv = new Garments(pCode, pName, unitPrice, qty);
		}
		return newInv;
	}
	
	public List<Product> findMax(String obj) {
		
		String sql = "select * from " + obj +" ORDER BY qty DESC limit 3";
		
		List<Product> list = new ArrayList<Product>();
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql);){
						
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				
				Product newInv = rowMapper(rs, obj);
				list.add(newInv);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
