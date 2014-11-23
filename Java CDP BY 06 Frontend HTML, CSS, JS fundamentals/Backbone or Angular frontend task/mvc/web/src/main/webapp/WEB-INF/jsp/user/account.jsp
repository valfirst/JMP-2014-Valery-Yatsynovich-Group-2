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


        <table class="table table-striped table-bordered table-hover" border="1">
            <form action="/account.html" method="post" accept-charset="UTF-8">
                <p>
                    max book on page:<select name="max">
                    <option value="1">1</option>
                    <option value="3">3</option>
                    <option value="5">5</option>
                </select><br>
                    <input class="btn btn-link" type="submit" value="Max">
                </p>
            </form>
        </table>

    </div>
</div>

</body>


</html>

