package com.bitwise.spring.controller;

public class ProductBean 
{
	
		@Override
	public String toString() {
		return  "	"+ PID +"	"+ prodName +"	"+ prodPrice +"	 "+stock + " \n";
	} 
		private Integer PID;
		private String prodName;
		private Double prodPrice;
		private Integer stock,purchased;
		
		public ProductBean () {}
		
		public ProductBean (Integer pid, String prodName, Double prodPrice, 
				Integer stock,Integer purchased ) 
		{
			this.PID = pid;
			this.prodName = prodName;
			this.prodPrice = prodPrice;
			this.stock = stock;
			this.purchased=purchased;
		}
		
		
		
		public Integer getPurchased() {
			return purchased;
		}

		public void setPurchased(Integer purchased) {
			this.purchased = purchased;
		}

		public Integer getPID() {
			return PID;
		}
		public void setPID(Integer pID) {
			PID = pID;
		}
		public String getProdName() {
			return prodName;
		}
		public void setProdName(String prodName) {
			this.prodName = prodName;
		}
		public Double getProdPrice() {
			return prodPrice;
		}
		public void setProdPrice(Double prodPrice) {
			this.prodPrice = prodPrice;
		}
		public Integer getStock() {
			return stock;
		}
		public void setStock(Integer stock) {
			this.stock = stock;
		}
		
		
	}

	
