<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>少儿培训公司官网</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/head.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/all.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/changjianwenti.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/kechengshezhi.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery-3.1.0.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/all.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/kechengshezhi.js" ></script>

	</head>
	<style type="text/css">
		.myclass{
			padding-left: 15%;
			padding-right: 15%;
			margin-top: 10px;
			height:768px;
		}	
	</style>
<body>
    <jsp:include page="head.jsp"/>
    <div class="myclass">
    		<div id="all_bottom">
    			<div id="all_left">
    				<div id="all_left_title">课程设置</div>
    				<ul>

    					<c:forEach var="course" items="${courseList}">
    					      <li><a href="${pageContext.request.contextPath}/course/${course.id}.html"">${course.name}</a></li>
                        </c:forEach>

    				</ul>
    				<div id="all_application_of_testing">
    				<form id ="myform">
    					<input type="text" name="parname" placeholder="家长姓名" />
    					<input type="text" name="phone" placeholder="联系电话" />
    					<input type="text" name="stuname" placeholder="孩子姓名" />
    					<input type="text" name="age" placeholder="孩子年龄" />
    					<input type="text" name="school" placeholder="学校" />
    					<input type="text" name="classname" placeholder="就读年级" />
    					<input type="text" name="freetime" placeholder="上课时间" />
    					<input type="text" name="coursename" placeholder="课程名称" />
    					<input type="button" value="我要报名" onclick="mysubmit()"/>
    				</form>
                  <script type="text/javascript">

                                          function mysubmit(){
                  			 				$.ajax({
                                                  type:"post",
                                                  url: "${pageContext.request.contextPath}/stu/save",
                                                  data:$("#myform").serialize(),
                                                  dataType:"json",
                                                  success: function (result){
                                                      if(result.success){
                                                          alert("报名成功");
                                                      }else{
                                                          alert("系统繁忙");
                                                      }
                                                  }
                                              });
                                          }
                                      </script>
    				</div>
    			</div>
    			<div class="all_right">
    				<div class="all_right_title">
    					课程设置/${course.name}
    				</div>
    				<div class="${pageContext.request.contextPath}/front/kechengshezhi_img" style="width: 740px;overflow-y:hidden;">
    					<img style="width: 740px; height:300px;" src="${pageContext.request.contextPath}/front/img/img1.jpg" />
    				</div>
    				<div class="kechengshezhi_small_title">课程简介</div>
    				<div class="kechengshezhi_info">
    				    ${course.summary}
    				</div>
    				<div class="kechengshezhi_small_title">课程安排</div>
    				<div class="kechengshezhi_info">
    				    ${course.teachTime}
    				</div>
    				<div class="kechengshezhi_small_title">课程特色</div>
    				<div class="kechengshezhi_info">
    				    ${course.feature}
    				</div>
    			</div>
    		</div>

    		</div>
    		
    	 <jsp:include page="foot.jsp"/>
		

</body>
</html>

