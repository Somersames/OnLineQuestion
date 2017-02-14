<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<title>解题目录</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/js/bootstrap.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/css/bootstrap-theme.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/css/examination.css">
<style type="text/css">
body {
	padding-top: 50px; background-color : #F8F8FF;
	font-family: microsoft yahei;
	background-color: #F8F8FF;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row col-md-12">
			<div class="col-md-6">
				<div class="exam-title">
					<strong>套题名称${exam.exam_name }</strong>
				</div>
			</div>
			<div class="col-md-6">
			考生：等级：
			</div>
		</div>
	</div>
	<div class="container" style="padding-top: 50px;padding-bottom: 15px">
		<div class="row">
			<div class="col-md-3">
				<ul class="list-group">
					<li class="list-group-item"><span class="badge">14</span>Cras
						justo odio</li>
					<li class="list-group-item">Dapibus ac facilisis in</li>
					<li class="list-group-item">Morbi leo risus</li>
					<li class="list-group-item">Porta ac consectetur ac</li>
					<li class="list-group-item">Vestibulum at eros</li>
				</ul>
			</div>
			<div class="col-md-6">
			<div class="datas">
			<div class="exam_detail_title">
			<img alt="详细题目" src="${pageContext.request.contextPath }/static/img/title.png"><!-- 这里输出考题类的名字 -->:
			</div>
			<!-- 遍历输出，每页显示5个题目： -->
			<div class="exam_detail_datas">
			<ul>
			<li>
			<div class="exam_detail_datas_name"><!-- 输出具体考试题目的名称 -->java循环遍历<span style="float: right">输出考题的难度级别以及考题类型</span></div>
			<div class="exam_detail_data_content">
			重写java的equals需要重写hashcode么
			</div>
			<div class="exam_detail_data_answere">
			<!-- 这里通过判断假设是选择题显示选项，问答题显示输入框，其他的自行判断 -->
			<c:if test="${exam.exam_detail=='radio' }">
			&nbsp;&nbsp;<input type="radio" name="answere">A
			&nbsp;&nbsp;<input type="radio" name="answere">B
			&nbsp;&nbsp;<input type="radio" name="answere">C
			&nbsp;&nbsp;<input type="radio" name="answere">D
			</c:if>
			</div>
			</li>
			</ul>
			</div>
			</div>
			</div>
		</div>
	</div>
</body>
</html>