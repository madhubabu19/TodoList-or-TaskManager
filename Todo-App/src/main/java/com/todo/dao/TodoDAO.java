package com.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.todo.entity.TodoDtls;

public class TodoDAO {
	private Connection conn;

	public TodoDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean addTodo(String name,String todo,String status)
	{
		boolean f= false;
		try {
			
			String sql="insert into todo_app(name,todo,status) values(?,?,?)";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, todo);
			ps.setString(3,status);
			
			int i=ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
		
		public List<TodoDtls> getTodo()
		{
			List<TodoDtls> list=new ArrayList<TodoDtls>();
			
			TodoDtls t=null; //creating reference for todoDtls  class 
			try {
				String sql="select * from todo_app";//sql query
				PreparedStatement ps= conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					t=new TodoDtls();
					t.setId(rs.getInt(1));
					t.setName(rs.getString(2));
					t.setTodo(rs.getString(3));
					t.setStatus(rs.getString(4));
					list.add(t);
				}
				
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return list;
			
		}
		
		public TodoDtls getTodoById(int id)
		{
			TodoDtls t =null;
			try {
				String sql="select * from todo_app where id=?";
				PreparedStatement pt= conn.prepareStatement(sql);
				pt.setInt(1, id);
				ResultSet rs=pt.executeQuery();
				
				while(rs.next())
				{

					t=new TodoDtls();
					t.setId(rs.getInt(1));
					t.setName(rs.getString(2));
					t.setTodo(rs.getString(3));
					t.setStatus(rs.getString(4));
					
				}
				
				
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return t;
		}
		
		public boolean updateTodo(TodoDtls t)
		{
			boolean f= false;
			try {
				String sql="update todo_app set name=?,todo=?,status=? where id=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1,t.getName());
				ps.setString(2,t.getTodo());
				ps.setString(3,t.getStatus());
				ps.setInt(4,t.getId());
				
				int i=ps.executeUpdate();
				if(i==1)
				{
					f=true;
				}
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return f;
			
		}
		
		public boolean deleteTodo(int id)
		{
			boolean f= false;
			try {
				String sql="delete from  todo_app where id=?";
				PreparedStatement ps=conn.prepareStatement(sql);
			
				ps.setInt(1,id);
				
				int i=ps.executeUpdate();
				if(i==1)
				{
					f=true;
				}
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return f;
			
		}
		
	

}
