<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add todo page</title>
<%@include file="component/all_css.jsp" %>
</head>
<body style="background-color: lightblue;">
<%@include file="component/navbar.jsp" %>
<div class="container">
<div class="row p-5">
<div class="col-md-6 offset-md-3">
<div class="card">
<div class="card-body">

<h3 class="text-center text-success"> Add Todo</h3>
<form action="add_todo" method="post">
<div class="form-group">
    <label for="exampleInputEmail1">NAME</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="username">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">TODO</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="todo">
  </div>
 
 <div class="form-group ">
      <label for="inputState">Status</label>
      <select id="inputState" class="form-control" name="status">
        <option selected>select</option>
        <option value="completed">completed</option>
         <option value="pending">pending</option>
         <option value="yettostart">yet to start</option>
      </select>
    </div>
  <div class="text-center">
  <button type="submit" class="btn btn-primary">Add</button>
  </div>
</form>
</div>
</div>
</div>
</div>
</div>
</body>
</html>