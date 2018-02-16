<%--
  Created by IntelliJ IDEA.
  User: Erycoking
  Date: 1/18/18
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Asset Management System</title>
    <%@include file="partials/stylesheets.jsp"%>
  </head>
  <body>
      <div class="container">
        <div class="offset-md-3 col-md-6">
          <form action="/login" class="form" method="post">
            <div class="form-group">
              <label for="id">ID :</label>
              <input type="text" class="form-control" required name="id" id="id" aria-describedby="id" placeholder="Enter Id">
            </div>
            <div class="form-group">
              <label for="password">Password :</label>
              <input type="password" class="form-control" required name="password" id="password" placeholder="Enter password">
            </div>
              <button type="submit" class="btn btn-primary">Sign In</button>
            <br>
              <p>If you don't have account <a href="/register" class="badge badge-primary">Register</a></p>
          </form>
        </div>
      </div>
      <%@include file="partials/footer.jsp"%>
    <%@include file="partials/script.jsp"%>
  </body>
</html>
