<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'index2.jsp' starting page</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/bootstrap-theme.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/blog.css">
</head>
<!-- 注意css的排序可能引起的失效问题 -->
<style type="text/css">
body {
	padding-top: 10px;
	padding-bottom: 40px;
	background-color: #F8F8FF;
	font-family: microsoft yahei;
}
</style>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="blog">
					<strong>个人WebSide--Somersames</strong>
				</div>
			</div>
			<div class="col-md-6">
				<iframe style="float:right" width="420" scrolling="no" height="60"
					frameborder="0" allowtransparency="true"
					src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=5"></iframe>
			</div>
		</div>
		<div class="row" style="padding-top: 10px">
			<div class="col-md-12">
				<nav class="navbar navbar-default">
				<div class="container-fluid">
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li><a class="navbar-brand" href="#">主页介绍</a></li>
							<li><a class="navbar-brand" href="#">查看所有</a></li>
							<li><a class="navbar-brand" href="#">题目解答</a></li>
							<li><a class="navbar-brand" href="#">个人错题本</a></li>
						</ul>
						<form class="navbar-form navbar-right" role="search">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="请输入要查询的关键字">
							</div>
							<button type="submit" class="btn btn-default">搜索</button>
							<div class="dropdown navbar-right">
								<button class="btn btn-default dropdown-toggle" type="button"
									id="dropdownMenu1" data-toggle="dropdown">
									查询类型 <span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="dropdownMenu1">
									<li role="presentation" class="divider"><a role="menuitem"
										tabindex="-1" href="#">全部试题</a></li>
									<li role="presentation">最新资源</li>
									<li role="presentation">答案</li>
								</ul>
							</div>
						</form>
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid --> </nav>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="list-group">
					<a href="#" class="list-group-item">全部试题</a> <a href="#"
						class="list-group-item">题目解答</a> <a href="#"
						class="list-group-item">注册账号</a> <a href="#"
						class="list-group-item">开始答题</a>
				</div>
				<p style="padding-top: 30px;font-size: 20">
					<strong>最新试题查看:</strong>
				</p>
				<ul class="list-group">
					<li class="list-group-item">Cras justo odio</li>
					<li class="list-group-item">Dapibus ac facilisis in</li>
					<li class="list-group-item">Morbi leo risus</li>
					<li class="list-group-item">Porta ac consectetur ac</li>
					<li class="list-group-item">Vestibulum at eros</li>
				</ul>
			</div>
			<div class="col-md-6">
				<div class="data_list">
					<div class="data_list_title">
						<img
							src="${pageContext.request.contextPath }/static/img/title.png">最新信息展示:
					</div>
					<div class="data_content">
						<!-- 试题内容 -->
						<ul>
						<c:forEach items="${examlist}" var="exam">
						<li style="padding-bottom: 30px">
						<span class="datas_titles"><img alt="文章类型" src="${pageContext.request.contextPath }/static/img/title.png"><a href="${pageContext.request.contextPath }/exercise?types=${exam.exam_name}&click=${exam.exam_hit}">${exam.exam_name}<!-- 获取文章类型 --></a></span>
						<span class="jianjie">摘要：${exam.exam_type }</span>
						<span class="info">
						<font color="#999">2016-07-03 10:39</font> &nbsp;&nbsp;
						<br>
						  		<font color="#33a5ba"><a href="#">阅读</a><font color="#999">(${exam.exam_hit })</font>&nbsp;&nbsp;</font>
						  		<font color="#33a5ba"><a href="#">评论</a><font color="#999">(${exam.exam_commenthit })</font>&nbsp;&nbsp;</font>
						</span>
						</li>
						<hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:10px;" />	
						</c:forEach>
						</ul> 
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
