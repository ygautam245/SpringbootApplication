<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Library Management</title>

        <link type="text/css" href="<c:url value="/resources/css/login.css" />" rel="stylesheet">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
        crossorigin="anonymous">
    </head>

    <body>
        <header class="bg-info text-white" id="header" align="center">Library Management System</header>
        <div class="ctn container-fluid" align="center">
            <div class="card text-dark bg-light mb-5">
                <div class="heading">
                    <div class = "row">
                        <label class="form-label"><h2>Login</h2></label>
                        <label class="form-label">Manage Books Easily</label>
                    </div>
                </div>
                <div class="mb-3 mt-4">
                    <form:form action="validateUser" method="post" modelAttribute="librarian">
                        <div>
                            <form:input class="inp form-control" path="userName"
                            placeholder="Enter Username" style="width: 20rem;"/>
                        </div>
                        <div class="mb-3" align="left">
                            <form:errors path="userName" class="error"/>
                        </div>
                        <div>
                            <form:input class="inp form-control" type="password" path="password"
                            placeholder="Enter Password" style="width: 20rem;"/>
                        </div>
                        <div class="mb-3" align="left">
                            <form:errors path="password" class="error" />
                        </div>
                        <div class="log-btn d-grid gap-2">
                            <input type="submit" class="btn btn-primary mb-3" value="Login" />
                        </div>
                        <div>
                            <label class="sign-link form-label"><a href="signup" modelAttribute="librarian">Don't have an account?
                            </a></label>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
