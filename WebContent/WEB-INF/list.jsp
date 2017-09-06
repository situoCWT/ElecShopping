<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="gb2312">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <meta content="all" name="robots" />
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
                <td>
                    <div style="text-align: right; margin: 5px 10px 5px 0px">
                        <a href="index.do">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;${cate.cname }</div>
                    <table cellspacing="0" class="infocontent">
                        <tr>
                            <td>
                                <table width="100%" border="0" cellspacing="0">
                                    <tr>
                                        <td style="padding: 10px">
                                            以下 <strong>${pageinfo.totalnumber }</strong> 条结果  每页最多显示<strong>${pageinfo.pagesize }</strong>条<hr />
									<c:forEach items="${pageinfo.list}" var="goods">
                                            <table border="0" cellspacing="0" class="searchtable">
                                                <tr>
                                                    <td width="20%" rowspan="2">
                                                        <div class="divbookpic">
                                                            <p>
                                                                <a href="info.do?gid=${goods.gid }&cid=${goods.cid}&pid=${goods.pid}">
                                                                    <img src="${pageContext.request.contextPath}/images/bookcover/${goods.gimg }.jpg" width="115" height="129" border="0" /></a></p>
                                                        </div>
                                                    </td>
                                                    <td colspan="2">
                                                        <font class="bookname">${goods.gtitle }</font><br />
                                                        作者：${goods.gauthor } 著<br />
                                                     ${goods.gdesc }
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        售价：<font color="#FF0000">￥${goods.gsaleprice }</font>&nbsp;&nbsp;&nbsp;&nbsp;原价：<s>￥${goods.ginprice }0</s>
                                                    </td>
                                                    <td style="text-align: right">
                                                        <a href="cart.do?gid=${goods.gid }">
                                            
                                                            <img src="${pageContext.request.contextPath}/images/buy.gif" width="91" height="27" border="0" style="margin-bottom: -8px" /></a>
                                                    </td>
                                                </tr>
                                            </table>
                                         </c:forEach>
                                           
                                           
                                           
                                           
                                           <c:set var="goods" value="${pageinfo.list[0] }"></c:set>
                                            <div class="pagination">
                                                <ul> 
                                                <c:if test="${cid==15}">
                                                
                                                	<c:if test="${pageinfo.isfirstpage }">
                                           				<li class="disablepage"><< 上一页 </li>
                                           			</c:if>
                                           			<c:if test="${!pageinfo.isfirstpage }">
                                           				<li><a href="${pageContext.request.contextPath}/list.do?pageindex=${pageinfo.pageindex-1}"><< 上一页</a></li>
                                           			</c:if>
                                                    
                                                    
                                                    
                                                    <c:if test="${pageinfo.totalpages>=12 }">
                                                    <c:if test="${pageinfo.pageindex<=5 }">
                                                    <c:forEach begin="1" end="${pageinfo.pageindex-1 }" var="i">
                                                    	<li><a href="${pageContext.request.contextPath}/list.do?cid=15&pageindex=${i}">${i }</a></li>
                                                    </c:forEach>
                                                    <li class="currentpage">${pageinfo.pageindex }</li>
                                                    <c:forEach begin="${pageinfo.pageindex+1 }" end="9" var="i">
                                                    	<li><a href="${pageContext.request.contextPath}/list.do?cid=15&pageindex=${i}">${i }</a></li>
                                                    </c:forEach>
                                                    <li>...</li>
                                                    <li><a href="${pageContext.request.contextPath}/list.do?cid=15&pageindex=${pageinfo.totalpages-1}">${pageinfo.totalpages-1 }</a></li>
                                                    <li><a href="${pageContext.request.contextPath}/list.do?cid=15&pageindex=${pageinfo.totalpages}">${pageinfo.totalpages }</a></li>
                                                    </c:if>
                                                    
                                                    
                                                    <c:if test="${pageinfo.pageindex>5&&pageinfo.pageindex<=pageinfo.totalpages-7 }">
                                                    <c:forEach begin="${pageinfo.pageindex-4 }" end="${pageinfo.pageindex-1 }" var="i">
                                                    	<li><a href="${pageContext.request.contextPath}/list.do?cid=15&pageindex=${i}">${i }</a></li>
                                                    </c:forEach>
                                                    <li class="currentpage">${pageinfo.pageindex }</li>
                                                    <c:forEach begin="${pageinfo.pageindex+1 }" end="${pageinfo.pageindex+4 }" var="i">
                                                    	<li><a href="${pageContext.request.contextPath}/list.do?cid=15&pageindex=${i}">${i }</a></li>
                                                    </c:forEach>
                                                    <li>...</li>
                                                    <li><a href="${pageContext.request.contextPath}/list.do?cid=15&pageindex=${pageinfo.totalpages-1}">${pageinfo.totalpages-1 }</a></li>
                                                    <li><a href="${pageContext.request.contextPath}/list.do?cid=15&pageindex=${pageinfo.totalpages}">${pageinfo.totalpages }</a></li>
                                                    </c:if>
                                                    
                                                    
                                                    
                                                    <c:if test="${pageinfo.pageindex>pageinfo.totalpages-7 }">
                                                    <c:forEach begin="${pageinfo.totalpages-8 }" end="${pageinfo.pageindex-1 }" var="i">
                                                    	<li><a href="${pageContext.request.contextPath}/list.do?cid=15&pageindex=${i}">${i }</a></li>
                                                    </c:forEach>
                                                    <li class="currentpage">${pageinfo.pageindex }</li>
                                                    <c:forEach begin="${pageinfo.pageindex+1 }" end="${pageinfo.totalpages }" var="i">
                                                    	<li><a href="${pageContext.request.contextPath}/list.do?cid=15&pageindex=${i}">${i }</a></li>
                                                    </c:forEach>
                                                    
                                                    </c:if>
                                                    </c:if>    
                                                    
                                                   
                                                   
                                                   <c:if test="${pageinfo.totalpages<12 }">
                                                    
                                                    <c:forEach begin="1" end="${pageinfo.pageindex-1 }" var="i">
                                                    	<li><a href="${pageContext.request.contextPath}/list.do?cid=15&pageindex=${i}">${i }</a></li>
                                                    </c:forEach>
                                                    <li class="currentpage">${pageinfo.pageindex }</li>
                                                    <c:forEach begin="${pageinfo.pageindex+1 }" end="${pageinfo.totalpages }" var="i">
                                                    	<li><a href="${pageContext.request.contextPath}/list.do?cid=15&pageindex=${i}">${i }</a></li>
                                                    </c:forEach>
                                                    </c:if>
                                                   
                                                   
                                                    
                                                    <c:if test="${pageinfo.islastpage }">
                                           				<li class="disablepage">下一页 >> </li>
                                           			</c:if>
                                           			<c:if test="${!pageinfo.islastpage }">
                                           				<li><a href="${pageContext.request.contextPath}/list.do?pageindex=${pageinfo.pageindex+1}">下一页 >></a></li>
                                           			</c:if>
                                                
                                                
                                                </c:if>
                                                
                                                
                                                
                                                
                                                <c:if test="${cid!=15}">
                                           			<c:if test="${pageinfo.isfirstpage }">
                                           				<li class="disablepage"><< 上一页 </li>
                                           			</c:if>
                                           			<c:if test="${!pageinfo.isfirstpage }">
                                           				<li><a href="${pageContext.request.contextPath}/list.do?pageindex=${pageinfo.pageindex-1}"><< 上一页</a></li>
                                           			</c:if>
                                                    
                                                    
                                                    
                                                    <c:if test="${pageinfo.totalpages>=12 }">
                                                    <c:if test="${pageinfo.pageindex<=5 }">
                                                    <c:forEach begin="1" end="${pageinfo.pageindex-1 }" var="i">
                                                    	<li><a href="${pageContext.request.contextPath}/list.do?cid=${goods.cid }&pageindex=${i}">${i }</a></li>
                                                    </c:forEach>
                                                    <li class="currentpage">${pageinfo.pageindex }</li>
                                                    <c:forEach begin="${pageinfo.pageindex+1 }" end="9" var="i">
                                                    	<li><a href="${pageContext.request.contextPath}/list.do?cid=${goods.cid }&pageindex=${i}">${i }</a></li>
                                                    </c:forEach>
                                                    <li>...</li>
                                                    <li><a href="${pageContext.request.contextPath}/list.do?cid=${goods.cid }&pageindex=${pageinfo.totalpages-1}">${pageinfo.totalpages-1 }</a></li>
                                                    <li><a href="${pageContext.request.contextPath}/list.do?cid=${goods.cid }&pageindex=${pageinfo.totalpages}">${pageinfo.totalpages }</a></li>
                                                    </c:if>
                                                    
                                                    
                                                    <c:if test="${pageinfo.pageindex>5&&pageinfo.pageindex<=pageinfo.totalpages-7 }">
                                                    <c:forEach begin="${pageinfo.pageindex-4 }" end="${pageinfo.pageindex-1 }" var="i">
                                                    	<li><a href="${pageContext.request.contextPath}/list.do?cid=${goods.cid }&pageindex=${i}">${i }</a></li>
                                                    </c:forEach>
                                                    <li class="currentpage">${pageinfo.pageindex }</li>
                                                    <c:forEach begin="${pageinfo.pageindex+1 }" end="${pageinfo.pageindex+4 }" var="i">
                                                    	<li><a href="${pageContext.request.contextPath}/list.do?cid=${goods.cid }&pageindex=${i}">${i }</a></li>
                                                    </c:forEach>
                                                    <li>...</li>
                                                    <li><a href="${pageContext.request.contextPath}/list.do?cid=${goods.cid }&pageindex=${pageinfo.totalpages-1}">${pageinfo.totalpages-1 }</a></li>
                                                    <li><a href="${pageContext.request.contextPath}/list.do?cid=${goods.cid }&pageindex=${pageinfo.totalpages}">${pageinfo.totalpages }</a></li>
                                                    </c:if>
                                                    
                                                    
                                                    
                                                    <c:if test="${pageinfo.pageindex>pageinfo.totalpages-7 }">
                                                    <c:forEach begin="${pageinfo.totalpages-8 }" end="${pageinfo.pageindex-1 }" var="i">
                                                    	<li><a href="${pageContext.request.contextPath}/list.do?cid=${goods.cid }&pageindex=${i}">${i }</a></li>
                                                    </c:forEach>
                                                    <li class="currentpage">${pageinfo.pageindex }</li>
                                                    <c:forEach begin="${pageinfo.pageindex+1 }" end="${pageinfo.totalpages }" var="i">
                                                    	<li><a href="${pageContext.request.contextPath}/list.do?cid=${goods.cid }&pageindex=${i}">${i }</a></li>
                                                    </c:forEach>
                                                    
                                                    </c:if>
                                                    </c:if>    
                                                    
                                                   
                                                   
                                                   <c:if test="${pageinfo.totalpages<12 }">
                                                    
                                                    <c:forEach begin="1" end="${pageinfo.pageindex-1 }" var="i">
                                                    	<li><a href="${pageContext.request.contextPath}/list.do?cid=${goods.cid }&pageindex=${i}">${i }</a></li>
                                                    </c:forEach>
                                                    <li class="currentpage">${pageinfo.pageindex }</li>
                                                    <c:forEach begin="${pageinfo.pageindex+1 }" end="${pageinfo.totalpages }" var="i">
                                                    	<li><a href="${pageContext.request.contextPath}/list.do?cid=${goods.cid}&pageindex=${i}">${i }</a></li>
                                                    </c:forEach>
                                                    </c:if>
                                                   
                                                   
                                                    
                                                    <c:if test="${pageinfo.islastpage }">
                                           				<li class="disablepage">下一页 >> </li>
                                           			</c:if>
                                           			<c:if test="${!pageinfo.islastpage }">
                                           				<li><a href="${pageContext.request.contextPath}/list.do?pageindex=${pageinfo.pageindex+1}">下一页 >></a></li>
                                           			</c:if>
												</c:if>
                                                </ul>
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
    <%@include file="footer.jsp"%>
</body>
</html>
