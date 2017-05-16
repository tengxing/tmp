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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/all.css" />
        		<link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/xinwenzhongxin.css" />

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
    				<div id="all_left_title">加入我们</div>
    				<ul>
                      <li><a href="${pageContext.request.contextPath}/join/1.html">市场前景</a></li>
                      <li><a href="${pageContext.request.contextPath}/join/3.html">合作方式</a></li>
                       <li><a href="${pageContext.request.contextPath}/join/4.html">诚聘英才</a></li>
                           <li><a href="${pageContext.request.contextPath}/message/write.html">写留言</a></li>
    				</ul>
    				<div id="all_application_of_testing">

                  <script type="text/javascript">

                                          function mysubmit(){
                  			 				$.ajax({
                                                  type:"post",
                                                  url: "${pageContext.request.contextPath}/message/save",
                                                  data:$("#myform").serialize(),
                                                  dataType:"json",
                                                  success: function (result){
                                                      if(result.success){
                                                          alert("成功");
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
                				加入我们/写留言
                			</div>
                			
                				<c:forEach var= "mess" items="${messageList}">
                			 留言人:${mess.title }</br>
                			
                			   时间:${mess.messageTime }</br>
                			     留言内容:</br>${mess.content }</br>
                			    回复内容:</br>${mess.status }</br><hr>
                				</c:forEach>
                                    <div class="xinwenzhongxin_right_time">

                                    	<form id ="myform">
                                        					<input type="text" name="nickName" value="您的名字" /></br>
                                        					<input type="text" name="phoneNumber" value="联系电话" /></br>
                                        					<input type="text" name="mail" value="邮箱" /></br>
                                        					<input type="text" name="title" value="主题" /></br>
                                        					<input type="text" name="content" value="内容" />

                                        					<input type="button" value="我要报名" onclick="mysubmit()"/>
                                        				</form>
                                    </div>




                		</div>





            </div>
    </div>

 <jsp:include page="foot.jsp"/>
</body>
</html>