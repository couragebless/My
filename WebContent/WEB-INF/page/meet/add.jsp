<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>欢迎页面-X-admin2.0</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="${ctx}/public/css/font.css">
<link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/public/lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/public/js/xadmin.js"></script>
<script type="text/javascript"
	src="${ctx}/public/js/My97DatePicker/WdatePicker.js"></script>


<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<%-- <script type="text/javascript">
		
	<%java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
			java.util.Date currentTime = new java.util.Date();//得到当前系统时间 
			String str_date = formatter.format(currentTime); //将日期时间格式化%>
		if ($.trim($("#start_time").val()) != "") {
			if ($.trim($("#end_time").val()) == "") {
				alert("结束时间不允许为空！");
				return;
			}
		}
		if ($.trim($("#end_time").val()) != "") {
			if ($.trim($("#start_time").val()) == "") {
				alert("开始时间不允许为空！");
				return;
			}
		}
	</script> --%>

<body>
	<div class="x-body">
		<form class="layui-form" method="POST" id="meetForm"
			action="${ctx}/meet/add">
			<input type="hidden" name="id" id="id" value="${meetting.id }">
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>会议主题
				</label>
				<div class="layui-input-inline">
					<input type="text" id="meetting_name" name="meetting_name" required=""
						lay-verify="required" autocomplete="off" class="layui-input"
						value="${meetting.meetting_name }">
				</div>

			</div>
			<div class="layui-form-item">
				<label for="phone" class="layui-form-label"> <span
					class="x-red">*</span>会议地址
				</label>
				<div class="layui-input-inline">
					<input type="text" id="meetting_address" name="meetting_address" required=""
						lay-verify="required" autocomplete="off" class="layui-input"
						value="${meetting.meetting_address }">
				</div>

			</div>

			<div class="layui-form-item">
				<label for="phone" class="layui-form-label"> <span
					class="x-red">*</span>开始时间
				</label>
				<div class="layui-input-inline">
					<input type="text" id="start_time" name="start_time" required=""
						lay-verify="required" autocomplete="off" class="layui-input"
						onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" readonly="readonly" value="${meetting.start_time }" />
				</div>

			</div>
			
			<div class="layui-form-item">
				<label for="phone" class="layui-form-label"> <span
					class="x-red">*</span>结束时间
				</label>
				<div class="layui-input-inline">
					<input type="text" id="end_time" name="end_time" required=""
						lay-verify="required" autocomplete="off" class="layui-input"
						onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" readonly="readonly" value="${meetting.end_time }" />
				</div>

			</div>

			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label> <input
					type="submit" value=" 提交" class="layui-btn" lay-filter="add"
					lay-submit="" />

			</div>
		</form>
	</div>


	<script>
		layui.use([ 'form', 'layer' ], function() {
			$ = layui.jquery;
			var form = layui.form, layer = layui.layer;

			//自定义验证规则
			form.verify({
				nikename : function(value) {
					if (value.length < 5) {
						return '会议主题至少得5个字符啊';
					}
				},
				pass : [ /(.+){6,12}$/, '密码必须6到12位' ],
				repass : function(value) {
					if ($('#L_pass').val() != $('#L_repass').val()) {
						return '两次密码不一致';
					}
				}
			});

			//监听提交
			form.on('submit(add)', function(data) {

				console.log(data);
				//发异步，把数据提交给php
				layer.alert("增加成功", {
					icon : 6
				}, function() {
					document.getElementById('meetForm').submit();
					// 获得frame索引
					var index = parent.layer.getFrameIndex(window.name);
					//关闭当前frame
					parent.layer.close(index);

				});
				return false;
			});

		});
	</script>

</body>

</html>