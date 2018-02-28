<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragrma", "no-cache");
response.setDateHeader("Expires", 0); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>form表单</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.0.3.js"></script>
<script type="text/javascript">
window.history.forward(1); 
$(document).ready(function(){
	
	$("#bt").bind("click",function(){
		var a = $("#isSubmit").val();
		/* if(a==0){ */
			$("#fm").attr("action","../../../apple/selectApple.do");
			$("#isSubmit").val("1");
			$("#fm").submit();
		/* } */
		
				
	});
	
});
</script>
</head>
<body>

	<form id="fm" action="" >
		<input type="hidden" value="0" id="isSubmit">
		<input type="text" id="name" value="">
		<input type="text" id="sex" value="">
		<input type="text" id="address" value="">
		<input id="bt" type="button" value="提交">
	</form>


</body>
</html>