package com.nit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;

import com.nit.dto.InsurancePolicyDTO;
import com.nt.service.PolicyService;
import com.nt.service.PolicyServiceImpl;

@WebServlet(value = "/controller", loadOnStartup = 1)
public class ControllerServlet extends HttpServlet {

	private PolicyService service = null;

	@Override
	public void init() throws ServletException {
		service = new PolicyServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         
		int pageNo=1;
		int pageSize=3;
        int pagesCount=1;
        String target=null;
        HttpSession ses=null;
        
        ses=req.getSession(true);
        String s1Val=req.getParameter("s1");
        if(s1Val.equals("Generate Report"))
        {
        	System.out.println("===============GenerateReport=============");
        	pageSize=Integer.parseInt(req.getParameter("pageSize"));
        	if(ses!=null)
        		ses.setAttribute("pageSize",pageSize);
         }
        else
        {
        	pageNo=Integer.parseInt(req.getParameter("pageNo"));
        	if(ses!=null)
        		pageSize=(int)ses.getAttribute("pageSize");
         }
        try
        {
        	pagesCount=(int) service.getPagesCount(pageSize);
        	List<InsurancePolicyDTO> listDTO=service.getPageData(pageNo, pageSize);     
        	if(ses!=null)
        	{
        		ses.setAttribute("listDTO",listDTO);
        		ses.setAttribute("pagesCount",pagesCount);
        		target="/report.jsp";
        	}
        }
        catch(HibernateException he)
        {
        	target="/error.jsp";
        	he.printStackTrace();
        }
        catch(Exception e)
        {
         	target="/error.jsp";
        	e.printStackTrace();
        }
        RequestDispatcher rd=req.getRequestDispatcher(target);
        rd.forward(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
