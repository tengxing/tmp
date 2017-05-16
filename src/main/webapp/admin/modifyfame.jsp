<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>写新闻页面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" charset="gbk" src="${pageContext.request.contextPath}/static/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="gbk" src="${pageContext.request.contextPath}/static/ueditor/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="gbk" src="${pageContext.request.contextPath}/static/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">

	function submitData(){
		var title=$("#title").val();
		var blogTypeId=$("#blogTypeId").combobox("getValue");
		var content=UE.getEditor('editor').getContent();

		if(title==null || title==''){
			alert("请输入标题！");
		}else if(blogTypeId==null || blogTypeId==''){
			alert("请选择类别！");
		}else if(content==null || content==''){
			alert("请输入内容！");
		}else{
		     var formData = new FormData();
		     formData.append("name",title);
		     formData.append("type",blogTypeId);
		     formData.append("content",content);
		     formData.append("file",document.getElementById("file").files[0]);
			$.ajax({
			    url: "${pageContext.request.contextPath}/admin/fame/save",
			    data: formData,
			    type:"post",
			    contentType:false,
			    processData:false,
			    dataType:"json",
			    success: function(result){
                         	if(result.success){
                      				alert("添加成功！");
                 					resetValue();
               				}else{
                  					alert("添加失败！");
                  	        }
                },
			});
		}
	}

	// 重置数据
	function resetValue(){
		$("#title").val("");
		$("#blogTypeId").combobox("setValue","");
		UE.getEditor('editor').setContent("");
		$("#keyWord").val("");
	}

</script>
</head>
<body style="margin: 10px">
<div id="p" class="easyui-panel" title="添加教学成果" style="padding: 10px">
 	<table cellspacing="20px">
   		<tr>
   			<td width="80px">成果标题：</td>
   			<td><input type="text" id="title" name="title" style="width: 400px;"/></td>
   		</tr>
   		<tr>
   			<td>成果类别：</td>
   			<td>
   				<select class="easyui-combobox" style="width: 154px" id="blogTypeId" name="type" editable="false" panelHeight="auto" >
					<option value="">请选择成果类别...</option>
				    <option value="家长见证">家长见证</option>
				     <option value="下载中心">下载中心</option>
                </select>
   			</td>
   		</tr>
   		<tr>
           			<td>成果上传：</td>
           			<td>
           				<input type="file" id="file" name="file" />
           			</td>
           		</tr>
   		<tr>
   			<td valign="top">成果内容：</td>
   			<td>
				   <script id="editor" type="text/plain" style="width:100%;height:500px;"></script>
   			</td>
   		</tr>
   		<tr>
   			<td></td>
   			<td>
   				<a href="javascript:submitData()" class="easyui-linkbutton" data-options="iconCls:'icon-submit'">提交成果</a>
   			</td>
   		</tr>
   	</table>
 </div>

 <script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');

     ue.addListener("ready",function(){
                //通过ajax请求数据
                UE.ajax.request("${pageContext.request.contextPath}/admin/fame/findById",
                    {
                        method:"post",
                        async : false,
                        data:{"id":"${param.id}"},
                        onsuccess:function(result){
                        	result = eval("(" + result.responseText + ")");
                        	$("#title").val(result.name);
               				$("#blogTypeId").combobox("setValue",type);
               				UE.getEditor('editor').setContent(result.content);
                        }
                    }
                );
            });

</script>
</body>
</html>