<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
		<button type="button" class="btn btn-warning" onclick="add()">添加</button>
		<button type="button" class="btn btn-danger">批量删除</button>
	</div>
<table class="table">
	<tr>
	<th>id</th>
	<th>商品名称</th>
	<th>标题</th>
	<th>是否在售</th>
	<th>品牌</th>
	<th>分类</th>
	<th>图</th>
	
	</tr>
	<c:forEach items="${pageInfo.list }" var="spu">
	<tr>
	<td>${spu.id}</td>
	<td>${spu.goodsName }</td>
	<td>${spu.caption }</td>
	<td>${spu.isMarketable==1?"在售":"未售" }</td>
	<td>${spu.brand.name }</td>
	<td>${spu.category.name }</td>
	<td>
	<img width="100px" height="100px" src="/pic/${spu.smallPic }">
	</td>
	<td><button type="button" class="btn btn-success">详情</button>
				<button type="button" class="btn btn-danger">删除</button>
				<button type="button" class="btn btn-warning">修改</button>
				<button type="button" class="btn btn-warning" onclick="addSku(${spu.id})">添加sku</button>
				<a target="_blank"  href="/goods/down?filename=${spu.smallPic}" >下载小图</a>
			</td>
	</tr>
	</c:forEach>
<td colspan="6">
	<jsp:include page="/WEB-INF/view/common/page2.jsp"></jsp:include>
</td>
</table>
<script type="text/javascript" src="/resource/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript">
function add(){
	$("#main").load("/goods/toAdd");
}
//分页
function goPage(pageNum){
	var url ="/goods/list?pageNum="+pageNum;
	$("#main").load(url);
}
function addSku(id){
	//添加sku
	$("#main").load("/goods/toaddSku?spuId="+id);
}
</script>
