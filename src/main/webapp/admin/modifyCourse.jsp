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
    		var name=$("#name").val();
    		var teachTime=$("#teachTime").val();

    		var content=UE.getEditor('editor').getContent();
    		var feature=$("#feature").val();

    		if(name==null || name==''){
    			alert("请输入标题！");
    		}else{
    			$.post("${pageContext.request.contextPath}/admin/course/save",{'name':name,'teachTime':teachTime,'summary':content,'feature':feature},function(result){
    				if(result.success){
    					alert("课程添加成功！");
    					resetValue();
    				}else{
    					alert("课程添加失败！");
    				}
    			},"json");
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
<div id="p" class="easyui-panel" title="添加课程" style="padding: 10px">
 	<table cellspacing="20px">
   		<tr>
   			<td width="80px">课程名字：</td>
   			<td><input type="text" id="name" name="name" style="width: 400px;"/></td>
   		</tr>
   		<tr>
   			<td>课程简介：</td>
   			<td>
   				<input type="text" id="teachTime" name="teachTime" style="width: 400px;"/>
   			</td>
   		</tr>
   		<tr>
   			<td valign="top">课程内容：</td>
   			<td>
				   <script id="editor" type="text/plain" style="width:100%;height:500px;"></script>
   			</td>
   		</tr>
   		<tr>
   			<td>特色：</td>
   			<td><input type="text" id="feature" name="feature" style="width: 400px;"/>&nbsp;</td>
   		</tr>
   		<tr>
   			<td></td>
   			<td>
   				<a href="javascript:submitData()" class="easyui-linkbutton" data-options="iconCls:'icon-submit'">添加课程</a>
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
            UE.ajax.request("${pageContext.request.contextPath}/admin/course/findById",
                {
                    method:"post",
                    async : false,
                    data:{"id":"${param.id}"},
                    onsuccess:function(result){
                    	result = eval("(" + result.responseText + ")");
                    	$("#title").val(result.name);
           				$("#blogTypeId").combobox("setValue",result.courseType.id);
           				UE.getEditor('editor').setContent(result.summary);
                    }
                }
            );
        });

</script>
</body>
</html>