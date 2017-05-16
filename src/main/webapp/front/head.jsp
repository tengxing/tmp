<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
        					<li><a href="${pageContext.request.contextPath}/home">首页</a></li>
        					<li><a href="#">关于我们</a>
        						<ul>
        							<li><a href="${pageContext.request.contextPath}/join/5.html">机构简介</a></li>
        							<li><a href="${pageContext.request.contextPath}/join/6.html">文化力量</a></li>
        							<li><a href="${pageContext.request.contextPath}/ques/list.html">常见问题</a></li>
        							<li><a href="${pageContext.request.contextPath}/news/last.html">最新公告</a></li>
        						</ul>
        					</li>
        					<li><a href="#">新闻中心</a>
        						<ul>
        							<li><a href="${pageContext.request.contextPath}/news/1.html">公司新闻</a></li>
        							<li><a href="${pageContext.request.contextPath}/news/2.html">行业资讯</a></li>
        						</ul>
        					</li>
        					<li><a href="#">师资队伍</a>

        						<ul>
        						<li><a href="${pageContext.request.contextPath}/tea/1.html">专家团队</a></li>
                                <li><a href="${pageContext.request.contextPath}/tea/2.html">师资力量</a></li>
        						</ul>
        					</li>
        					<li><a href="#">课程设置</a>
        						<ul>
        						<c:forEach var="course" items="${courseList}">
        						    <li><a href="${pageContext.request.contextPath}/course/${course.id}.html"">${course.name}</a></li>
        						</c:forEach>

        						</ul>
        					</li>
        					<li><a href="#">教育成果</a>
        						<ul>

        							<li><a href="${pageContext.request.contextPath}/fame/1.html">家长见证</a></li>
        							<li><a href="${pageContext.request.contextPath}/fame/2.html">下载中心</a></li>
        						</ul>
        					</li>
        					<li><a href="#">加入我们</a>
        						<ul>
        							<li><a href="${pageContext.request.contextPath}/join/1.html">市场前景</a></li>
        							<li><a href="${pageContext.request.contextPath}/join/3.html">合作方式</a></li>
        							<li><a href="${pageContext.request.contextPath}/join/4.html">诚聘英才</a></li>
        							<li><a href="${pageContext.request.contextPath}/message/write">写留言</a></li>
        						</ul>
        					</li>
        				</ul>
        			</div>
        		</div>
