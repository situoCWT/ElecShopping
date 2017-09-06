window.onload = function(){

	document.querySelector('#check_name').onclick = function(){
		var uname = document.querySelector('#uname').value;
		var httpxml = new XMLHttpRequest();
		httpxml.open("get", "checkname.do?uname="+uname, true);
		httpxml.send(null);
		
		httpxml.onreadystatechange = function(){
			
			if(httpxml.readyState==4)
			{
				
				if(httpxml.status==200)
				{
					
					var data = httpxml.responseText;
					var sp = document.querySelector('#sp');
					if(data=="1")
					{
						sp.innerHTML="账号已经存在";
						sp.style.color="red";
					}
					if(data=="0")
					{
						sp.innerHTML="账号可以使用";
						sp.style.color="green";
					}
					
				}
			}
			
		}
	}
	
}