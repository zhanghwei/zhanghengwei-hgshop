<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- <link href="/resource/bootstrap4/css/bootstrap.css" rel="stylesheet" >
<script type="text/javascript" src="/resource/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript" src="/resource/bootstrap4/js/bootstrap.js"></script> -->
<div>
		<input type="text" id="queryName" value="${queryName }" />
		<button type="button" class="btn btn-primary" onclick="query()">查询</button>
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#staticBackdrop">添加</button>
		<button type="button" class="btn btn-primary" onclick="delBatch()">
   			批量删除</button>
</div>
<!-- Modal -->
	<div class="modal fade" id="staticBackdrop" data-backdrop="static"
		tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				
				<div class="modal-body">
					<form id="addspec">
					<input type="hidden" name="id" id="upId"/>
						<div class="form-group">
							<label for="name">品牌名称</label> <input type="text"
								class="form-control" id="name" name="name"
								aria-describedby="specNamelHelp"> <small
								id="specNamelHelp" class="form-text text-muted">请输入品牌名称</small>
						</div>
						<div class="form-group form-group-proper">
							<label for="inputAddress">首字母</label> <input type="text"
								name="firstChar" class="form-control"
								id="firstChar" placeholder="A">
						</div>

					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary"
						onclick="commitSpec()">提交</button>
				</div>
			</div>
		</div>
	</div>
<!-- Modal -->
<div class="modal fade" id="staticBackdropUpdate" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<form id="updateBrand">	
					<input type="text" name="id" id="id" class="form-control" value="${id}"/>
					<div class="form-group">
						<label for="name">品牌名称</label> 
						
						<input type="text"	class="form-control" id="brandName" name="name" aria-describedby="specNamelHelp" value="${name }"> 
						<small id="specNamelHelp" class="form-text text-muted">请输入品牌名称</small>
					</div>
					<div class="form-group form-group-proper">
						<label for="inputAddress">首字母</label> 
						<input type="text"name="firstChar" class="form-control" id="first" placeholder="A" value="${firstChar }">
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" onclick="update()">提交</button>
				</div>
			</div>
		</div>
	</div>
<table class="table">
<tr>
<td>id</td>
<td>品牌</td>
<td>首字母</td>
<td>操作</td>
</tr>
<c:forEach items="${list }" var="b">
<tr>
<td>${b.id }</td>
<td>${b.name}</td>
<td>${b.firstChar}</td>
<td>
	<button type="button" class="btn btn-danger" onclick="delSec(${b.id})">删除</button>
	<button type="button" class="btn btn-warning" onclick="openUpdateBrand(${b.id})">修改</button>
</td>

</tr>

</c:forEach>
<td colspan="6">
	<jsp:include page="/WEB-INF/view/common/page2.jsp"></jsp:include>
</td>
</table>
<script type="text/javascript">
//分页
function goPage(pageNum){
	var url ="/goods/brandList?pageNum="+pageNum;
	$("#main").load(url);
}
function query() {
	var url = "/goods/brandList?name="+$("#queryName").val();
	$("#main").load(url)
}
/**
 * 提交数据
 */
function commitSpec() {
	
	var formData = new FormData($("#addspec")[0]);
	console.log(formData.values);
	$.ajax({
		url : "/goods/add",
		async: true,
		dataType : "JSON",
		data : formData,
		//让jQuery不要再提交数据之前进行处理
		processData : false,
		//提交 的数据不能加消息头
		contentType : false,
		
		//提交的方式
		type : "post",
		//成功后的回调函数
		success : function(data) {
			console.log(data);
			if(data){
				alert("数据提交成功");
				$("#staticBackdrop").modal('hide');
			}else{
				alert("数据保存失败");
			}
		}
	})
}
function update() {
	
	var formData = new FormData($("#updateBrand")[0]);
	console.log(formData.values);
	$.ajax({
		url : "/goods/update",
		async: true,
		dataType : "JSON",
		data : formData,
		//让jQuery不要再提交数据之前进行处理
		processData : false,
		//提交 的数据不能加消息头
		contentType : false,
		
		//提交的方式
		type : "post",
		//成功后的回调函数
		success : function(data) {
			console.log(data);
			if(data){
				alert("数据提交成功");
				$("#staticBackdropUpdate").modal('hide');
			}else{
				alert("数据保存失败");
			}
		}
	})
}
function refresh(){
	var url="/goods/brandList?name=${queryName}"+'&pageNum=${pageInfo.pageNum}';
	$("#main").load(url);
	
}

//删除规格
function delSec(id){
	if(confirm("您确定删除该条数据吗？？")){
		$.post(
		"/goods/del",
		{id:id},
		function(data){
			if(data){
				alert("删除成功");
				refresh();
			}else{
				alert("删除失败");
			}
		}
		)
	}else{
		return;
	}
}
//给添加规格模态框增加关闭以后的事件  
$("#staticBackdrop").on('hidden.bs.modal', function (e) {
	  // do something...
	refresh();
}) 

// 给修改规格模态框增加关闭以后的事件  
$('#staticBackdropUpdate').on('hidden.bs.modal', function (e) {
	  // do something...
	refresh();
}) 
function openUpdateBrand(id){
	
	$.post(
		"/goods/getBrand",
		{id:id},
		function(data){
		console.log(data);
		//品牌id
		$("#id").val(data.id)
		$("#brandName").val(data.name)
		$("#first").val(data.firstChar)
	});
	$("#staticBackdropUpdate").modal('show');
}
</script>