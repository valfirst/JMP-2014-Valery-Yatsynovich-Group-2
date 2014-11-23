<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>


<%@page import="java.util.Iterator" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>

<body>
<table class="table table-striped table-bordered table-hover" border="1">
    <thead>

    </thead>
    <tbody>
    <form action="/book/addNewBook.html" method="post">
        <p>
            name:<input name="name" type="text"/><br>
            author:<select name="idAuthor">
            <c:forEach var="itemAuthor" items="${listAuthor}">
                <option value="${itemAuthor.id}"><c:out value="${itemAuthor.name}"></c:out></option>
            </c:forEach>
        </select><br>
            date:<input name="date"><br>
            price:<input name="price"><br>

            genre:<select name="idGenre">
            <c:forEach var="itemGenre" items="${listGenres}">
                <option value="${itemGenre.id}"><c:out value="${itemGenre.genre}"></c:out></option>
            </c:forEach>
        </select><br>
            descr:<br>
            <textarea rows="15" cols="80" name="descr"></textarea>
            <br>
            <input type="submit">
        </p>
    </form>
    </tbody>
</table>
</body>
</html>