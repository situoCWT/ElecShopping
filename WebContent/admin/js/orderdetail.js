$(function(){
	$('#btnsave').on('click',function(){	
		var isValid = $('#f1').form('validate');
		if(isValid)
		{
				$.ajax({
					type:'post',
					url:'/web-project/orderdetailcontroller.do?type=add',
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
					url:'/web-project/orderdetailcontroller.do?type=edit',
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
		url:'/web-project/orderdetailcontroller.do',    
		title:'订单详情',
		queryParams:{type:'search'},
	    singleSelect:true,
	    collapsible:true,
	    rownumbers:true,
	    toolbar:[
{
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
			$('#editorderdetailid').textbox('setValue',select.orderdetailid);
			$('#editorderdetailid').textbox('readonly',true);
			$('#editgtitle').textbox('setValue',select.gtitle);
			$('#editgsaleprice').textbox('setValue',select.gsaleprice);
			$('#editgnumber').textbox('setValue',select.gnumber);
			$('#editorderid').textbox('setValue',select.orderid);
			$('#editorderid').textbox('readonly',true);
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
				if (r){
					$.ajax({
						type:'post',
						url:'/web-project/orderdetailcontroller.do',
						data:{type:'del',orderdetailid:select.orderdetailid},
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
				}
			});

		}
	}
}
	             ],
	    columns:[[    
	  	        {field:'chk', checkbox:'全选'},
	  	        {field:'orderdetailid',title:'订单详情编号'},    
	  	        {field:'gtitle',title:'商品名称'},
	  	        {field:'gsaleprice',title:'商品价格 '},
	  	        {field:'gnumber',title:'商品数量'},
	  	        {field:'orderid',title:'订单编号'},
	  	    ]] 
	})
})