<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link type="text/css" href="${pageContext.request.contextPath}/pagination/mricode.pagination.css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/pagination/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pagination/mricode.pagination.js"></script>
<script type="text/javascript" charset="UTF-8">
	$(function(){
		
		$('#page').pagination({
			pageSize:5,
			firstBtnText:'首页',
			lastBtnText:'尾页',
			prevBtnText:'上一页',
			nextBtnText:'下一页',
			showInfo:true,
			showJump:true,
			remote:{
				url:'pagination.do',
				success:function(pageinfo){
					$('#contain').empty();
					var ul = "<ul>";
					$(pageinfo.list).each(function(){
						ul+="<li>"+this.gtitle+"</li>";
					})
					ul += "</ul>";
					$('#contain').append(ul);
				},
				totalName:'totalnumber'
			}
		});
	})
</script>
</head>
<body>
	<div id="contain"></div>
	<div id="page"></div>
</body>
</html>