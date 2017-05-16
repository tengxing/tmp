<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理页面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">

	function formatStatus(val,row){
	    if(val==0){
	        return "未审核"
	    }
		return "已审核";
	}



	function searchBlog(){
		$("#dg").datagrid('load',{
			"title":$("#s_title").val()
		});
	}

	function deleteBlog(){
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length==0){
			 $.messager.alert("系统提示","请选择要删除的数据！");
			 return;
		 }
		 var strIds=[];
		 for(var i=0;i<selectedRows.length;i++){
			 strIds.push(selectedRows[i].id);
		 }
		 var ids=strIds.join(",");
		 $.messager.confirm("系统提示","您确定要删除这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
				if(r){
					$.post("${pageContext.request.contextPath}/admin/message/delete",{ids:ids},function(result){
						if(result.success){
							 $.messager.alert("系统提示","数据已成功删除！");
							 $("#dg").datagrid("reload");
						}else{
							$.messager.alert("系统提示","数据删除失败！");
						}
					},"json");
				}
	   });
	}


	function openBlogModifyTab(){
	    var selectedRows=$("#dg").datagrid("getSelections");
        		if(selectedRows.length==0){
        			 $.messager.alert("系统提示","请选择要通过的数据！");
        			 return;
        		 }
        		 var strIds=[];
        		 for(var i=0;i<selectedRows.length;i++){
        			 strIds.push(selectedRows[i].id);
        		 }
        		 var ids=strIds.join(",");
        		 $.messager.confirm("系统提示","确定要通过这<font color=red>"+selectedRows.length+"</font>条留言吗？",function(r){
        				if(r){
        					$.post("${pageContext.request.contextPath}/admin/message/update",{ids:ids,status:1},function(result){
        						if(result.success){
        							 $.messager.alert("系统提示","数据已经更新！");
        							 $("#dg").datagrid("reload");
        						}else{
        							$.messager.alert("系统提示","数据更新失败！");
        						}
        					},"json");
        				}
        	   });
	}

</script>
</head>
<body style="margin: 1px">
<table id="dg" title="留言管理" class="easyui-datagrid"
   fitColumns="true" pagination="true" rownumbers="true"
   url="${pageContext.request.contextPath}/admin/message/lastday" fit="true" toolbar="#tb">
   <thead>
   	<tr>
   		<th field="cb" checkbox="true" align="center"></th>
   		<th field="id" width="20" align="center">编号</th>
   		<th field="nickname" width="50" align="center">留言人</th>
   		<th field="title" width="50" align="center" >标题</th>
   		<th field="content" width="200" align="center">留言内容</th>
   		<th field="messageTime" width="50" align="center">留言时间</th>
   		<th field="status" width="30" align="center" formatter="formatStatus">状态</th>
   	</tr>
   </thead>
 </table>
 <div id="tb">
 	<div>
 		<a href="javascript:openBlogModifyTab()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">审核通过</a>
 		<a href="javascript:deleteBlog()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
 	</div>
 	<div>
 		&nbsp;留言标题：&nbsp;<input type="text" id="s_title" size="20" onkeydown="if(event.keyCode==13) searchBlog()"/>
 		<a href="javascript:searchBlog()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
 	</div>
 </div>
</body>
</html>