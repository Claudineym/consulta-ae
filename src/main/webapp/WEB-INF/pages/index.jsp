<%@page session="false"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Consulta NFe</title>

  <meta name="description" content=""> 
    <spring:url value="/resources/js" var="js" />
</head>
<body>
  <div id="app"></div>
  <script src="${js}/bundle.js"></script>  
</body>
</html>