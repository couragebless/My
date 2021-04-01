<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title></title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="${ctx}/public/logo.ico"
	type="image/x-icon" />
<link rel="stylesheet" href="${ctx}/public/css/font.css">
<link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
</head>
<body>
	<div class="x-body layui-anim layui-anim-up">
		<blockquote class="layui-elem-quote">
			欢迎管理员： <span class="x-red">${sessionScope.user_session.username }</span>！当前时间:2018-04-25
			20:50:53
		</blockquote>

		<%-- <fieldset class="layui-elem-field">
			<legend>公告</legend>
			<div class="layui-field-box">
				<table class="layui-table">
					<tbody>
						<tr>
							<th>ID</th>
							<td>标题</td>
							<td>描述</td>
							<td>发布日期</td>
							<td>发布用户</td>
							
						</tr>

						<c:forEach items="${requestScope.list}" var="dept"
							varStatus="stat">
							<tr>

								<td>${dept.id}</td>
								<td>${dept.title }</td>
								<td>${dept.remark }</td>
								<td>${dept.create_date }</td>
								<td>${dept.user.name }</td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>
		</fieldset>

		<blockquote class="layui-elem-quote layui-quote-nm">这里是底部。</blockquote> --%>
	</div>
	<script>
		var _hmt = _hmt || [];
		(function() {
			var hm = document.createElement("script");
			hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(hm, s);
		})();
	</script>
</body>
</html>