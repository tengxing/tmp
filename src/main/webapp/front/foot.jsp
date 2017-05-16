<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0 auto;
}

#foot_background {
	border-top: 1px solid #666666;
	margin-top: 20px;
}

#foot_message {
	width: 1126px;
	text-align: center;
	font-size: 14px;
	font-family: "微软雅黑";
	color: #333333;
	padding-top: 20px;
	line-height: 24px;
}

#foot_left {
	width: 800px;
	display: inline-block;
	float: left;
}

#foot_right {
	width: 100px;
	display: inline-block;
}

img {
	width: 60px;
	height: 60px;
}
</style>
</head>
<body>
	<div id="foot_background">
		<div id="foot_message">
			<div id="foot_left">
				www.***.com ********训练中心 服务热线：400-0000-000 邮箱：***@***.com<br>
				地址：所在地所在地所在地所在地所在地所在地 工作时间：9:00-12:00 13:00-18:00
			</div>
			<div id="foot_right">
				<img src="${pageContext.request.contextPath}/front/img/pro_1.jpg" />
				<div>微信二维码</div>
			</div>
		</div>
	</div>
</body>
</html>