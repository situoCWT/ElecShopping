<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript;charset=UTF-8">
	$(function(){
		$('#uname').on('input',function(){
			$.ajax({
				data:{'uname':$(this).val()},
				type:'post',
				url:'/web-project/checkname.do',
				success:function(data){
					if(data==0)
					{
						$('#sp').html('可以注册');
					}
					else if(data=1)
					{
						$('#sp').html('已被注册');
					}
				}
			})
		})
	})

</script>
</head>
<body>
	<input type="text" id="uname" /><span id="sp"></span>
</body>
</html>