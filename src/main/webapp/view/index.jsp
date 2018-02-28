<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-2.0.3.js"></script>
<script type="text/javascript">
 
$(document).ready(function(){
	
	$("#b").click(function(){
		alert("button...");
	});

	});
</script>

</head>
<body>
  <h3>Hello</h3>
   <shiro:hasPermission name="100">
    	 <li><a href="sale.do">销售模块</a></li>
   </shiro:hasPermission>
   <shiro:hasPermission name="108">
    	 <li><a href="purchase.do">收购模块</a></li>
	</shiro:hasPermission>
   <shiro:hasPermission name="102">
    	 <li><a href="jishou.do">寄售模块</a></li>
	</shiro:hasPermission>
   <shiro:hasPermission name="103">
    	 <li><a href="manager.do">统计模块</a></li>
	</shiro:hasPermission>
   <a href="logout.do">注销</a> 

	<button type="button" id="b">Click me</button>
</body>
</html>