<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="utf-8">
<title>编辑用户</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">

<link rel="stylesheet" href="${ctx}/static/layui/css/layui.css"
	media="all" />
<link rel="stylesheet" href="${ctx}/static/css/font-awesome.min.css">
<style type="text/css">
#Images li {
	float: left;
	margin-left: 10px;
	height: 300px;
	margin-bottom: 20px;
}

#Images img {
	height: 300px;
}

.img_del {
	cursor: pointer;
}
</style>
</head>
<body>
	<div style="margin: 15px;">
        <h5>寄件人信息</h5>
        <hr>
        <div class="layui-form">
        <div class="layui-form-item">
                <label class="layui-form-label">选择快递：</label>
                <div class="layui-input-inline" style="width:390px">
                    <select name="express" lay-verify="express">
                        <option value="1" <c:if test="${upOrder.express == 1}">selected="selected"</c:if>>圆通快递</option>
                        <option value="2" <c:if test="${upOrder.express == 2}">selected="selected"</c:if>>申通快递</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">寄件人:</label>
                <div class="layui-input-block">
                    <input type="text" name="sender" value="${upOrder.sender}" autocomplete="off"
                        class="layui-input" lay-verify="sender" placeholder="请输入寄件人"
                        style="width: 390px">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">寄件人手机:</label>
                <div class="layui-input-block">
                    <input type="text" name="senderphone" value="${upOrder.senderphone}" autocomplete="off"
                        class="layui-input" lay-verify="senderphone"
                        placeholder="请输入寄件人手机" style="width: 390px">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">省:</label>
                <div class="layui-input-block">
                    <input type="text" name="senderprovice" value="${upOrder.senderprovice}" autocomplete="off"
                        class="layui-input" lay-verify="senderprovice"
                        placeholder="请输入寄件人省份" style="width: 390px">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">市:</label>
                <div class="layui-input-block">
                    <input type="text" name="sendercity" value="${upOrder.sendercity}" autocomplete="off"
                        class="layui-input" lay-verify="sendercity" placeholder="请输入寄件人城市"
                        style="width: 390px">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">区:</label>
                <div class="layui-input-block">
                    <input type="text" name="senderdistrict" value="${upOrder.senderdistrict}" autocomplete="off"
                        class="layui-input" lay-verify="senderdistrict"
                        placeholder="请输入寄件人所在区" style="width: 390px">
                </div>
            </div>
            <!--    <div data-toggle="distpicker">
                      <select class="form-control" lay-filter="province" id="province"></select>
                   <div class="form-group">
                      <select class="form-control" id="city1"></select>
                    </div>
                    <div class="form-group">
                      <select class="form-control" id="district1"></select>
                    </div>
                  </div>-->
            <div class="layui-form-item">
                <label class="layui-form-label">详细地址：</label>
                <div class="layui-input-block">
                    <input type="text" name="address" value="${upOrder.address}" autocomplete="off"
                        class="layui-input" lay-verify="address" placeholder="请输入详细地址"
                        style="width: 390px">
                    <!--   <textarea placeholder="请输入详细地址" name="address" cols="58"></textarea>-->
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">重量:</label>
                <div class="layui-input-block">
                    <input type="text" name="weight" value="${upOrder.weight}" autocomplete="off"
                        class="layui-input" lay-verify="weight"
                        placeholder="货物重量(KG)" style="width: 390px">
                </div>
            </div>
            <h5>收件人信息</h5>
            <hr>
            <div class="layui-form-item">
                <label class="layui-form-label">收件人:</label>
                <div class="layui-input-block">
                    <input type="text" name="addressee" value="${upOrder.addressee}" autocomplete="off"
                        class="layui-input" lay-verify="addressee" placeholder="请输入收件人"
                        style="width: 390px">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">收件人手机:</label>
                <div class="layui-input-block">
                    <input type="text" name="addresseephone" value="${upOrder.addresseephone}" autocomplete="off"
                        class="layui-input" lay-verify="addresseephone"
                        placeholder="请输入收件人手机" style="width: 390px">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">省:</label>
                <div class="layui-input-block">
                    <input type="text" name="addresseeprovice" value="${upOrder.addresseeprovice}" autocomplete="off"
                        class="layui-input" lay-verify="addresseeprovice"
                        placeholder="请输入收件人省份" style="width: 390px">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">市:</label>
                <div class="layui-input-block">
                    <input type="text" name="addresseecity" value="${upOrder.addresseecity}" autocomplete="off"
                        class="layui-input" lay-verify="addresseecity"
                        placeholder="请输入收件人城市" style="width: 390px">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">区:</label>
                <div class="layui-input-block">
                    <input type="text" name="addresseedistrict" value="${upOrder.addresseedistrict}" autocomplete="off"
                        class="layui-input" lay-verify="addresseedistrict"
                        placeholder="请输入收件人所在区" style="width: 390px">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">详细地址：</label>
                <div class="layui-input-block">
                    <input type="text" name="adaddress" value="${upOrder.adaddress}" autocomplete="off"
                        class="layui-input" lay-verify="adaddress"
                        placeholder="请输入收件人详细地址" style="width: 390px">
                    <!--  <textarea placeholder="请输入收件人详细地址" name="adaddress" cols="58"></textarea>-->
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label"></label>
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit="" lay-filter="demo1">确认</button>
                    <button onclick="goBack();" class="layui-btn layui-btn-primary">返回</button>
                </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript"
	src="${ctx}/static/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${ctx}/static/layui/layui.js"></script>

<script type="text/javascript">
layui.use([ 'form', 'layer'],
        function() {
        form = layui.form, layer = layui.layer;
        form.verify({   
            sender : function(value) {
                if (value.trim() == '') {
                    return '寄件人不能为空';
                }
            },
            senderphone : function(value) {
                if (value.trim() == '') {
                    return '寄件人手机不能为空';
                }
            },
            senderprovice : function(value) {
                if (value.trim() == '') {
                    return '寄件人省份不能为空';
                }
            },
            sendercity : function(value) {
                if (value.trim() == '') {
                    return '寄件人城市不能为空';
                }
            },
            senderdistrict : function(value) {
                if (value.trim() == '') {
                    return '寄件人所在区不能为空';
                }
            },
            address : function(value) {
                if (value.trim() == '') {
                    return '具体地址不能为空';
                }
            },
            weight : function(value) {
                if (value.trim() == '') {
                    return '重量不能为空';
                }
            },
            addressee : function(value) {
                if (value.trim() == '') {
                    return '收件人不能为空';
                }
            },
            addresseephone : function(value) {
                if (value.trim() == '') {
                    return '收件人手机号不能为空';
                }
            },
            addresseeprovice : function(value) {
                if (value.trim() == '') {
                    return '收件人所在省份不能为空';
                }
            },
            addresseecity : function(value) {
                if (value.trim() == '') {
                    return '收件人所在城市不能为空';
                }
            },
            addresseedistrict : function(value) {
                if (value.trim() == '') {
                    return '收件人所在区不能为空';
                }
            }
        });
        
        //监听提交
        form.on('submit(demo1)',function(data) {
            $.ajax({
                type : "post",
                url : "${ctx}/order/updateOrder",
                dataType:"json",
                data : {
                	"id":'${upOrder.id}',
                    "express":data.field.express,
                    "sender":data.field.sender,
                    "senderphone":data.field.senderphone,
                    "senderprovice":data.field.senderprovice,
                    "sendercity":data.field.sendercity,
                    "senderdistrict":data.field.senderdistrict,
                    "address":data.field.address,
                    "weight":data.field.weight,
                    "addressee":data.field.addressee,
                    "addresseephone":data.field.addresseephone,
                    "addresseeprovice":data.field.addresseeprovice,
                    "addresseecity":data.field.addresseecity,
                    "addresseedistrict":data.field.addresseedistrict,
                    "adaddress":data.field.adaddress
                },
                success : function(result) {
                    if(result.code==0){
                        layer.msg("订单修改成功");
                        setTimeout(function () {
                             layer.closeAll("iframe");
                            //刷新父页面
                             parent.location.reload();
                          }, 1000);
                    } else{
                        layer.msg(result.msg,{time:2000});
                    }
                },error:function(){
                    layer.msg("订单修改失败");
                }
            });
            return false;
        });
    });

function goBack(){
    window.history.go(-1);
}
</script>
</html>