<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<s:form action="login" method="post" enctype="multipart/form-data">
  <s:file name="img" label="头像" />
  <s:submit value="Submit" />
</s:form>
<!-- <form action="login" method="post" enctype="multipart/form-data">
	头像:<input type="file" name="img"></input>
	<input type="submit" values="上传"></input>
</form> -->
</body>
</html>