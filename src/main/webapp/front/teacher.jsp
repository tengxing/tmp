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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/shiziduiwu.css" />

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
    				<div id="all_left_title">师资队伍</div>
    				<ul>
                        <li><a href="${pageContext.request.contextPath}/tea/1.html"">专家团队</a></li>
                         <li><a href="${pageContext.request.contextPath}/tea/2.html"">师资力量</a></li>

    				</ul>
    				<div id="all_application_of_testing">

                  <script type="text/javascript">

                                          function mysubmit(){
                  			 				$.ajax({
                                                  type:"post",
                                                  url: "${pageContext.request.contextPath}/admin/stu/save",
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
                        				师资队伍/${myFametype}
                        			</div>
                        			<c:forEach var="fame" items="${myFameList}">
                        			    <c:if test="${fame.type==myFametype}">
                        			         <a class="one_teacher">
                                                                                                        				<div class="demo">
                                                                                                        					<div class="container">
                                                                                                        						<div class="row">
                                                                                                        							<div class="col-md-4 col-sm-6">
                                                                                                        								<div class="box">
                                                                                                        									<img style="width:300px;height:300px;" src="${pageContext.request.contextPath}${fame.url}">
                                                                                                        									<div class="box-content">
                                                                                                        									    <h3 class="title">${fame.name}</h3>

                                                                                                                                                       <span class="post">${fame.content}</span>
                                                                                                        									</div>
                                                                                                        								</div>
                                                                                                        							</div>
                                                                                                        						</div>
                                                                                                        					</div>
                                                                                                        				</div>
                                                                                                        			</a>
                        			    </c:if>
                                    </c:forEach>


                        		</div>

    		    </div>

    		</div>
 <jsp:include page="foot.jsp"/>
</body>
</html>