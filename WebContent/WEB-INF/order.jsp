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
          <td class="listtitle">配送方式、时间及费用</td>
        </tr>
        <tr>
          <td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;<a href="news.html">普通快递送货上门</a></td>
        </tr>
		
<tr>
          <td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="news.html">特快专递送货上门(EMS)</a></td>
        </tr>
<tr>
          <td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="news.html">申通快递送货上门</a></td>
        </tr>
<tr>
          <td class="listtd"><img src="images/miniicon.gif" width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="news.html">普通邮寄</a></td>
        </tr>

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
      </table></td>
      <td><div style="text-align:right; margin:5px 10px 5px 0px"><a href="index.html">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;<a href="cart.html">&nbsp;购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;订单</div>
        
		
		
		
		
        <table cellspacing="0" class="infocontent">
        <tr>
          <td><table width="100%" border="0" cellspacing="0">
              <tr>
                <td><img src="images/buy2.gif" width="635" height="38" />
                  <p>早上好：${user.uloginid }先生！欢迎您来到商城结算中心</p></td>
              </tr>
              <tr>
                <td><table cellspacing="1" class="carttable">
                  <tr>
                    <td width="10%">序号</td>
                    <td width="40%">商品名称</td>
                    <td width="10%">市场价</td>
                    <td width="10%">优惠价</td>
                    <td width="10%">数量</td>
                    <td width="10%">小计</td>
                 
                  </tr>
                </table>
                   <c:set var="sum" value="0"></c:set>
                   <c:forEach items="${cartlist }" var="i">
                   <c:if test="${i.state==0&&i.userid == user.userid }">
                   	   
						   <table width="100%" border="0" cellspacing="0">
		                    <tr>
		                      <td width="10%">${i.gid }</td>
		                      <td width="40%">${i.gtitle }</td>
		                      <td width="10%">45.00</td>
		                      <td width="10%">${i.gsaleprice }</td>
		                      <td width="10%"><input id="gnumber" name="text" type="text" value="${i.gnumber }" style="width:20px"/></td>
		                      <td width="10%">${i.gsaleprice*i.gnumber }</td>
		                      <c:set var="sum" value="${i.gsaleprice*i.gnumber+sum }"></c:set>
		                      
		                    </tr>
		                  </table>
	
                  </c:if>
				  </c:forEach>
				  
			
                   </table>
				  
				   <table cellspacing="1" class="carttable">
                     <tr>
                       <td style="text-align:right; padding-right:40px;"><font style="color:#FF0000">合计：&nbsp;&nbsp;${sum }元</font></td>
                      </tr>
                   </table>	   	   
				   
				   <p>收货地址：<input name="text" type="text" value="${user.uaddress }" style="width:350px"/>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">【确认】</a><br/>
				   收货人：&nbsp;&nbsp;&nbsp;&nbsp;<input name="text" type="text" value="Tony" style="width:150px"/>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">【确认】</a><br/>
				   联系方式：<input name="text" type="text" value="${user.utel }" style="width:150px"/>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">【确认】</a>
				   
				   </p>
				  <hr/> 
				   <p style="text-align:right"><a href="orderfinal.do"><img src="images/gif53_029.gif" width="204" height="51" border="0" /></a></p></td>
              </tr>
            </table></td>
        </tr>
      </table></td>
    </tr>
  </table>
</div>



<%@include file="footer.jsp"%>


</body>
</html>
    