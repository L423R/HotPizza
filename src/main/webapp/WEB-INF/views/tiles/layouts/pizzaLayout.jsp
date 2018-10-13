<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title><%--<tiles:getAsString name="title" />--%> PIZZA </title>
    <%--<link href="<c:url value='/resources/css/bootstrap.css' />"  rel="stylesheet"/>--%>
    <link href="<c:url value='/resources/css/pizza_app.css' />" rel="stylesheet"/>
    <script src="<c:url value="/resources/js/jquery-2.1.3.js" />"></script>
    <script src="<c:url value="/resources/js/javascript.js" />"></script>
</head>

<body>
    <section id="wrapper">
        <header id="header">
            <tiles:insertAttribute name="header" />
        </header>


        <section id="site-content">
            <tiles:insertAttribute name="body" />
        </section>

        <footer id="footer">
            <tiles:insertAttribute name="footer" />
        </footer>
    </section>
</body>
</html>