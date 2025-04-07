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
<title>Home page</title>
<%@include file="component/all_css.jsp" %>
</head>
<body>
<%@include file="component/navbar.jsp" %>



<h1 class="text-center text-success"> todo-app</h1>
<%
String sucMsg=(String) session.getAttribute("sucMsg");
if (sucMsg !=null){
%>
<div class="alert alert-success" role="alert"><%=sucMsg%></div>
<%
session.removeAttribute("sucMsg");
}
%>



<%
String failMsg=(String) session.getAttribute("sucMsg");
if (failMsg !=null){
%>
<div class="alert alert-success" role="alert"><%=failMsg%></div>
<%
session.removeAttribute("failedmsg");
}
%>

<div class="container">
<table class="table table-striped" border="">
  <thead class="bg-success text-white">
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Todo</th>
      <th scope="col">Status</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <%
   TodoDAO dao=new TodoDAO(DBConnect.getConn());
  List<TodoDtls> todo =dao.getTodo();
 // List<TodoDtls> todo= dao.getTodo();
  for(TodoDtls t: todo){
  %>
    <tr>
      <th scope="row"><%=t.getId() %></th>
       <th scope="col"><%=t.getName()%></th>
      <td><%=t.getTodo()%></td>
      <td><%=t.getStatus()%></td>
      <td>
      <a href="edit.jsp?id=<%=t.getId() %>" class="btn btn-sm btn-success">Edit</a>
      <a href="delete?id=<%=t.getId() %>" class="btn btn-sm btn-danger">Delete</a>
      </td>
    </tr>
    <%
    }
    %>
  
  </tbody>
</table>
</div>


</body>
</html>