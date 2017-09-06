<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="gb2312">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta content="all" name="robots"/>
<meta name="author" content="Fisher" />
<meta name="Copyright" content="Copyright 2007-2008, 版权所有 www.reefdesign.cn" />
<meta name="description" content="reefdesign" />
<meta name="keywords" content="reefdesign" />
<title>电子书城</title>

<link rel="stylesheet" rev="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="all" />
</head>

<body class="main">

<%@include file="header.jsp"%>


<div id="divpagecontent">
  <table width="100%" border="0" cellspacing="0">
    <tr>
      <td width="25%"><table width="100%" border="0" cellspacing="0" style="margin-top:30px">
        <tr>
          <td class="listtitle">我的帐户</td>
        </tr>
        <tr>
          <td class="listtd"><img src="${pageContext.request.contextPath}/images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
		  <a href="modifyuserinfo.html">用户信息修改</a></td>
        </tr>
		
<tr>
          <td class="listtd"><img src="${pageContext.request.contextPath}/images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="orderlist.html">订单查询</a></td>
        </tr>
<tr>
          <td class="listtd"><img src="${pageContext.request.contextPath}/images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="news.html">帐户余额</a></td>
        </tr>
<tr>
          <td class="listtd"><img src="${pageContext.request.contextPath}/images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="news.html">我的收藏</a></td>
        </tr>

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
      </table></td>
      <td><div style="text-align:right; margin:5px 10px 5px 0px"><a href="${pageContext.request.contextPath}/index.do">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/login.do">&nbsp;我的帐户</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;订单查询</div>
        
		
		
		
		
        <table cellspacing="0" class="infocontent">
        <tr>
          <td style="padding:20px"><p>欢迎XXX光临XXX商城！</p>
            <p>您已经成交了3笔交易，有<font style="color:#FF0000">1</font>项交易正在处理中...</p>
            <table width="100%" border="0" cellspacing="0" class="tableopen">
              <tr>
                <td bgcolor="#A3E6DF" class="tableopentd01">订单号</td>
                <td bgcolor="#A3E2E6" class="tableopentd01">订单内容</td>
                <td bgcolor="#A3D7E6" class="tableopentd01">收件人</td>
                <td bgcolor="#A3CCE6" class="tableopentd01">订单时间</td>
                <td bgcolor="#A3B6E6" class="tableopentd01">状态</td>
              </tr>
              <c:forEach items="${list1 }" var="i">
              <tr>
                <td class="tableopentd02">${i.orderid }</td>
                <td class="tableopentd02"><a href="${pageContext.request.contextPath}/info.do?gid=${i.gid}">${i.gtitle }
                </a></td>
                <td class="tableopentd02">Tony</td>
                <td class="tableopentd02">${i.orderdate }</td>
                <td class="tableopentd03">${i.state }</td>
              </tr>
			  </c:forEach>
            </table></td>
        </tr>
      </table>
	  
	  
	  </td>
    </tr>
  </table>
</div>



<%@include file="footer.jsp"%>


</body>
</html>
    