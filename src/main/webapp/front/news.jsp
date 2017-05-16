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
		}.mydiv {
                               padding-top: 100px;
                               line-height: 20px;
                               border: 5px solid #ffffff;
                               font-size: 30px;
                               color: #000000;
                               text-align: center;
                               z-index: 999;
                               width: 828px;
                               height: 498px;
                               left: 43%;
                               top: 30%;
                               margin-left: -150px!important;
                               margin-top: -60px!important;
                               margin-top: 0px;
                               position: fixed!important;
                               position: absolute;
                               background-color: #fffefe;
                               opacity: 0.9;
                           }
	</style>
<body>
    <jsp:include page="head.jsp"/>
    <div class="myclass">
    		<div id="all_bottom">
    			<div id="all_left">
    				<div id="all_left_title">新闻中心</div>
    				<ul>
                      <li><a href="${pageContext.request.contextPath}/news/1.html">公司新闻</a></li>
                      <li><a href="${pageContext.request.contextPath}/news/2.html">行业资讯</a></li>

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
<script>
	function on(id){
		alert()
		document.getElementById(id).style.display='block';
	}
</script>
                <div class="all_right">
                			<div class="all_right_title">
                				新闻中心/${myFametype}
                			</div>
                			<c:forEach var="fame" items="${myFameList}">
                                <c:if test="${fame.type==myFametype}">
                                  <div id="ques${fame.id}" class="mydiv" style="display:none;">
                                                                                                                      <p style="font-size:40px;"> ${fame.title}</p></br></br>
                                                                                                                          <fmt:formatDate value="${releaseDate}" pattern="yyyy/MM/dd  HH:mm:ss" />
                                                                                                                      </br></br>
                                                                                                                      <p style="font-size:20px;">
                                                                                                                       ${fame.content}
                                                                                                                       </p>
                                                                                                                       </div>

                			<a href="#" onclick="document.getElementById('ques${fame.id}').style.display='block';"   class="xinwenzhongxin_right_one">
                				<div class="xinwenzhongxin_right_img">
                					<img src="${pageContext.request.contextPath}/front/img/pro_1.jpg" />
                				</div>
                				<div class="xinwenzhongxin_right_info">
                					<div class="xinwenzhongxin_right_big_title">
                					    ${fame.title}
                					</div>
                					<div class="xinwenzhongxin_right_small_title">
                						${fame.summary}
                					</div>
                					<div class="xinwenzhongxin_right_time">
                                            <fmt:formatDate value="${fame.releaseDate}" type="date"/>
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