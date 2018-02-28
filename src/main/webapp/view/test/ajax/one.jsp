<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax测试</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.0.3.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	alert("helo");
		$.ajax({
			url:"../../../apple/selectApple.do",
			type:"get",
			dataType:"text",
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			success:function(data){				
				alert(data);
			},
			error:function(data){
				alert(data.length);
			},
		});
	
});
</script>
</head>
<body>
<input type="text" id="text" value="hello">

</body>
</html>