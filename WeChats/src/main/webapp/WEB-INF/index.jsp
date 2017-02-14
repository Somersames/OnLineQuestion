<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>个人博客主页</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/bootstrap-theme.css">
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<div class="row col-md-12">
			<div class="col-md-7">
				<ul class="nav nav-pills" role="tablist">
					<li role="presentation"><a href="#">主页</a></li>
					<li role="presentation"><a href="#">浏览</a></li>
					<li role="presentation"><a href="#">查看信息</a></li>
					<li role="presentation">
						<form class="navbar-form navbar-left" role="search">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="搜索">
							</div>
							<button type="submit" class="btn btn-default">Submit</button>
						</form>
					</li>
					<!-- Single button -->
					<li role="presentation">
					<li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
					</div>
				</ul>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row col-md-12">
			<div class="col-md-3">
				<ul class="list-group">
					<li class="list-group-item"><a href="#">历史信息查看</a></li>
					<li class="list-group-item"><a href="#">个人资料</a></li>
					<li class="list-group-item"><a href="#">讨论组查看</a></li>
					<li class="list-group-item"><a href="#">广水二中查看</a></li>
					<li class="list-group-item">
						<div class="btn-group">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown">
								Action <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul>
						</div>
					</li>
				</ul>
			</div>
			<div class="col-md-9">
				<div class="jumbotron">
					<h1>个人主页!</h1>
					<p>--Somer、sames</p>
					<p>
						<a class="btn btn-primary btn-lg" href="#" role="button">个人信息介绍</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	</nav>
	<p>${pageContext.request.contextPath}</p>
</body>
</html>
