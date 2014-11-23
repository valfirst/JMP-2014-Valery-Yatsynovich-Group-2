<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <link href="../../../assests/style/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="../../../assests/style/style.css" rel="stylesheet " type="text/css">
    <script type="text/javascript" src="../../../assests/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="../../../assests/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <![CDATA[
    <script src="../../../assests/js/jquery-1.11.1.min.js" type="text/javascript"><jsp:text/></script>
    <script src="../../../assests/js/utils.js" type="text/javascript"><jsp:text/></script>

    <tiles:useAttribute id="title" name="title"/>
    <c:if test="${not empty title}">
        <title>${title}</title>
    </c:if>
</head>

<body>
<div class="container">

    <tiles:insertAttribute name="header"/>
    <div class="row" id="content">
        <tiles:insertAttribute name="sidebar"/>
        <tiles:insertAttribute name="body"/>
    </div>
    <tiles:insertAttribute name="footer"/>
</div>
</body>


</html>

