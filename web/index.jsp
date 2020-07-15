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
  <title>List Page</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<div class="row">
  <div class="container">
    <h3 class="text-center">Roomers</h3>
    <table class="table table-bordered">
      <thead>
      <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Second Name</th>
        <th>Age</th>
        <th>Living period</th>
      </tr>
      </thead>
      <tbody>
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
      </tbody>

    </table>
    <h3 class="text-center">Rooms</h3>
    <table class="table table-bordered">
      <thead>
      <tr>
        <th>ID</th>
        <th>Number</th>
        <th>Room type</th>
        <th>Available</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="room" items="${listRoom}">
        <tr>
          <td>
            <c:out value="${room.id}" />
          </td>
          <td>
            <c:out value="${room.number}" />
          </td>
          <td>
            <c:out value="${room.room_type}" />
          </td>
          <td>
            <c:out value="${room.available}" />
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>
</body>

</html>
