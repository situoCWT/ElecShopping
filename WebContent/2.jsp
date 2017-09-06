<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.google.gson.Gson"%>
<%@page import="org.lanqiao.entity.Search"%>
<%@page import="java.util.List"%>
<%@page import="com.google.gson.reflect.TypeToken"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" charset="UTF-8">
	$(function(){
		$('#search').on('input',function(){
			$.ajax({
				data:{'search':$(this).val()},
				url:'/web-project/search.do',
				type:'post',
				dataType:"json",
				success:function(data){
					$('option').remove();
					$(data).each(function(index,list){
						$('#ds').append("<option value='"+list.sname+"'></option>");
					});
				}
			})
		})
	})

</script>
</head>
<body>
	<div id="div1"></div>
	<input type="text" id="search" list="ds"/>
	<datalist id="ds">
		
	</datalist>
</body>
</html>