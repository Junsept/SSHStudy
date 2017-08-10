<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>success</title>
</head>
<body>
<h1>成功</h1>
  <body>  
  	${name}
  	${date}
  	<br>
  	${imgFileName}
  	<br><br>
    <img src="/imagebystruts/${imgFileName}">
  </body>  
</body>
</html>