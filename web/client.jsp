<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2/13/18
  Time: 12:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dashboard</title>
    <%@include file="partials/stylesheets.jsp"%>
</head>
<body>
    <div class="container">
        <div class="content">
            <div class="card">
                <div class="card-header">
                    <p class="card-header">My Bookings</p>
                </div>
                <div class="card-body">
                    <div class="table">
                        <table class="table">
                            <thead>
                                <tr>
                                    <td>Equipment Name</td>
                                    <td>Equipment Description</td>
                                    <td>Quantity available</td>
                                    <td>From</td>
                                    <td>To</td>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="x" items="bk">
                                    <tr>
                                        <td>${x.eq.eqpname}</td>
                                        <td>${x.eq.eqpdetails}</td>
                                        <td>${x.eq.quantity}</td>
                                        <td>${x.from}</td>
                                        <td>${x.to}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header">
                    <p class="lead">Equipments</p>
                </div>
                <div class="card-body">
                    <div class="table">
                        <table class="table">
                            <thead>
                                <tr>
                                    <td>Equipment Name</td>
                                    <td>Equipment Description</td>
                                    <td>Quantity available</td>
                                    <td>Action</td>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="items" items="eq" >
                                    <tr>
                                        <td>${item.eqpname}</td>
                                        <td>${item.eqpdetails}</td>
                                        <td>${item.quantity}</td>
                                        <td><a href="/book?id=${item.id}" class="btn btn-primary">Book</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="partials/footer.jsp"%>
    </div>
<%@include file="partials/script.jsp"%>
</body>
</html>
