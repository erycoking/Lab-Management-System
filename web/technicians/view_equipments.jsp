<%--
  Created by IntelliJ IDEA.
  User: Erycoking
  Date: 1/20/18
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Asset Management System</title>
    <%@include file="../partials/stylesheets.jsp"%>
</head>
<body>
    <div class="container">
        <div class="container">
            <div class="content">
                <h3 class="text-capitalize text-center">lab equipments</h3>
                <table class="table table-dark table-bordered">
                    <thead>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Cost</th>
                        <th>Quantity</th>
                        <th>Category</th>
                        <th>Date created</th>
                        <th colspan="2" class="text-center">Action</th>
                    </thead>
                    <tbody>
                    <c:forEach items="${data}" var="item" >
                        <tr>
                            <td>${item.eqpname}</td>
                            <td>${item.eqpdetails}</td>
                            <td>${item.eqpcost}</td>
                            <td>${item.quantity}</td>
                            <td>${item.eqpCategory}</td>
                            <td>${item.last_calibration}</td>
                            <td><a href="/edit?id=${item.eqp_id}" class="btn btn-primary">Edit</a></td>
                            <td><a href="/delete?id=${item.eqp_id}" class="btn btn-primary">Delete</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div>
                    <p>${message}</p>
                </div>
            </div>
        <%@include file="../partials/footer.jsp"%>
    </div>
<%@include file="../partials/script.jsp"%>
</body>
</html>
