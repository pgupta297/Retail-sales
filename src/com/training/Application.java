package com.training;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;


import com.training.models.*;
import com.training.services.ProductServices;
import com.training.utils.ConnectionUtils;

public class Application {
	
	public static void print(List<Product> invList) {
		
		Iterator<Product> itr = invList.iterator();
		int i=1;
		System.out.println("Sl.No.	Item Name	Unit Price	Quantity	Amount");
		while(itr.hasNext()) {
			
			Product inv=itr.next();
			System.out.print(i);
			System.out.println(inv);
			i++;
		}
	}
	

	public static void main(String[] args) {
		

		Edibles eb1 = new Edibles(101,"Oil",100.00,1,"1999-02-18","2021-02-18","veg");
		
		Electronics p1 = new Electronics(1, "Mobile", 7200, 2, "5.6inch", 2, 2.3);
		
		Connection con = ConnectionUtils.getConnectionFromPool();
		
		ProductServices service = new ProductServices(con);
		
//		service.add(p1);
		
		List<Product> list=service.findAll("Edibles","2020-11-11");
		print(list);
		
		List<Product> list1=service.findMax("Edibles");
		print(list1);
	}

}
