<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="xf" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title></title>
</head>
<body>
    <table>
        <thead />
        <tbody>
        <form action="/editBookmark" method="post">
            <p>
                title:<textarea rows="4" cols="10">${bookmark.title}</textarea>
                url:<textarea rows="4" cols="10">${bookmark.url}</textarea>
                user:<select name="user">
                <c:forEach var="itemUser" items="${allUsers}">
                    <option value="${itemUser.id_user}" selected="${bookmark.user}">
                        <c:out value="${itemUser.last_name}" />
                    </option>
                </c:forEach>
                </select><br>
                tag:<select name="tag">
                <c:forEach var="itemTag" items="${allTags}">
                    <option value="${itemTag.id_tags}">
                        <c:out value="${itemTag.tagname}" />
                    </option>
                </c:forEach>
            </select>
                <br>
                <input type="submit" value="Edit bookmark">
            </p>
        </form>
        </tbody>
    </table>
</body>
</html>
