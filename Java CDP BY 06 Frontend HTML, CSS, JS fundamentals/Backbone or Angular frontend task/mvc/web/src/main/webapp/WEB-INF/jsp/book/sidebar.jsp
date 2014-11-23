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

<div class="span3 sidebar">
    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu" id="sidebar-menu">
        <li>
            <form action="/account.html" method="post" accept-charset="UTF-8">
                <p>
                    <input class="btn btn-link" type="submit" value="Личный кабинет">
                </p>

            </form>
        </li>

        <li class="divider"></li>
        <li>
            <form id="search" action="/book/main.html" method="post" accept-charset="UTF-8">
                <p>
                    <input type="text" placeholder="find book" name="contextSearch"/></br>
                    <input class="btn btn-link" type="submit" value="Search">
                </p>
            </form>
        </li>

        <c:forEach var="item" items="${allGenres}">
            <li>
                <s:form id="genres" name="genres" modelAttribute="genres" action="/book/genres.html" method="post">
                    <fieldset>
                        <s:input id="id" type="hidden" value="${item.id}" path="id"/>
                        <s:input id="genre" type="hidden" value="${item.genre}" path="genre"/>
                        <input class="btn btn-link" type="submit" value="${item.genre}"/>
                    </fieldset>
                </s:form>
            </li>
        </c:forEach>


        <li>
            <form action="/book/add-genre.html" method="post">
                <p>
                    <input type="text" name="add-genre" placeholder="Add genre" value=""/>
                    <input class="btn btn-link" type="submit" value="Добавить жанр"/>
                </p>

                </form>
        </li>


        <li class="divider"></li>
        <li>
            <form action="/book/addBook.html" method="post" accept-charset="UTF-8">
                <p>
                    <input class="btn btn-link" type="submit" value="Добавить книгу">
                </p>

            </form>
        </li>

        <li>
            <form action="/book/main.html" method="post" accept-charset="UTF-8">
                <p>
                    <input type="hidden" name="operation" value="allBooks">
                    <input class="btn btn-link" type="submit" value="Все Книги">
                </p>
            </form>
        </li>

        <li class="divider"></li>
        <li>
            <form action="/book/main.html" method="post" accept-charset="UTF-8">
                <p>
                    <input type="hidden" name="contextSorted" value="name">
                    <input class="btn btn-link" type="submit" value="Сортировать по названию">
                </p>
            </form>
        </li>

        <li>
            <form action="/book/main.html" method="post" accept-charset="UTF-8">
                <p>
                    <input type="hidden" name="contextSorted" value="price">
                    <input class="btn btn-link" type="submit" value="Сортировать по цене">
                </p>
            </form>
        </li>

        <li>
            <form action="/book/main.html" method="post" accept-charset="UTF-8">
                <p>
                    <input type="hidden" name="contextSorted" value="genre">
                    <input class="btn btn-link" type="submit" value="Сортировать по жанру">
                </p>
            </form>
        </li>

    </ul>

</div>


</body>


</html>
<body>

</body>
</html>
