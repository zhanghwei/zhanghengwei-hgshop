<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<div>
<form id="addSkuFrm">
		<div class="form-row">
		    <div class="col">
		       <label>商品名称</label>	
		        <input type="hidden" name="spuId" value="${spu.id}">
		        <input type="text" disabled="disabled" value="${spu.goodsName}" name="goodsName" class="form-control" placeholder="商品名称">
		    </div>
		  </div>
		  
		  <div class="form-row">
		    <div class="col">
		       <label>标题</label>	
		        <input type="text" name="title" class="form-control" placeholder="标题">
		    </div>
		  </div>
		  
		   <div class="form-row">
		    <div class="col">
		       <label>卖点</label>	
		        <input type="text" name="sellPoint" class="form-control" 
		        placeholder="卖点">
		    </div>
		  </div>
		  
		  <div class="form-row">
		    <div class="col">
		       <label>价格</label>	
		        <input type="text" name="price" class="form-control" 
		        placeholder="价格">
		    </div>
		  </div>
		  
		  <!-- 一个属性，用于追加属性保存其中的html -->
		  <div id="oneSpec"> 
		    <div class="form-row">
			    <div class="col">
			       <label>属性</label>
			       <select  name="specIds" class="form-control form-control-lg"
			       onchange="specChange($(this))">
					 	<c:forEach items="${specs}" var="spec" >
					 		<option value="${spec.id}" >${spec.specName}</option>
					 	</c:forEach>
					</select>
			    </div>
			    <div class="col">
			       <label>属性选项（数值）</label>	
			       <select  name="specOptionIds" class="form-control form-control-lg">
					 	
					</select>
			    </div>
			    <div class="col">
			     <label></label>
			    	<button type="button" class="btn btn-danger" onclick="delNode()">删除</button>
			    </div>
			  </div>
			  
			  </div>
		  <div id="speclList">
			  
		  </div>
		  <div>
		  	 <button type="button" class="btn btn-danger" onclick="addSpec()">增加属性</button>
		  </div>
		   
		    <div class="form-row">
		    <div class="col">
		       <label>小图</label>	
		      <input type="file" name="file" class="form-control-file" id="exampleFormControlFile1">
		    </div>
		  </div>
		  
  	  	<div class="form-row">
		    <div class="col">
				<button type="button" class="btn btn-primary"  onclick="commitData()">添加 </button>
   			</div>
   		</div>
   	
	</form>
</div>
<script>
function addSpec(){
	$("#speclList").append($("#oneSpec").html());
}

</script>