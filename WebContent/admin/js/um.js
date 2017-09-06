$(function(){
	$('#btnsave').on('click',function(){	
		var isValid = $('#f1').form('validate');
		if(isValid)
		{
				$.ajax({
					type:'post',
					url:'/web-project/usercontroller.do?type=add',
					data:$('#f1').serialize(),
					success:function(data){
						if(data=="1")
						{
							$.messager.alert('添加成功','添加成功','info');
							$('form').form('clear');
							$('#add').dialog('close');
							$('#tab').datagrid('reload');
						}
						if(data=="0")
						{
							$.messager.alert('添加失败','添加失败','info');
						}
					}
				})
		}
		else
		{
			$.messager.alert('添加失败','表单验证失败','info');
		}
	})
	$('#btncancel').on('click',function(){
		$('#add').dialog('close');
	});
	$('#btnedit').on('click',function(){
		var isValid = $('#f2').form('validate');
		if(isValid)
		{
				$.ajax({
					type:'post',
					url:'/web-project/usercontroller.do?type=edit',
					data:$('#f2').serialize(),
					success:function(data){
						if(data=="1")
						{
							$.messager.alert('修改成功','修改成功','info');
							$('form').form('clear');
							$('#edit').dialog('close');
							$('#tab').datagrid('reload');
						}
						if(data=="0")
						{
							$.messager.alert('修改失败','修改失败','info');
						}
					}
				
			})
		}
		else
		{
			$.messager.alert('修改失败','表单验证失败','info');
		}
	})
	$('#tab').datagrid({
		url:'/web-project/usercontroller.do',
		title:'用户管理',
		rownumbers:true,
		collapsible:true,
		queryParams: {type:'select'},
		data:[
		    {f1:'value'}
		],
		toolbar:[{
			text:'修改',
			iconCls:'icon-edit',
			handler:function(){
				var select = $('#tab').datagrid('getSelected');
				if(select==null)
				{
					$.messager.alert('修改操作','请选择要修改的行','info');
					
				}
				if(select!=null)
				{
					$('#edit').dialog('open');
					$('#edituemail').textbox('setValue',select.uemail);
					$('#edituname').textbox('setValue',select.uloginid);
					$('#edituname').textbox('readonly',true);
					$('#editupassword').textbox('setValue',select.upassword);
					$('#editutel').textbox('setValue',select.utel);
					$('#edituaddr').textbox('setValue',select.uaddress);
					$('#editusex').textbox('setValue',select.usex);
				}
			}
		},'-',
		{
			text:'添加',
			iconCls:'icon-add',
			handler:function(){
				$('#add').dialog('open');
			}
		},'-',
		{
			text:'删除 ',
			iconCls:'icon-remove',
			handler:function(){
				var sign = "0";
				var select = $('#tab').datagrid('getSelections');
				if(select=="")
				{
					$.messager.alert('删除操作','请选择要删除的行','info');
				}
				if(select!="")
				{
					$.messager.confirm('删除确认', '确认删除所选项吗', function(r){
						if (r){
						$(select).each(function(index){
							$.ajax({
								type:'post',
								url:'/web-project/usercontroller.do',
								data:{type:'del',userid:select[index].userid},
								traditional:true,
								success:function(data)
								{
									if(data=="1")
									{
										$('#tab').datagrid('reload');
									}
									if(data=="0")
									{
										sign = sign+1;
										$('#tab').datagrid('reload');
									}
								}
							})
						})
						if(sign!=0)
						{
							
							$.messager.alert('删除操作',"有"+sign+"个账号无法删除",'info');

						}
						if(sign==0)
						{
							$.messager.alert('删除操作',"删除成功",'info');
	
						}
						}
					});

				}
			}
		}
		],
		columns:[[
		    {field:'chk', checkbox:'全选'},
			{field:'userid', title:'编号'},
			{field:'uemail', title:'邮箱'},
			{field:'uloginid', title:'用户名'},
			{field:'upassword', title:'密码'},
			{field:'utel', title:'电话'},
			{field:'uaddress', title:'地址'},
			{field:'usex', title:'性别 '},
			{field:'ustateid', title:'状态编号'},
			{field:'uroleid', title:'角色编号'}
		]]
	})
})