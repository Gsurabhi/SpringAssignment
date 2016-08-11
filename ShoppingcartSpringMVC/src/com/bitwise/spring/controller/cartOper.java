package com.bitwise.spring.controller;

import java.util.HashMap;
import java.util.List;

public class cartOper
{
	

	public  List<ProductBean> checkstock(List<ProductBean> list) 
	{
		for(int i=0;i<list.size();i++)
		{
			ProductBean key=list.get(0);
			if(key.getStock()==0)
			{
				System.out.println("out of stock");
				
			}
			else
			{
				
				key.setStock(key.getStock()-1);
				key.setPurchased(10-key.getStock());
				key.setProdPrice(key.getProdPrice()*key.getPurchased());
				
				list.add(key);
				
				
				
			}
			
			
		}
		return list;
		
	}

	

}
