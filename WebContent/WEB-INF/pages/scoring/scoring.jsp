<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ include file="../includesJSTL.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Document Scoring - Scoring Page</title>
		<link rel="stylesheet" href="<c:url value="resources/css/docScoring.css"/>"/>
		<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/documentTypes.js"/>"></script>
	</head>
	<body>
	   <div id="header" class="header">
	       <h1>Bienvenido a Scoring de Documentos</h1>
	   </div>
	   <div id="leftSide" class="leftSide">
	   </div>
	   <div id="content">
	       <form:errors path="*" cssClass="errorBlock" element="div" />
    	   <form:form commandName="scoringForm" action="scoring" method="post" class="form">
		       <label for="documentType">Elige un documento: </label>
	           <form:select id="documentType" path="selectedDocument" title="Select a document" cssClass="select" cssErrorClass="fieldError" onchange="loadDocumentType();">
	                 <form:option value="" label="Select a document" />
	                 <form:options items="${documentTypes}" itemLabel="description" itemValue="id"/>
	           </form:select>
	           <label for="documentType">Original / Fotocopia: </label>
               <form:select id="origFoto" path="origFoto" title="Seleccione si es original o fotocopia" cssClass="select" cssErrorClass="fieldError" onchange="loadDocumentType();">
                     <form:option value="original" label="Original" />
                     <form:option value="fotocopia" label="Fotocopia" />
               </form:select>
               <form:button>Cargar</form:button>
		       <hr/>
		       <p>EVALUACION DOCUMENTAL - PERSONA JURIDICA</p>
           </form:form>	       
	       <hr/>
	       <div>Validaciones:</div>
	       <c:forEach items="${validations}" var="validation" varStatus="i">
		       <div class="validation">
			       <div class="validationDescription">
			           <c:out value="${i.count }"/>: <c:out value="${validation.description }"/> - <c:out value="${validation.percentage }"/>
		            </div>
			       <div class="validationHelpIcon"></div>
			       <div class="validationCheckBox">
			           <label for="checkBox${i.count }">Pasó: </label>
			           <input id="validationCheckBox" name="checkBox${i.count }" type="checkbox">
		           </div>
		       </div>
	       </c:forEach>
	       <input id="process" type="button" value="Procesar"/>
       <hr/>
	       <p>PORCENTUAL MINIMO ACEPTABLE <c:out value="${minimum }"/>%</p>
	   </div>
	   <div id="footer" class="footer">
	       <hr/>
	       <p>diegobucciardi@gmail.com | Norberto Diaz</p>
       </div>
	</body>
	<script type="text/javascript">
	   $("#process").click(function(){
		   $("input:checked").each(function(index, element){
			   
		   });
	   });
	</script>
</html>