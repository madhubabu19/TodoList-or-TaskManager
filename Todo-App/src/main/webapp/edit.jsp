<%@page import="com.todo.dao.TodoDAO"%>
<%@page import="com.todo.entity.TodoDtls"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.todo.db.DBConnect"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit page</title>
<%@include file="component/all_css.jsp" %>
</head>
<body style="background-color: lightblue;">
<%@include file="component/navbar.jsp" %>
<div class="container">
<div class="row p-5">
<div class="col-md-6 offset-md-3">
<div class="card">
<div class="card-body">

<h3 class="text-center text-success"> Update Todo</h3>
<%
int id=Integer.parseInt(request.getParameter("id"));
TodoDAO dao=new TodoDAO(DBConnect.getConn());
TodoDtls t=dao.getTodoById(id);


%>



<form action="update" method="post">
<input type="hidden" value="<%=t.getId() %>" name="id">
<div class="form-group">
    <label for="exampleInputEmail1">NAME</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="username" value="<%=t.getName()%>">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">TODO</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="todo" value="<%=t.getTodo()%>">
  </div>
 
 <div class="form-group ">
      <label for="inputState">Status</label>
      <select id="inputState" class="form-control" name="status">
      <% if("pending".equals(t.getStatus()))
      {%>
           <option value="pending">pending</option>
    	   <option value="completed">completed</option>
           <option value="yettostart">yet to start</option>
     <%  }else{%>
    	  <option value="completed">completed</option>
         <option value="pending">pending</option>
         <option value="yettostart">yet to start</option>
     <%  }
      %>
        
     </select>
    </div>
  <div class="text-center">
  <button type="submit" class="btn btn-primary">Update</button>
  </div>
</form>
</div>
</div>
</div>
</div>
</div>
</body>
</html>