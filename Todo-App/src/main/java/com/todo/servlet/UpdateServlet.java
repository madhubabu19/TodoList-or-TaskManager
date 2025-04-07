package com.todo.servlet;


import java.io.IOException;

import com.todo.dao.TodoDAO;
import com.todo.db.DBConnect;
import com.todo.entity.TodoDtls;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String username = req.getParameter("username");
		String todo=req.getParameter("todo");
		String status= req.getParameter("status");
		TodoDAO  dao=new TodoDAO(DBConnect.getConn());
		
		TodoDtls t=new TodoDtls();
		t.setId(id);
	    t.setName(username);
	    t.setStatus(status);
	    t.setTodo(todo);
	    
	    
		boolean f=dao.updateTodo(t);
          HttpSession session=req.getSession();
		
		if(f)
		{
			session.setAttribute("sucMsg", "to do updated  successfully");
			
			resp.sendRedirect("index.jsp");
		}
		else
		{
			session.setAttribute("failMsg", "some thing wrong on server ");
			resp.sendRedirect("index.jsp");
		}		
		
	}
	

}
