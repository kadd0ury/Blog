<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>add users</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>

<div class="container">
    <jsp:directive.include file="../layout/header.jsp" />
    <header class="col-lg-12">
        <h1>ajouter un utilisateur</h1>
        <form:form method="post" action="${pageContext.request.contextPath}/user/save" modelAttribute="user" >
            <form:input path="id" type="hidden" />
            
            <div class="form-group">
                <label for="title">Nom : </label>
                <form:input path="nom" cssClass="form-control"/>
                <form:errors path="nom" cssClass="alert-danger" />
            </div>
            
            <div class="form-group">
                <label for="body">Prénom : </label>
                <form:input path="prenom" cssClass="form-control"/>
                <form:errors path="prenom" cssClass="alert-danger" />
            </div>
               
               <div class="form-group">
                <label for="body">Email : </label>
                <form:input path="email" cssClass="form-control"/>
                <form:errors path="email" cssClass="alert-danger" />
            </div>
            
              <div class="form-group">
                <label for="body">Role : </label>
            <form:select path="role" items="${role}" cssClass="form-control"></form:select>
              <form:errors path="role" cssClass="alert-danger" />
            </div>
            
               <div class="form-group">
                <label for="body">Password : </label>
            <form:password path="password" cssClass="form-control"/>
              <form:errors path="password" cssClass="alert-danger" />
            </div>
            <input type = "submit" value = "Submit"/>
        </form:form>
    </header>
</div>
</body>
</html>
