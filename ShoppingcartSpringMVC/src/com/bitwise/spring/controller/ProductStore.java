package com.bitwise.spring.controller;

import java.util.ArrayList;
import java.util.List;

public class ProductStore {


	private List<ProductBean> products = new ArrayList<ProductBean>();

	public ProductStore()
	{
		this.initProdcts();
	}

	public void initProdcts() {
		products.add(new ProductBean(1, "Bottles", 562.00d,10 ,0));
		products.add(new ProductBean(2, "Shirts", 28.00d, 10 ,0));
		products.add(new ProductBean(3, "Apples", 112.00d,  10,0));
		products.add(new ProductBean(4, "Oats", 11.00d,  10,0));
		products.add(new ProductBean(5, "Lenin", 56.00d,  10,0));
		products.add(new ProductBean(6, "Jeans", 109.00d, 10,0));

	}
	
	public List<ProductBean> getProducts () 
	{
		return this.products;
	}
	
	public ProductBean getProductByProductID (Integer pid) {
		ProductBean product = null;
		for (ProductBean prod: new ProductStore().getProducts()) {
			if (prod.getPID() == pid) {
				product = prod;
			}
		}
		return product;
	}

}


