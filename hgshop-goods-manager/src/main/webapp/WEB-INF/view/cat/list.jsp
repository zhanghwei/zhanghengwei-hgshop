<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <script src="/resource/js/jquery-3.2.1.js"></script>   -->  


<link href="/resource/bootstrap/css/bootstrap.css" rel="stylesheet" >    
 
<link href="/resource/bootstrap-treeview/css/bootstrap-treeview.css" rel="stylesheet" >    
<script src="/resource/bootstrap-treeview/js/bootstrap-treeview.js"></script>    

<div class="container-fluid">
<div class="row">


	<div id="catTree" class="col-md-6">
		
	</div>
	<div id="edit" class="col-md-6">
		<form action="">
			<div class="form-group">
				<label for="">上一级别id</label>
				<input type="text" class="form-control" id="parentId" placeholder="节点名称">
			</div>
				<div class="form-group">
				<label for="">上一级别的名称</label>
				<input type="text" class="form-control" id="parentName" placeholder="节点名称">
			</div>
				<div class="form-group">
				<label for="">名称</label>
				<input type="text" class="form-control" id="name" placeholder="节点名称">
			</div>
		<button type="button" class="btn btn-primary" onclick="addChild()">添加</button>
		</form>
		<form   action="">
				<input id="currentChildLenth" value="0" type="hidden">
				<div class="form-group">
    				<label for="">当前的id</label>
    				<input type="text" class="form-control" id="currentId" placeholder="节点名称">
  				</div>
  				<div class="form-group">
    				<label for="">当前名称</label>
    				<input type="text" class="form-control" id="currentName" placeholder="节点名称">
  				</div>
  				<button type="button" class="btn btn-danger" onclick="delNode()">删除</button>
  				<button type="button" class="btn btn-primary" onclick="updateNode()">修改</button>
			</form>
	</div>
	</div>
</div> 
<script>
function initTree() {
	//发送ajax获取树需要的数据
	$.post("/cat/treeData", {},
			function(treeData) {
				//初始化添加的时候分类的树
				$("#catTree").treeview({
					data : treeData,
					levels : 2,
					onNodeSelected : function(event, node) {
						
							$("#parentId").val(node.id);
							$("#parentName").val(node.text);
							$("#name").val("");
							
							$("#currentId").val(node.id);
							$("#currentName").val(node.text);
							$("#currentChildLength").val(node.nodes.length);
						
					}
				});

			}, "json");
}
initTree();

function addChild(){
	$.post(
	"/cat/add",		
	{parentId:$("#parentId").val(),name:$("#name").val()},
	function(data){
		if(data=="success"){
			alert("插入成功");
			refresh();
		}else{
			alert("插入失败");
		}
	})
}
function refresh(){
	$("#main").load("/cat/list");
}
function delNode(){
	if($("#currentChildLength").val()>0){
		alert("该节点还有子节点，您不能删除");
		return ;
	}
	if(confirm("您确定删除该节点吗？")){
		$.post(
			"/cat/del",	
			{id:$("#currentId").val()},
			function(data){
				if(data=="success"){
					alert("删除成功");
					refresh();
				}else{
					alert("删除失败");
				}
			})
		}
	}
function updateNode(){
	$.post(
		"/cat/update",
		{id:$("#currentId").val(),name:$("#currentName").val()},
		function(data){
			if(data=="success"){
				alert("修改成功");
				refresh();
			}else{
				alert("修改失败");
			}
			
		})
	}
</script>
