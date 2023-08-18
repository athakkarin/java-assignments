package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bean.Cart;
import com.bean.Item;
import com.dao.CartDao;


@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("insert cart"))
		{
			Cart c=new Cart();
			c.setName(request.getParameter("name"));
			c.setTotal(Double.parseDouble(request.getParameter("total")));
			CartDao.insertCart(c);
			
			response.sendRedirect("cart.jsp");
		}
		
		else if(action.equalsIgnoreCase("insert item"))
		{
			Item i=new Item();
			i.setItemId(request.getParameter("itemId"));
			i.setItemTotal(Double.parseDouble(request.getParameter("itemTotal")));
			i.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			int cartId=Integer.parseInt(request.getParameter("cart"));
			i=CartDao.getCart(cartId);
			CartDao.insertItem(i);
			response.sendRedirect("item.jsp");
		}
		
		else if(action.equalsIgnoreCase("edit"))
		{
			int itemId=Integer.parseInt(request.getParameter("itemId"));
			Item i=CartDao.getCart(itemId);
			request.setAttribute("i", i);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
		
		else if(action.equalsIgnoreCase("update"))
		{
			Cart c=new Cart();
			c.setName(request.getParameter("name"));
			Item i=new Item();
			i.setItemId(request.getParameter("itemId"));
			CartDao.updateItem(i);
			
			response.sendRedirect("show.jsp");
		}
		
		else if(action.equalsIgnoreCase("delete"))
		{
			int cartId=Integer.parseInt(request.getParameter("cartId"));
			CartDao.deleteCart(cartId);
			response.sendRedirect("show.jsp");
		}
	}

}
