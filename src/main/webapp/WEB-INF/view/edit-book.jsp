<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" href="<c:url value="/resources/css/add-book.css" />" rel="stylesheet">
        <meta charset="utf-8" />
        <title>Library Management</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
        rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
        crossorigin="anonymous">
    </head>

    <body>
        <header class="bg-info text-white" id="header" align="center">
            <div class="row">
                <div class="col-9">Library Management System</div>
                <div class="col-2">Welcome ${userName}</div>
                <div class="col-1">
                    <form action="logout">
                        <input type="submit" class="btn btn-outline-light" value="Logout" />
                    </form>
                </div>
            </div>
        </header>

        <div class="ctn container-fluid" align="center">
            <div class="card text-dark bg-light mb-3">
                <div class="heading mt-3">Edit Book Details</div>

                <form:form class="p-4" action="updateBook" modelAttribute="book">
                    <div class="row mt-1">
                        <div class="lbl col-auto mt-1" style="width: 120px;">
                            <form:label path="code">Book Code</form:label>
                        </div>
                        <div class="col-auto">
                            <form:input class="form-control" path="code" readonly="true"
                            placeholder="Enter Book Code" style="width: 20rem;"/>
                        </div>
                        <div class="col-auto mt-1 mb-3" align="left">
                            <form:errors path="code" class="error"/>
                        </div>
                    </div>

                    <div class="row mt-2">
                        <div class="lbl col-auto mt-1" style="width: 120px;">
                            <form:label path="name">Book Name</form:label>
                        </div>
                        <div class="col-auto">
                            <form:input class="form-control" path="name"
                            placeholder="Enter Book Name" style="width: 20rem;"/>
                        </div>
                        <div class="col-auto mt-1 mb-3" align="left">
                            <form:errors path="name" class="error"/>
                        </div>
                    </div>

                    <div class="row mt-2">
                        <div class="lbl col-auto mt-1" style="width: 120px;">
                            <form:label path="author">Book Author</form:label>
                        </div>
                        <div class="col-auto">
                            <form:select class="form-select" path="author" style="width: 20rem;">
                                 <form:option value="None" label="Select Author" />
                                 <form:options items="${authorList}" />
                            </form:select>
                        </div>
                        <div class="col-auto mt-1 mb-3" align="left"">
                            <form:errors path="author" class="error"/>
                        </div>
                    </div>

                    <div class="row mt-2">
                        <div class="lbl col-auto mt-1" style="width: 120px;">
                            <form:label path="date">Added On</form:label>
                        </div>
                        <div class="col-auto">
                            <form:input class="form-control" readonly="true" path="date" style="width: 20rem;"/>
                        </div>
                    </div>
                    <div class="home-btn mt-3">
                        <input type="submit" class="btn btn-info" value="Submit" />
                    </div>
                </form:form>
                <div class="home-btn mb-3 col-auto">
                    <form action="cancel">
                        <input type="submit" class="btn btn-danger" value="Cancel" />
                    </form>
                </div>
            </div>

        <footer class="bg-info text-white" id="footer">Copyright 2020-2021 by Fresher Training</footer>
    </body>
</html>