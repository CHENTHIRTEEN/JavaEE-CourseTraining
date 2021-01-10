<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>订单列表</title>
<link rel="stylesheet" href="${ctx}/static/layui/css/layui.css"
	media="all">
</head>
<body>
	<form class="layui-form layui-form-pane" action="">
		<blockquote class="layui-elem-quote news_search">
			<div class="layui-form-item">
	<!--  			<div class="layui-inline pane-input">
					<label class="layui-form-label">用户级别</label>
					<div class="layui-input-block">
						<select id="userLeven" name="userLeven" lay-search="">
							<option value="">全部</option>
							<option value="1">管理员</option>
							<option value="0">普通用户</option>
						</select>
					</div>
				</div>-->
			<!--  	<div class="layui-inline pane-input">
					<label class="layui-form-label">是否有效</label>
					<div class="layui-input-block">
						<select id="isEffect" name="isEffect" lay-search="">
							<option value="">全部</option>
							<option value="1">有效</option>
							<option value="0">无效</option>
						</select>
					</div>
				</div>-->
				
			</div>
		</blockquote>
	</form>
<!-- 	<fieldset class="layui-elem-field site-demo-button">
		<div>
			<button id="addUser" style="margin-left: 10px;"
				class="layui-btn layui-btn-primary">添加用户</button>
		</div>
	</fieldset> -->
	<table class="layui-table" id="express" lay-filter="express"
		lay-data="{id: 'express'}"></table>
	<script type="text/javascript" src="${ctx}/static/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/layui/layui.all.js"></script>
	<script>
		layui.use([ 'layer', 'table', 'laydate' ], function() {
			table = layui.table;
			layer = layui.layer;
			var laydate = layui.laydate;
			//--------------方法渲染TABLE----------------
			//日期范围
			laydate.render({
				elem : '#startAndendTime',
				calendar : true,
				range : '~'
			});
			getlist(null, null, null);
		});
		function doSearch() {
			var expressId = $("#express").val();
			getlist(expressId);
		}

		function getlist(expressId) {
			tableIns = table.render({
				elem : '#express',
				id : 'expressId',
				method : 'post',
				where : {
					'expressId' : expressId,
				},
				url : '${ctx}/express/getExpressList',
				cols : [ [ {
					field : 'number',
					title : '快递编号',
					width : 240,
					align : 'center',
					//fixed : true,
					sort : true
				},  {
					field : 'name',
					title : '姓名',
					width : 240,
					align : 'center'
				}, {
					field : 'phone',
					title : '手机号',
					width : 240,
					align : 'center'
				}, {
                    field : 'company',
                    title : '物流公司',
                    width : 240,
                    align : 'center',
                }, {
					field : 'arrivetime',
					title : '入站时间',
					width : 240,
					align : 'center',
					sort : true,
				},{
                    field : 'pickupcode',
                    title : '取件码',
                    width : 240,
                    align : 'center',
                },{
                    field : 'state',
                    title : '状态',
                    width : 240,
                    align : 'center',
                }, ] ],
				page : true,
				limits : [ 10, 20, 30, 50, 100 ],
				limit : 10, //默认采用20
				width : '100%',
				height : 'auto',
				loading : true,
				even : true,
				response : {
					statusName : 'code' //数据状态的字段名称，默认：code
					,
					statusCode : 0 //成功的状态码，默认：0
					,
					countName : 'count' //数据总数的字段名称，默认：count
					,
					dataName : 'data' //数据列表的字段名称，默认：data
				},
				done : function(res, curr, count) {
				}
			});
		}
	</script>
</body>
</html>