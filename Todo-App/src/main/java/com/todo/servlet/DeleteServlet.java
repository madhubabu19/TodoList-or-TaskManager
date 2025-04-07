package com.todo.servlet;

import java.io.IOException;

import com.todo.dao.TodoDAO;
import com.todo.db.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	int id=Integer.parseInt(req.getParameter("id"));
	TodoDAO dao=new TodoDAO(DBConnect.getConn());
	 boolean f=dao.deleteTodo(id);
	
	
    HttpSession session=req.getSession();
	
	if(f)
	{
		session.setAttribute("sucMsg", "to do deleted  successfully");
		
		resp.sendRedirect("index.jsp");
	}
	else
	{
		session.setAttribute("failMsg", "some thing wrong on server ");
		resp.sendRedirect("index.jsp");
	}		
	
    

}
}
