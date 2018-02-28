<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-2.0.3.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#bt").click(function(){
		
		
		var path=$("table tr:eq(2) td:eq(1)").text();
		$("table tr:eq(2) td:eq(1)").text("科幻汽车");
		$("table tr:eq(2) td:eq(1)").append("<img src='imgs/car-imgs/1.jpg'>");
		alert(path);
		
		
		for(rep in repText){
			$("table tr:eq(2) td:eq(1)").replace();
		} 
		
	});
	
	
	/* var picAndTex="AA{AB}B{BC}CCDDDEEEFFF";
	 
	var repText={"{AB}":"12","{BC}":"23"};
	
	for(rep in repText){
		alert(rep);
		alert("转化之前    "+picAndTex);
		picAndTex=picAndTex.replace(new RegExp(rep,"g"), repText[rep]);
		alert("转化之后    "+picAndTex);
		
	} */
	
	t2();
	
	
});

function test(){
	var str = "&lt;Option&nbsp;value=1&gt;test&amp;good&lt;/option&gt;";
    var regObj = {"&lt;":"<","&gt;":">","&nbsp;":" ","&amp;":"&"};//要替换的内容和值，json格式
    for(reg in regObj)
    {	alert("reg="+reg);
    		
             str = str.replace(new RegExp(reg,"g"),regObj[reg]);
            alert(str);
    }
    
}

function t2(){
		var picAndTex="这是什么{1.jpg}这是图片{2.jpg}宝马车{2.jpg}do you like?{1.jpg}";
		
		 var repText={"{1.jpg}":"<img src='imgs/car-imgs/1.jpg'>","{2.jpg}":"<img src='imgs/car-imgs/2.jpg'>"};
		
		for(rep in repText){
			alert(rep);
			alert("转化之前    "+picAndTex);
			picAndTex=picAndTex.replace(new RegExp(rep,"g"), function(){
				return picAndTex.append("<img src="+repText[rep]+"/>");
				
			});
			alert("转化之后    "+picAndTex);
			
		} 
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图片表情转化插件</title>
</head>
<body>
<h2>车列表</h2>
<table>
<c:forEach var="car" items="${cars}">
	
		<tr>
			<td>车名称：</td>
			<td>${car.name }</td>
		</tr>
			<tr><td>车龄：</td>
			<td>${car.carAge }</td>
		</tr>
			<tr><td>车图片：</td>
			<td>${car.path }</td>
		</tr>
	
</c:forEach>
</table>
<img src="imgs/car-imgs/1.jpg">

<input id="bt" type="button">
</body>
</html>