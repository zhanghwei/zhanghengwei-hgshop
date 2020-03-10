<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
<tr>
<td>id</td>
<td>标题</td>
<td>价格</td>
<td>库存</td>
<td>发布时间</td>
<td>成本价格</td>
<td>商品名称</td>
<td>品牌</td>
<td>分类</td>
<td>操作</td>
</tr>
<c:forEach items="${list }" var="sku">
<tr>
<td>${sku.id }</td>
<td>${sku.title }</td>
<td>${sku.price }</td>
<td>${sku.stockCount }</td>
<td>
<fmt:formatDate value="${sku.createTime}" pattern="yyyy-MM-dd"/> 
</td>

<td>${sku.marketPrice}</td>
<td>${sku.spu.goodsName}</td>
<td>${sku.spu.brand.name}</td>
<td>${sku.spu.category.name }</td>
<td>
<button type="button" class="btn btn-warning" onclick="add(${sku.id })">添加</button>
<button type="button" class="btn btn-success" onclick="goDetail(${sku.id})">详情</button>
<button type="button" class="btn btn-danger" onclick="delSec()">删除</button>
<button type="button" class="btn btn-warning" onclick="openUpdateBrand()">修改</button>
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
	var url ="/goods/skuList?pageNum="+pageNum;
	$("#main").load(url);
}
function goDetail(id){
	$("#main").load("/goods/skuDetail?id="+id);
	
}
function add(id){
	$("#main").load("/goods/toaddSku?id="+id);
}

</script>
</body>
</html>