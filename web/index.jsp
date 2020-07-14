<%--
  Created by IntelliJ IDEA.
  User: Тарас
  Date: 14.07.2020
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <title>User Management Application</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<header>
  <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #47f0ff">
    <div>
      <a href="https://www.javaguides.net" class="navbar-brand"> User
        Management App </a>
    </div>

    <ul class="navbar-nav">
      <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Roomers</a></li>
    </ul>
  </nav>
</header>
<br>

<div class="row">
  <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

  <div class="container">
    <h3 class="text-center">List of Users</h3>
    <hr>
    <div class="container text-left">

      <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
        New User</a>
    </div>
    <br>
    <table class="table table-bordered">
      <thead>
      <tr>
        <th>ID</th>
        <th>F Name</th>
        <th>S Name</th>
        <th>Age</th>
        <th>living period</th>
      </tr>
      </thead>
      <tbody>
      <!--   for (Todo todo: todos) {  -->
      <c:forEach var="roomer" items="${listRoomer}">

        <tr>
          <td>
            <c:out value="${roomer.id}" />
          </td>
          <td>
            <c:out value="${roomer.first_name}" />
          </td>
          <td>
            <c:out value="${roomer.second_name}" />
          </td>
          <td>
            <c:out value="${roomer.age}" />
          </td>
          <td>
            <c:out value="${roomer.nationality}" />
          </td>

        </tr>
      </c:forEach>
      <!-- } -->
      </tbody>

    </table>
  </div>
</div>
</body>

</html>
