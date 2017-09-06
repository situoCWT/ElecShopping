<%@page import="org.lanqiao.entity.User"%>
<%@page import="org.lanqiao.service.UserService"%>
<%@page import="org.lanqiao.service.UserServiceImpl"%>
<%@page import="org.lanqiao.entity.Cart"%>
<%@page import="org.lanqiao.service.CartService"%>
<%@page import="org.lanqiao.service.CartServiceImpl"%>
<%@page import="org.lanqiao.entity.Goods"%>
<%@page import="org.lanqiao.service.GoodsService"%>
<%@page import="org.lanqiao.service.GoodsServiceImpl"%>
<%@page import="org.lanqiao.entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="org.lanqiao.service.CategoryService"%>
<%@page import="org.lanqiao.service.CategoryServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	CartService carts = new CartServiceImpl();
	List<Cart> cartlist = carts.getCartList();
	Object object = request.getSession().getAttribute("uloginid");
	String uloginid;
	if(object==null)
	{
		uloginid = null;
	}
	else{
		uloginid = object.toString();
	}
	int num =0;
	if(uloginid!=null)
	{
		
		UserService us = new UserServiceImpl();
		User user = us.getUser(uloginid);
		String userid = user.getUserid();
		for(int i=0;i<cartlist.size();i++)
		{
			if(cartlist.get(i).getUserid().equals(userid))
			{
				num++;
			
			}
		}
	}
	request.setAttribute("num", num);
%>
<!-- Logo -->
<div id="divhead">
  <table cellspacing="0" class="headtable">
    <tr>
      <td><a href="index.do"><img src="${pageContext.request.contextPath}/images/logo.gif" width="95" height="30" border="0" /></a></td>
      <td style="text-align:right"><img src="${pageContext.request.contextPath}/images/cart.gif" width="26" height="23" style="margin-bottom:-4px"/>&nbsp;<a href="cart.do">购物车<font color='red'>(<c:if test="${num==0 }">0</c:if><c:if test="${num!=0 }">${num}</c:if>)</font></a>　|　<a href="#">帮助中心</a>　|　<a href="${pageContext.request.contextPath}/login.do">我的帐户</a>　|　<a href="register.do">新用户注册</a></td>
    </tr>
  </table>
</div>
<!-- Logo end -->
<!-- menu -->

<%
	CategoryService cs = new CategoryServiceImpl();
	List<Category> list = cs.list();
	request.setAttribute("list", list);
%>


<div id="divmenu">
	<c:forEach items="${list}" var="i">
    <a href="list.do?cid=${i.cid }">${i.cname }</a>　　
    </c:forEach>
    　　　　<a href="list.do?cid=15" style="color:#FFFF00">全部商品目录</a>
</div>
<!-- menu end -->
<!-- search -->
<div id="divsearch"><table width="100%" border="0" cellspacing="0">
  <tr>
    <td style="text-align:right; padding-right:220px">Search
  <input type="text" name="textfield" class="inputtable"/>
<!--<input name="searchbutton" type="image" src="images/serchbutton.gif" style=" margin-bottom:-4px"/>-->
<a href="search.html"><img src="${pageContext.request.contextPath}/images/serchbutton.gif" border="0" style="margin-bottom:-4px"/></a></td>
  </tr>
</table>

</div>
<!-- search end -->