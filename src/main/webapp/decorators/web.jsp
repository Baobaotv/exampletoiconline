<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="HOME PAGE" /> </title>
<link href="<c:url value='/template/web/css/bootstrap.css' />" rel="stylesheet">
    <link href=" <c:url value='/template/web/css/bootstrap-responsive.css' />" rel="stylesheet">
    <link href="<c:url value='/template/web/css/style.css' />" rel="stylesheet"> 
    
    <!--Font-->
    <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600' rel='stylesheet' type='text/css'>
    
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="<c:url value='/template/web/js/bootstrap.min.js' />"></script>
      
<dec:head></dec:head>
</head>
<body>
<%@include file="/common/web/header.jsp" %>
 <div class="container">
 <dec:body></dec:body>
 </div>
 <%@include file="/common/web/footer.jsp" %>

</body>
</html>