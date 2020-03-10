<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">添加规格</h5>
					<button type="button" onclick="addProp();">添加属性</button>

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="addspec">
					<input type="hidden" name="id" id="upId"/>
						<div class="form-group">
							<label for="specName">规格名称</label> <input type="text"
								class="form-control" id="specName" name="specName"
								aria-describedby="specNamelHelp"> <small
								id="specNamelHelp" class="form-text text-muted">请输入规格名称</small>
						</div>
						<div class="form-group form-group-proper">
							<label for="inputAddress">属性值</label> <input type="text"
								name="options[0].optionName" class="form-control"
								id="inputAddress" placeholder="1234 Main St">
							<button onclick="$(this).parent().remove()">
								删除
								</buttonn>
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

	<table class="table">
		<tr>
		
			<td>
			id<input type="checkbox" id="allSel" onchange="selectedAll()"/>
			<button type="button" class="btn btn-info btn-sm" onclick="selAll(1)">全选</button>
			<button type="button" class="btn btn-info btn-sm" onclick="selAll(2)">全不选</button>
			<button type="button" class="btn btn-info btn-sm" onclick="selAll(3)">反选</button>
			</td>
		</tr>
		<tr>
			<th>id</th>
			<th>名称</th>
			<th>详情</th>
			<th>操作</th>
			
		</tr>
		<c:forEach items="${pageInfo.list }" var="spec">
			<tr>
				<td><input type="checkbox" name="ids" value="${spec.id }" onchange="selectedOne()"/>${spec.id }</td>
				
				<td>${spec.specName }</td>
				<td><c:forEach items="${spec.options }" var="op">
					&nbsp;&nbsp; ${op.optionName }
				</c:forEach></td>
				<td>
					<button type="button" class="btn btn-danger" onclick="delSec(${spec.id})">删除</button>
					<button type="button" class="btn btn-warning" onclick="openUpdateSpec(${spec.id})">修改</button>
				</td>
			</tr>
		</c:forEach>
		
		<tr>
		<td colspan="6">
		<jsp:include page="/WEB-INF/view/common/page2.jsp"></jsp:include>
		</td>
		</tr>
	</table>
	<script type="text/javascript">
		var addindex = 1;
		function addProp() {
			$("#addspec")
					.append(
							'<div class="form-group from-group-proper">'
									+ '<label for="inputAddress">属性值</label>'
									+ '<input type="text" name="options['+addindex+'].optionName"  class="form-control" id="inputAddress" placeholder="1234 Main St">'
									+ '<button onclick="$(this).parent().remove()">删除</buttonn>'
									+ '</div>')
			addindex++;
		}
		// 给模态框增加显示成成功后的事件  
		$('#staticBackdrop').on('shown.bs.modal', function (e) {
			  // do something...
			resetAddForm();
		})
		
		// 给模态框增加关闭以后的事件  
		$('#staticBackdrop').on('hidden.bs.modal', function (e) {
			  // do something...
			refresh();
		})
		//添加窗口的复位
		function resetAddForm(){
			$(".form-group-proper").each(function(){
				$(this).remove();
			})
			addindex=1;
			$("#specName").val("")
		
		}
		/**
		 * 提交数据
		 */
		function commitSpec() {
			
			var formData = new FormData($("#addspec")[0]);
			console.log(formData.values);
			$.ajax({
				url : "/spec/add",
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
		function query() {
			$.ajax({

				async: true,

				type : "post",

				url : "/spec/list",

				data: {name: $("#queryName").val()},

				success : function(data) {

					$("#main").html(data);

				}

				});
			

		}
		//分页
		function goPage(pageNum){
			
			$.ajax({

				async: true,

				type : "post",

				url : "/spec/list?name=" + $("#queryName").val(),

				data: {pageNum:pageNum},

				success : function(data) {

					$("#main").html(data);

				}

				});
			
		}
		/**
		* 修改一个checkbox
		*/
		function selectedOne(){
			// 判断是否所有的都被选中了
			var allSelected = $("[name=ids]").length==$("[name=ids]:checked").length;
			//设置全选的框
			$("#allSel").prop("checked",allSelected)
		}
		//点击全选
		function selectedAll(){
			var checked=$("#allSel").prop("checked");
			//让每个checkbox都等于总的checkbox
			$("[name=ids]").each(function(){
				$(this).prop("checked",checked)
			})
		}
		//点击三个按钮
		function selAll(flag){
			if(flag==1){
				//全选
				$("[name=ids]").each(function(){
					$(this).prop("checked",true)
				})
			}
			if(flag==2){
				//全不选
				$("[name=ids]").each(function(){
					$(this).prop("checked",false);
					
				})
			}
			if(flag==3){
				//反选
				$("[name=ids]").each(function(){
					var ch=!$(this).prop("checked");
					$(this).prop("checked",ch);
					
				})
				
			}
			//判断是否所有的都被选中了
			var allSelected=$("[name=ids]").length==$("[name=ids]:checked").length;
			//设置全选的框
			$("#allSel").prop("checked",allSelected);
		}
		function refresh(){
			var url="/spec/list?name=${queryName}"+'&pageNum=${pageInfo.pageNum}';
			$("#main").load(url);
			
		}
		
		//删除规格
		function delSec(id){
			if(confirm("您确定删除该条数据吗？？")){
				$.post(
				"/spec/delSpec",
				{id:id},
				function(data){
					if(data=="success"){
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
		//批量删除
		function delBatch(){
			if($("[name=ids]:checked").length<=0){
				alert("没有数据被选中，不能删除");
					return;
			}
			//组织删除的数据
			var delIds=new Array();
			$("[name=ids]:checked").each(function(){
				delIds.push($(this).val());
			})
			
			if(confirm("您确定删除这些数据吗？")){
				$.post(
				"/spec/delSpecBatch",
				{ids:delIds},
				function(data){
					if(data="success"){
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
		
	</script>
</body>
</html>