<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	padding-top: 50px;
	background-color: #F8F8FF;
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
					<strong>套题名称:<font size="15" color="#014D67">${type }</font></strong>
				</div>
			</div>
			<div class="col-md-6">考生：等级：</div>
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
						<img alt="详细题目"
							src="${pageContext.request.contextPath }/static/img/title.png">
						<!-- 这里输出考题类的名字 -->
					</div>
					<!-- 遍历输出，每页显示5个题目： -->
					<div class="exam_detail_datas">
						<form action="" method="post">
							<ul>
								<c:forEach items="${exercise_list}" var="exercise" step="1" varStatus="exercisest">
									<li>
										<div class="exam_detail_datas_name">
											<!-- 输出具体考试题目的名称 -->
											<font size="4" , color="#E3A05D">${exercise.exercise_title }:</font><span
												style="float: right">${exercise.examination_name }</span>
										</div>
										<div class="exam_detail_data_content">
											<font size="3" color="#2F4F4F">${exercise.exercise_content }</font>
										</div>
										<div class="exam_detail_data_answere">
											<!-- 这里通过判断假设是选择题显示选项，问答题显示输入框，其他的自行判断 -->
											<c:if test="${exercise.exercise_type=='radio' }">
											<c:set var="index" value="${exercisest.count-1 }"/>
											<c:forEach items="${answere}" var="answeres"  begin="${index }" end="${index }" step="1" >
											<c:forEach items="${answeres }" var="map"  >
			                        ${map.key}&nbsp;&nbsp;<input type="radio" name="${exercise.exercise_id }" id="${exercise.exercise_id }"  value="${map.key }" onclick="loadanswere(this)">${map.value }
			                                </c:forEach>
			                  </c:forEach>
			                              <input type="hidden" id="radio_id${index }" value="${exercise.exercise_id }">
			                                <p id="resmsg${exercise.exercise_id }" ></p>
											</c:if>
											<c:if test="${exercise.exercise_type=='short-answere' }">
												<p>解答：</p>
												<textarea id="shortanswere" name="shortanswere" cols="70" ></textarea><br>
												<input type="hidden" id="short_id" value="${exercise.exercise_id }"/>
												<button type="button" class="btn btn-primary" id="short" name="short" style="margin: 0 auto;" onclick="loadtext()">回答完毕</button>
											</c:if>
										</div>
										<hr />
									</li>
								</c:forEach>
							</ul>
							<div class="pagebean" style="text-align: center">
								<nav>
									<ul class="pagination">
									${pagecode }
									</ul>
								</nav>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function loadanswere(that) {
	//alert($(that).attr("id"));
	var num=$(that).attr("id");
	//var titles=$("#radio_id").val();
	var contents =$("input[name='"+num+"']:checked").val();
	$("input[name='"+num+"']").attr("disabled",true);
	var sendinfo={'title':num,'content':contents};
	//var answereid=$(".getanswereid").Attr("id");
	var request=$.ajax({
	method:'post',
	url:'wechat/ajax',
	contentType:'application/json; charset=utf-8',
	data:JSON.stringify(sendinfo),
	error:function(msg){
	       $( "#resmsg+'"+num+"'" ).html("网络错误，请确认已经联网");
	    }
	 }
  );
	request.done(function( msg ) {
        $( "#"+"resmsg"+num ).html( msg );
      }
  );
 
    request.fail(function( jqXHR, textStatus ) {
        alert( "Request failed: " + textStatus );
        }
       );
	}
	function loadtext()
	  {
	  var contents=$("#shortanswere").val();
	  var titles=$("#short_id").val();
	  var sendinfo={'title':titles,'content':contents};
	  var request=$.ajax({
	  method:'post',
	  url:'wechat/ajax',
	  contentType:'application/json',
	  data:JSON.stringify(sendinfo),
	  error:function(msg){
	       $( "#resmsg" ).html("网络错误，请确认已经联网");
	    }
	  });
	  request.done(function(msg)
	  {
	  $("#resmsg").html(msg);
	  });
	  request.fail(function( jqXHR, textStatus ) {
        alert( "Request failed: " + textStatus );
        }
       );
	     }
</script>
</html>