$(function(){
	var sign = "1";
	$('#btnsave').on('click',function(){
		var isValid = $('#f1').form('validate');
		if(isValid)
		{
			$.ajax({
				type:'post',
				url:'/web-project/goodcontroller.do?type=add',
				data:$('#f1').serialize(),
				success:function(data){
					if(data=="1")
					{
						$.messager.alert('添加成功','添加成功','info');
						$('#f1').form('clear');
						$('#add').dialog('close');
						$('#f1').form('reload');
					}
					if(data=="0")
					{
					;	$.messager.alert('添加失败','添加失败','info');
					}
				}
			});
		}
		else
		{
			$.messager.alert('添加失败','表单验证未通过','info');
		}
	})
	$('#btncancel').on('click',function(){
		$('#add').dialog('close');
	})
	$('#btnedit').on('click',function(){
		var isValid = $('#f2').form('validate');
		if(isValid)
		{

				$.ajax({
					type:'post',
					url:'/web-project/goodcontroller.do?type=edit',
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
	$('#select').combobox({
		url: '/web-project/catecontroller.do?type=search',
		valueField: 'cid',    
        textField: 'cname',
        onSelect:function(data){
        	var url = '/web-project/goodcontroller.do?type=search';
        	sign = data.cid;
        	var value = null;
        	loadgoods(data.cid,url,value);
        },
        onLoadSuccess:function(data){
        	if(data.length>0)
        	{
        		$(this).combobox('setValue',data[0].cid);
        		var cid = $(this).combobox('getValue');
        		var url = '/web-project/goodcontroller.do?type=search';
        		sign = cid;
        		var value = null;
        		loadgoods(cid,url,value);
        	}
        }
        	
	});
	$('#searchbox').searchbox({ 
		prompt:'请输入要搜索的内容',
		searcher:function(value){ 
			var url = '/web-project/goodcontroller.do?type=likesearch';
			loadgoods(sign,url,value);
			$('#searchbox').searchbox('clear');
		},
	});
})



function loadgoods(cid,url,value){
	$('#tab').datagrid({
		url:url,
		title:'商品数据',
		queryParams:{cid:cid,value:value},
		rownumbers:true,
		singleSelect:true,
		pagination:true,
		collapsible:true,
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
					
					$('#editgid').textbox('setValue',select.gid);
					$('#editgid').textbox('readonly',true);
					$('#editgtitle').textbox('setValue',select.gtitle);
					$('#editgauthor').textbox('setValue',select.gauthor);
					$('#editgsaleprice').textbox('setValue',select.gsaleprice);
					$('#editginprice').textbox('setValue',select.ginprice);
					$('#editgdesc').textbox('setValue',select.gdesc);
					$('#editgimg').textbox('setValue',select.gimg);
					$('#editgclick').textbox('setValue',select.gclick);
					$('#editcid').textbox('setValue',select.cid);
					$('#editpid').textbox('setValue',select.pid);
					
					
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
				var select = $('#tab').datagrid('getSelected');
				if(select==null)
				{
					$.messager.alert('删除操作','请选择要删除的行','info');
				}
				if(select!=null)
				{
					$.messager.confirm('删除确认', '确认删除所选项吗', function(r){
						if(r){
							$.ajax({
								type:'post',
								url:'/web-project/goodcontroller.do',
								data:{type:'del',gid:select.gid},
								success:function(data)
								{
									if(data=="1")
									{
										$.messager.alert('删除成功','删除成功','info');
										$('#tab').datagrid('reload');
									}
									if(data=="0")
									{
										$.messager.alert('删除失败','删除失败','info');
									}
								}
							})
						}				
					});
						
				}
			}
		}
		],
		columns:[[
				    {field:'chk', checkbox:'全选'},
					{field:'gid', title:'商品编号'},
					{field:'gtitle', title:'商品名称'},
					{field:'gauthor', title:'作者'},
					{field:'gsaleprice', title:'现价'},
					{field:'ginprice', title:'原价'},
					{field:'gimg', title:'图片'},
					{field:'gclick', title:'点击量 '},
					{field:'cid', title:'类别编号'},
					{field:'pid', title:'出版商编号'}
		]]
	})
}