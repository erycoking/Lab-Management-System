<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2/12/18
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <%@include file="partials/stylesheets.jsp" %>
</head>
<body>
<div class="container">
    <div class="content">
        <div class="col-md-6 offset-md-3">
            <div class="row justify-content-center">
                <p class="lead">Register</p>
            </div>
            <div class="card-body">
                <div class="form">
                    <form action="/register" role="form" method="post" class="form">
                        <div class="form-group">
                            <label for="id">ID :</label>
                            <p class="bg-danger">${useridErrMsg}</p>
                            <input type="text" class="form-control" name="user_id" id="id">
                        </div>
                        <div class="form-group">
                            <label for="name">Name :</label>
                            <p class="bg-danger">${nameErrMsg}</p>
                            <input type="text" class="form-control" name="name" id="name">
                        </div>
                        <div class="form-group">
                            <label for="password">Password :</label>
                            <p class="bg-danger">${passwordErrMsg}</p>
                            <input type="password" class="form-control" name="password" id="password">
                        </div>
                        <div class="form-group">
                            <label for="cpassword">Confirm password : </label>
                            <input type="password" class="form-control" name="cpassword" id="cpassword">
                        </div>
                        <div class="form-group">
                            <label for="faculty">Faculty :</label>
                            <p class="bg-danger">${facultyErrMsg}</p>
                            <input type="text" class="form-control" name="faculty" id="faculty">
                        </div>
                        <div class="form-group">
                            <label for="department">Department :</label>
                            <p class="bg-danger">${departmentErrMsg}</p>
                            <input type="text" class="form-control" name="department" id="department">
                        </div>
                        <div class="form-group">
                            <label for="faculty">email :</label>
                            <p class="bg-danger">${emailErrMsg}</p>
                            <input type="text" class="form-control" name="email" id="email">
                        </div>
                        <div class="form-group">
                            <input type="hidden" id="role" name="role" value="technician">
                        </div>
                        <div>
                            <input type="submit" class="btn btn-block btn-primary" value="Register">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%@include file="partials/footer.jsp" %>
</div>
<%@include file="partials/script.jsp" %>
</body>
</html>
