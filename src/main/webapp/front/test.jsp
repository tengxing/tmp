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
		}
	</style>
	<body>
		<hr>
		<div id="logo_and_hotline">
			<div>
				<img src="${pageContext.request.contextPath}/front/img/pro_1.jpg" id="head_company_logo" />
			</div>
			<div>
				<span id="hotline_info">咨询热线：<a>400-0000-000</a></span>
			</div>
		</div>

        <div id="navigation_background">
        			<div id="navigation">
        				<ul>
        					<li><a href="#">首页</a></li>
        					<li><a href="#">关于我们 ∨</a>
        						<ul>
        							<li><a href="#">机构简介</a></li>
        							<li><a href="#">文化力量</a></li>
        							<li><a href="#">常见问题</a></li>
        							<li><a href="#">最新公告</a></li>
        						</ul>
        					</li>
        					<li><a href="#">新闻中心 ∨</a>
        						<ul>
        							<li><a href="#">公司新闻</a></li>
        							<li><a href="#">行业资讯</a></li>
        						</ul>
        					</li>
        					<li><a href="#">师资队伍 ∨</a>
        						<ul>
        							<li><a href="#">专家团队</a></li>
        							<li><a href="#">师资力量</a></li>
        						</ul>
        					</li>
        					<li><a href="#">课程设置 ∨</a>
        						<ul>
        							<li><a href="#">某某课</a></li>
        							<li><a href="#">某某课</a></li>
        							<li><a href="#">某某课</a></li>
        							<li><a href="#">某某课</a></li>
        							<li><a href="#">某某课</a></li>
        							<li><a href="#">某某课</a></li>
        						</ul>
        					</li>
        					<li><a href="#">教育成果 ∨</a>
        						<ul>
        							<li><a href="#">家长见证</a></li>
        							<li><a href="#">视频分享</a></li>
        							<li><a href="#">下载中心</a></li>
        						</ul>
        					</li>
        					<li><a href="#">加入我们 ∨</a>
        						<ul>
        							<li><a href="#">市场前景</a></li>
        							<li><a href="#">合作方式</a></li>
        							<li><a href="#">诚聘英才</a></li>
        						</ul>
        					</li>
        				</ul>
        			</div>
        		</div>

		<div class="myclass">
		<div id="all_bottom">
			<div id="all_left">
				<div id="all_left_title">课程设置</div>
				<ul>
					<li><a href="#">某某课</a></li>
					<li><a href="#">某某课</a></li>
					<li><a href="#">某某课</a></li>
					<li><a href="#">某某课</a></li>
					<li><a href="#">某某课</a></li>
					<li><a href="#">某某课</a></li>
				</ul>
				<div id="all_application_of_testing">
					<input type="text" value="家长姓名" />
					<input type="text" value="联系电话" />
					<input type="text" value="孩子姓名" />
					<input type="text" value="孩子年龄" />
					<input type="text" value="学校" />
					<input type="text" value="就读年级" />
					<input type="text" value="上课时间" />
					<input type="text" value="课程名称" />
					<input type="button" value="我要报名" />
				</div>
			</div>
			<div class="all_right">
				<div class="all_right_title">
					课程设置/某某课
				</div>
				<div class="${pageContext.request.contextPath}/front/kechengshezhi_img" style="width: 740px;overflow-y:hidden;">
					<img src="${pageContext.request.contextPath}/front/img/img1.jpg" />
				</div>
				<div class="kechengshezhi_small_title">课程简介</div>
				<div class="kechengshezhi_info">
					课程简介内容课程简介内容课程简介内容课程简介内容课程简介内容课程简介内容
					课程简介内容课程简介内容课程简介内容课程简介内容课程简介内容课程简介内容
					课程简介内容课程简介内容课程简介内容课程简介内容课程简介内容课程简介内容
					课程简介内容课程简介内容课程简介内容课程简介内容课程简介内容课程简介内容
					课程简介内容课程简介内容课程简介内容课程简介内容课程简介内容课程简介内容
				</div>
				<div class="kechengshezhi_small_title">课程安排</div>
				<div class="kechengshezhi_info">
					课程安排内容课程安排内容课程安排内容课程安排内容课程安排内容课程安排内容
					课程安排内容课程安排内容课程安排内容课程安排内容课程安排内容课程安排内容
					课程安排内容课程安排内容课程安排内容课程安排内容课程安排内容课程安排内容
				</div>
				<div class="kechengshezhi_small_title">课程特色</div>
				<div class="kechengshezhi_info">
					课程特色内容课程特色内容课程特色内容课程特色内容课程特色内容课程特色内容
					课程特色内容课程特色内容课程特色内容课程特色内容课程特色内容课程特色内容
					课程特色内容课程特色内容课程特色内容课程特色内容课程特色内容课程特色内容
					课程特色内容课程特色内容课程特色内容课程特色内容课程特色内容课程特色内容
				</div>
			</div>
		</div>

		</div>


	</body>
</html>