package com.bitwise.spring.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
@RequestMapping ("/products")
public class ProductsController {
	cartOper cart = new cartOper();
	List<ProductBean> list = new ArrayList<ProductBean>();
	@RequestMapping (value = "/store", method = RequestMethod.GET)
	public String displayProducts (ModelMap model, @ModelAttribute("products") ProductBean products, BindingResult result, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) 
	{
		model.addAttribute("title", "Products");
		List ormap = (List) new ProductStore().getProducts();
		model.addAttribute("ormap",ormap);
		return "store";
	}

	@RequestMapping (value = "/addtocart", method = RequestMethod.POST)
	public String addtocart (ModelMap model, @ModelAttribute("products") ProductBean products, BindingResult result,
	HttpSession session,HttpServletRequest request, HttpServletResponse response )
	{
		
		String message="";
		String[] pid= request.getParameterValues("PID");
			for(int i=0;i<pid.length;i++)
			{
			ProductBean product = new ProductStore().getProductByProductID(Integer.parseInt(pid[i]));	
			list.add(product);
			
			}
			//list=cart.checkstock(list);
			
			model.addAttribute("list1",list);
			
			return "mycart";
		
}
	@RequestMapping (value = "/finalcart", method = RequestMethod.POST)
	public String finalcart (ModelMap model, @ModelAttribute("products") ProductBean products, BindingResult result,
	HttpSession session,HttpServletRequest request, HttpServletResponse response )
	{
		List<ProductBean> finallist = new ArrayList<ProductBean>();
		String message="";
		String[] pid= request.getParameterValues("PID");
			for(int i=0;i<pid.length;i++)
			{
			ProductBean product = new ProductStore().getProductByProductID(Integer.parseInt(pid[i]));	
			if(product.getStock()==0)
			{
				message = "Out of Stock !!";
			}
			else
			{
				product.setStock(product.getStock()-1);
				product.setPurchased(10-product.getStock());
				product.setProdPrice(product.getProdPrice()*(10-product.getStock()));
				finallist.add(product);
			}
			
		
			}
			
			model.addAttribute("rmlist1",finallist);
			
			return "mycart1";
}
}