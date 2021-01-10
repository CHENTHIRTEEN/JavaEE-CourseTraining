<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<link href="${ctx}/static/css/bootstrap.css">
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>中国省市区地址三级联动jQuery插件</title>
        
        <link href="../../css/bootstrap.css" rel="stylesheet" />
        
        
    </head>
    <body>
                <!-- <form class="form-inline"> -->
                 <div data-toggle="distpicker">
                      <select class="form-control" id="province1"></select>
                   <div class="form-group">
                      <select class="form-control" id="city1"></select>
                    </div>
                    <div class="form-group">
                      <select class="form-control" id="district1"></select>
                    </div>
                  </div>
            <!--    </form> -->
        
    </body>
    <script src="${ctx}/static/js/bootstrap.js"></script>

<script src="${ctx}/static/js/distpicker.data.js"></script>

<script src="${ctx}/static/js/distpicker.js"></script>

<script src="${ctx}/static/js/main.js"></script>
</html>
