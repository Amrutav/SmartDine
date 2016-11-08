$(document).ready(function(){
	
	$('#btnUpdCat').attr("disabled", 'disabled');
		
	$.ajax({
	    url: 'category/categoryList',
	    type: 'get',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:"",
	    success: function(result) {
	        console.log(result);
	        var table=$("#dataTables-example");
		    $.each(result, function(i, item){
		    	var CatID=result[i].categoryId;
		    	table+='<tr ><td>'+result[i].categoryName+ '</td><td>' +'<div style="cursor:pointer;" onclick="assignUpdateValue('+CatID+');">'+"Edit"+'</td><td>' +'<div style="cursor:pointer;" onclick="deleteCategory('+CatID+');">'+"Delete"+'</div></td></tr>';
		    });  
		    $('#dataTables-example').append(table);  
	}
	});
	
	
});


/*function deleteCategory(id){
	
	dataObject={
			'categoryId':id
		};
	$.ajax({
	    url: 'category/deleteCategory',
	    type: 'delete',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:JSON.stringify(dataObject),
	    success: function(result) {
	        console.log(result.status);
	      if(result.status=="SUCCESS"){
	    	 window.locate="www.google.com";
	      }
	}
	});
	
}*/


function deleteCategory(id){
	
	dataObject={
			'categoryId':id
		};
	$.ajax({
	    url: 'category/deleteCategory',
	    type: 'delete',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:JSON.stringify(dataObject),
	    success: function(result) {
	        console.log(result);
	      
	}
	});
	
}

function assignUpdateValue(id){
	
	$('#btnUpdCat').prop("disabled", false);
	
	var catId=id;
	$.ajax({
	    url: 'category/categoryListById?categoryId='+catId,
	    type: 'get',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		
		data:"",
	    success: function(result) {
	    	console.log(result);
	    	console.log(result[0].categoryName);
	    	 var CatName=result[0].categoryName;
	    	 var Image=result[0].CategoryImage;
	    	 var CatId=result[0].categoryId;
	    	 console.log(CatName);
	    	 console.log(Image);
	    	 console.log(CatId);
	    	 $("#categoryName").val(CatName);
	    	 $("#CatImage").attr('src',Image);
	    	 $("#hfCatId").val(CatId);
	    	
	    }
	});
	
}