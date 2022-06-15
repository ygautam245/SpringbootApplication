<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" href="<c:url value="/resources/css/homepage.css" />" rel="stylesheet">
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
            <div class="row mt-4 mb-4">
                <div class="col-9 mt-1 heading">Books Listing</div>
                <div class="col-2">
                    <form action="addBook">
                        <input type="submit" class="btn btn-info" value="Add a book" />
                    </form>
                </div>
            </div>

            <div>
                <table class="table table-striped table-hover">
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Author</th>
                        <th>Date</th>
                        <th>Actions</th>
                    </tr>
                    <c:forEach var="book" items="${bookList}">
                        <tr>
                           <td>${book.code}</td>
                           <td>${book.name}</td>
                           <td>${book.author}</td>
                           <td>${book.date}</td>
                           <td>
                             <a href="editBook?code=<c:out value='${book.code}' />">Edit</a>
                             <a href="deleteBook?code=<c:out value='${book.code}' />">Delete</a>
                           </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div class="footer fixed-bottom pt-1">
        <footer class="bg-info text-white" id="footer">Copyright 2020-2021 by Fresher Training</footer>
        </div>
    </body>
</html>
