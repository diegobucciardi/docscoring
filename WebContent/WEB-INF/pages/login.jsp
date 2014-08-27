<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ include file="includesJSTL.jsp" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Document Scoring - LOGIN Page</title>
	</head>
	<body>
	   <div id="header" class="header">
	       <h1>Bienvenido al Scoring de Documentos</h1>
	   </div>
	   <form:errors path="*" cssClass="errorblock" element="div" />
	   <form:form action="login" method="post" commandName="loginForm">
		   <div  align="center">
		       <label for="company">Elige tu empresa: </label>
			   <form:select path="company" title="Select a company" cssClass="select" cssErrorClass="fieldError">
				   <form:option value="" label="Select a company" />
				   <form:options items="${companies}" itemLabel="name" itemValue="id"/>
			   </form:select>
			   <form:errors path="company" cssClass="error" />
			   <br/>
			   <label for="userName">Nombre de usuario: </label>
			   <form:input path="userName" cssClass="input"/>
			   <form:errors path="userName" cssClass="error" cssErrorClass="fieldError"/>
			   <br/>
			   <label for="userPassword">Clave: </label>
			   <form:password path="userPassword" cssClass="input" cssErrorClass="fieldError"/>
	           <form:errors path="userPassword" cssClass="error" />
	           <br/>
			   <input type="submit" value="Ingresar">
		   </div>
	   </form:form>
	   <div id="footer" class="footer">
	       
       </div>
	</body>
</html>