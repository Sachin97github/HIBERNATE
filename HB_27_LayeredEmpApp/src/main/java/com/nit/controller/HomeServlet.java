package com.nit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import com.nit.dto.CourierDTO;
import com.nit.service.CourierService;
import com.nit.service.CourierServiceImpl;

@WebServlet("/add")
public class HomeServlet extends HttpServlet{

	  private CourierService service;
	  
	  @Override
	public void init() throws ServletException {
		 service=new CourierServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     
	        CourierDTO dto=new CourierDTO();
		   try
		   {

		        dto.setName(req.getParameter("name"));
		        dto.setDestination(req.getParameter("destination"));
		        dto.setSource(req.getParameter("source"));
		        dto.setCompany(req.getParameter("company"));
	          
			    Integer ratId=service.addCourier(dto);
			    if(ratId!=null)
			    {
			    	  RequestDispatcher rd=req.getRequestDispatcher("result.jsp");
	                  req.setAttribute("msg","Courier Added with id - "+ratId);
	                  rd.forward(req, resp);
			    }
			    else
			    {
			    	  RequestDispatcher rd=req.getRequestDispatcher("result.jsp");
	                  req.setAttribute("msg","Courier Not added");
	                  rd.forward(req, resp);
			    }
		   }
		   catch(Exception ex)
		   {
			   RequestDispatcher rd=req.getRequestDispatcher("result.jsp");  
			   req.setAttribute("msg","Internal Problem has occured");
               rd.forward(req, resp);
	      }
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       doGet(req,resp);
	}
}
