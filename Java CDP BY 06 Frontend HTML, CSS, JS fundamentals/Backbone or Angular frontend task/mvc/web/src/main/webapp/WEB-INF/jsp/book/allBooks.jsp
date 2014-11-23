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
<div class="row" id="content">
    <div class="span9">
        <div class="pagination  pagination-centered">
            <ul>
                <li><a href="${url}.html?page=1"><<</a></li>
                <c:forEach var="i" begin="1" end="${allPage}" step="1">
                    <li><a href="${url}.html?page=${i}"><c:out value="${i}"/></a></li>
                </c:forEach>
                <li><a href="${url}.html?page=${allPage}">>></a></li>
            </ul>
        </div>

        <table class="table table-striped table-bordered table-hover" border="1">
            <thead>
            <tr>
                <th>Books</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${allBooks}">
                <tr>
                    <td>
                        </br>Название: <c:out value="${item.name}"></c:out>
                        </br>Дата: <c:out value="${item.date}"></c:out>
                        </br>Цена: <c:out value="${item.price}"></c:out>
                        </br>Жанр: <c:out value="${item.genre.genre}"></c:out>
                        </br>Описание: <c:out value="${item.descr}"></c:out>
                        </br>Авторы:
                        <c:forEach var="itemS" items="${item.getAuthorSet()}">
                            </br><c:out value="${itemS.name}"></c:out>
                        </c:forEach>
                        <s:form action="/book/delete.html" modelAttribute="book" method="post" accept-charset="UTF-8">
                            <fieldset>
                                <s:input type="hidden" value="${item.id}" path="id"/>
                                <s:input type="hidden" value="${item.date}" path="date"/>
                                <s:input type="hidden" value="${item.name}" path="name"/>
                                <s:input type="hidden" value="${item.price}" path="price"/>
                                <s:input type="hidden" value="${item.descr}" path="descr"/>
                                <input class="btn btn-link" type="submit" value="Удалить">
                            </fieldset>
                        </s:form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>

</body>


</html>

