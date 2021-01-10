<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>用户列表</title>
<link rel="stylesheet" href="${ctx}/static/layui/css/layui.css"
    media="all">
</head>
<body>
    <form class="layui-form layui-form-pane" action="">
          <blockquote class="layui-elem-quote news_search">
            <div class="layui-form-item">
               <!--   <div class="layui-inline pane-select">
                    <label class="layui-form-label">订单编号</label>
                    <div class="layui-input-block ">
                        <input type="text" id="id" name="id"
                            lay-verify="required|number" placeholder="请输入订单编号"
                            autocomplete="off" class="layui-input">-->
                    </div>
                </div>
       <!--      <div class="layui-inline pane-input">
                    <label class="layui-form-label">订单状态</label>
                    <div class="layui-input-block">
                        <select id="userLeven" name="userLeven" lay-search="">
                            <option value="">全部</option>
                            <option value="1">已发出</option>
                            <option value="0">待发货</option>
                        </select>
                    </div>
                </div>
                 <div class="layui-inline pane-input">
                    <label class="layui-form-label">是否有效</label>
                    <div class="layui-input-block">
                        <select id="isEffect" name="isEffect" lay-search="">
                            <option value="">全部</option>
                            <option value="1">有效</option>
                            <option value="0">无效</option>
                        </select>
                    </div>
                </div>
                <div style="float: right;">
                    <a class="layui-btn search_btn" onclick="doSearch()"> <i
                        class="layui-icon">&#xe615;</i>查询
                    </a>
                </div>-->
            </div>
        </blockquote>
    </form>
    <fieldset class="layui-elem-field site-demo-button">
        <div>
            <button id="addOrder" style="margin-left: 10px;"
                class="layui-btn layui-btn-primary">新建订单</button>
        </div>
    </fieldset>
    <table class="layui-table" id="order" lay-filter="order"
        lay-data="{id: 'order'}"></table>
    <script type="text/html" id="toolBar">
        <a class="layui-btn layui-btn-mini" lay-event="updateUser" >编辑</a>
        <a class="layui-btn layui-btn-mini layui-btn-danger" lay-event="deleteUser" >禁用</a>
    </script>
 <!--   <script type="text/html" id="userLevenTpl">
       {{# var userLeven=d.userLeven}}
       {{# if (userLeven==1){}}
            <span style="color:green">管理员</span>
       {{# } else if(userLeven==0){ }}
            <span style="color:yellow">普通用户</span>
       {{# }  }}
    </script>
     <script type="text/html" id="isEffectTpl">
       {{# var isEffect=d.isEffect}}
       {{# if (isEffect==1){}}
            <span style="color:green">是</span>
       {{# } else if(isEffect==0){ }}
            <span style="color:red">否</span>
       {{# }  }}
    </script> -->
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
            var orderId = $("#orderId").val();
            //var userLeven = $("#userLeven").val();
            //var isEffect = $("#isEffect").val();
            getlist(orderId/*, userLeven, isEffect*/);
        }

        function getlist(orderId/*, userLeven, isEffect*/) {
            tableIns = table.render({
                elem : '#order',
                id : 'order',
                method : 'post',
                where : {
                    'orderId' : orderId,
                  //  'userLeven' : userLeven,
                  //  'isEffect' : isEffect
                },
                url : '${ctx}/order/getOrderList',
                cols : [ [ {
                    field : 'id',
                    title : '订单编号',
                    width : 180,
                    align : 'center',
                    sort : true
                }, {
                    field : 'username',
                    title : '取件人',
                    width : 180,
                    align : 'center'
                },  {
                    field : 'phone',
                    title : '手机号',
                    width : 180,
                    align : 'center',
                }, {
                    field : 'express',
                    title : '快递',
                    width : 180,
                    align : 'center',
                }, {
                    field : 'pickupcode',
                    title : '取件码',
                    width : 180,
                    align : 'center'
                }, {
                    field : 'address',
                    title : '送货地址',
                    width : 180,
                    align : 'center',
                }, {
                    field : 'createtime',
                    title : '创建时间',
                    width : 180,
                    align : 'center',
                    sort : true,
                },{
                    field : 'state',
                    title : '状态',
                    width : 180,
                    align : 'center',
                }] ],
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
        table.on('tool(user)', function(obj) {
            var data = obj.data;
            if (obj.event === 'updateUser') {
                var index = layui.layer.open({
                    title : "编辑用户",
                    type : 2,
                    content : "${ctx}/server/user/goUpdateUser.action?userId="
                            + data.userId,
                    success : function(layero, index) {
                        setTimeout(function() {
                            layui.layer.tips('点击此处返回',
                                    '.layui-layer-setwin .layui-layer-close', {
                                        tips : 3
                                    });
                        }, 500)
                    }
                })
                layui.layer.full(index);
            }else if (obj.event === 'deleteUser') {
                layer.confirm('确定禁用用户【'+data.realName+'】吗?', function(index){
                    //layer.close(index);
                    //向服务端发送删除指令
                    $.ajax({
                        type : "post",
                        url : "${ctx}/server/user/deleteUser.action",
                        dataType : "json",
                        data : {
                            "userId" : data.userId,
                            "isEffect" : '0'
                        },
                        success : function(data) {
                            if(data.code==0){
                                layer.msg("禁用成功!");
                                setTimeout(function () {
                                     window.location.reload();
                                 }, 1000);
                            }else{
                                layer.msg("禁用失败!");
                            }
                        }
                    });
                 });
            }
        });
        $(window).one("resize",function() {
            $("#addOrder").click(function() {
                var index = layui.layer.open({
                    title : "新建订单",
                    type : 2,
                    content : "${ctx}/order/toAddOrder",
                    success : function(layero,index) {
                        setTimeout(function() {
                            layui.layer.tips('点击此处返回','.layui-layer-setwin .layui-layer-close',{
                                tips : 3
                            });
                        }, 500)
                    }
                })
                layui.layer.full(index);
            })
        }).resize();
    </script>
</body>
</html>