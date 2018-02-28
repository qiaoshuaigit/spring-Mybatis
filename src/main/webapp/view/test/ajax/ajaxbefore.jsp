<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragrma", "no-cache");
response.setDateHeader("Expires", 0); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax beforeSend设置</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.0.3.js"></script>
<script type="text/javascript">
window.history.forward(1); 
$(document).ready(function(){
	
	$("#bt").click(function(){
		test();
	});
	
});
function test(){
	$.ajax({
		url:"ajax_send.jsp",
		type:"post",
		dataType:"html",
		beforeSend:function(){
			$("#tt").val("发送请求前设置的");
		},
		success:function(data){
			$("#waitDIV").replaceWith(data);
		},
		error:function(){
			
		}
	});
}
</script>
</head>
<body>

	<input id="bt" type="button" value="提交">
	<input id="tt" type="text" value="">
	<div id="waitDIV">
		<table>
		<tr><td>水果</td><td>书籍</td><td>游戏</td></tr>
		<tr><td>香蕉</td><td>语文</td><td>qq游戏</td></tr>
		<tr><td>西瓜</td><td>英语</td><td>DNF</td></tr>
	</table>
	</div>

</body>
</html>