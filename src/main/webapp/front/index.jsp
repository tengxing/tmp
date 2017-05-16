<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link href="${pageContext.request.contextPath}/front/css/flickerplate.css" rel="stylesheet">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/head.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/shiziduiwu.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front/css/homepage.css" />
		<script src="${pageContext.request.contextPath}/front/js/jquery-1.8.3.min.js"></script>
		<!--首页轮播图片开始-->
		<script src="${pageContext.request.contextPath}/front/js/modernizr-custom-v2.7.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/front/js/jquery-finger-v0.1.0.min.js"></script>
		<script src="${pageContext.request.contextPath}/front/js/flickerplate.min.js"></script>

		<!--首页轮播图片结束-->
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/homepage.js" ></script>
	</head>
	<style>
                        .mydiv {
                               padding-top: 100px;
                               line-height: 20px;
                               border: 5px solid #ffffff;
                               font-size: 30px;
                               color: #000000;
                               text-align: center;
                               z-index: 999;
                               width: 828px;
                               height: 498px;
                               left: 51%;
                               top: 29%;

                               margin-left: -150px!important;
                               margin-top: -60px!important;
                               margin-top: 0px;
                               position: fixed!important;
                               position: absolute;
                               background-color: #fffefe;
                               opacity: 0.9;
                           }*{
				margin: 0 auto;
			}
			#foot_background{
				border-top: 1px solid #666666;
				margin-top: 20px;
			}
			#foot_message{
				width: 1126px;
				text-align: center;
				font-size: 14px;
				font-family: "微软雅黑";
				color: #333333;
				padding-top: 20px;
				line-height: 24px;
			}
			#foot_left{
				width: 800px;
				display: inline-block;
				float: left;
			}
			#foot_right{
				width: 100px;
				display: inline-block;
			}
			img{
				width: 60px;
				height: 60px;
			}
                           
	</style>
	<body>
        <jsp:include page="head.jsp"/>
		<div class="">
			<div class="mianc">
				<div class="flicker-example">
					<ul>
						<li data-background="${pageContext.request.contextPath}/front/img/img1.jpg"></li>
						<li data-background="${pageContext.request.contextPath}/front/img/img2.jpg"></li>
						<li data-background="${pageContext.request.contextPath}/front/img/img3.jpg"></li>
					</ul>
				</div>
			</div>
		</div>

		<div id="courses">

		<c:forEach var="course" items="${courseFour}">
			<div class="one_course">
				<div class="he_border1">
					<img class="he_border1_img" src="${pageContext.request.contextPath}/front/img/pro_1.jpg">
					<div class="he_border1_caption">
						<h3 class="he_border1_caption_h">${course.name}</h3>
						<p class="he_border1_caption_p">${course.name}</p>
						<a class="he_border1_caption_a" href="#"></a>
					</div>
				</div>
			</div>
        </c:forEach>

		</div>
		<div id="about_us">
			<div class="index_about_big_title">
				About Us
			</div>
			<div id="about_us_info">
			    公司高度重视人才培养和供应链管理，员工中百分之五十为工程技术人员。已获得众多专利和著作权证书，更有CE FCC ROHS等一大批权威认证报告。

                公司与全球顶尖IC厂家深度合作，核心芯片全部进口，在研发环节严格测试，优选专业加工厂，全程环保无铅生产，建立追溯系统，质量层层把关，确保每一件产品合格、环保、可靠。

                营销网络
                公司建立完善的线上线下营销网络，线上推广品牌，线下参加展会和客户拜访，并在多地设有办事处，营销网络遍布全球三十多个国家和地区

                同时对客户进行分级服务，建立五个十的服务标准，通过工单系统为中小客户快速解决问题，FAE对大客户提供一对一现场技术支持。

                合作企业
                自成立以来，有人物联网凭借过硬的技术、可靠的产品、周到的服务和认真做事的企业文化，赢得了客户的一致信赖，先后与海尔、富士康、歌尔声学、国家电网、奥德燃气、海康威视、得实集团、丹佛斯、费森尤斯卡比等国内外著名企业达成深度合作。
			</div>
		</div>
		<div id="org_news">
			<div id="org_news_info">
				<div id="org_news_info_left">
				    <div>
				         <iframe height=300 width=400 src='http://player.youku.com/embed/XMjc0NDgwMTg4OA==' frameborder=0 'allowfullscreen'></iframe>
				    </div>
				</div>
				<div id="org_news_info_right">
					<ul>
					<c:forEach var="course" items="${newsList}">

                              <div id="ques${course.id}" class="mydiv" style="display:none;">
                                                                                                                                                 <p style="font-size:40px;"> ${course.title}</p></br></br><hr></br></br>
                                                                                                                                                  ${course.content}
                        <a href="#" onclick="document.getElementById('ques${course.id}').style.display='block';">                                                                                                                          </div>
						<li>${course.title}<span>${course.releaseDate}</span></li>
						</a>
					</c:forEach>

					</ul>
				</div>
			</div>
		</div>
		<div id="teachers">
			<div class="index_about_big_title">
				Our Team
			</div>

			<c:forEach var="teacher" items="${teacherFour}">
			    <a class="one_teacher">
                				<div class="demo">
                					<div class="container">
                						<div class="row">
                							<div class="col-md-4 col-sm-6">
                								<div class="box">
                									<img style="width:300px;height:300px;" src="${pageContext.request.contextPath}${teacher.url}">
                									<div class="box-content">
                										<h3 class="title">${teacher.name}</h3>
                										<span class="post">${teacher.content}</span>
                									</div>
                								</div>
                							</div>
                						</div>
                					</div>
                				</div>
                			</a>

			</c:forEach>

		</div>
	     <jsp:include page="foot.jsp"/>
		
	</body>
</html>
