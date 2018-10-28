package com.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.model.Product;
import com.product.service.ProductService;
import com.product.service.ProductServiceImpl;

public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService prodService = null;
		RequestDispatcher rd= null;
		
		String option = request.getParameter("menu");
		
		if(option.equals("add")) {
			String url = null;
			
			Product prod = new Product();
			prod.setId(request.getParameter("id"));
			prod.setName(request.getParameter("name"));
			prod.setPrice(Double.parseDouble(request.getParameter("price")));
			prod.setDescription(request.getParameter("description"));
			
			prodService = new ProductServiceImpl();
			boolean status = prodService.saveProduct(prod);
			if(!status) {
				url="AddProduct.jsp?msg=Product Id Already exists.Product is Not Added";	
				}else {
					url="AddProduct.jsp?msg=Product Added Successfully";
				}
			
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
		
		if(option.equals("list")) {
			String url = null;
			
			List<Product> productList = new ArrayList<>();
			prodService = new ProductServiceImpl();
			productList = prodService.listAll();
			
			
			if(productList.size() != 0) {
				request.setAttribute("products", productList);
				url = "Display.jsp";
			}
			else url = "Display.jsp?msg=No records found";
			
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
		
		if(option.equals("find")) {
			String url = null;
			
			prodService = new ProductServiceImpl();
			Product prod = prodService.findProduct(request.getParameter("id"));
			
		
			List<Product> productList = new ArrayList<>();
			productList.add(prod);
			if(prod != null){
				request.setAttribute("products", productList);
				url = "Display.jsp";
			}
			else url = "Display.jsp?msg=No records found";
				
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
			
		if(option.equals("updateRequest")){
			String url = null;
			
			prodService = new ProductServiceImpl();
			Product prod = prodService.findProduct(request.getParameter("id"));
			if(prod != null){
				request.setAttribute("product", prod);
				url = "Update.jsp";
			}
			else url = "UpdateRequest.jsp?msg=No records found";
				
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
				
		}
			
		if(option.equals("update")){
			String url = null;
			
			Product prod = new Product();
			prod.setId(request.getParameter("id"));
			prod.setName(request.getParameter("name"));
			prod.setPrice(Double.parseDouble(request.getParameter("price")));
			prod.setDescription(request.getParameter("description"));
			
			prodService = new ProductServiceImpl();
			boolean status = prodService.updateProduct(prod);
			if(status) url="Update.jsp?msg=Product details updated";	
				
			
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
		
		if(option.equals("deleteRequest")){
			List<Product> productList = new ArrayList<>();
			prodService = new ProductServiceImpl();
			productList = prodService.listAll();
			
			request.setAttribute("products", productList);
			
			rd = request.getRequestDispatcher("Delete.jsp");
			rd.forward(request, response);
		}
		
		if(option.equals("delete")){
			String url = null;
			prodService = new ProductServiceImpl();
			boolean status = prodService.deleteProduct(request.getParameter("id"));
			if(status) url="Display.jsp?msg=Product deleted";	
				
			
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
			
	}
}

