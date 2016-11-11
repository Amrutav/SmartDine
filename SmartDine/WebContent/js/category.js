$(document).ready(function(){
	
	$('#btnUpdCat').attr("disabled", 'disabled');
	
	$("#catform").attr("action", "category/addCategory"); //Will set it
	

	
	$("#categoryName").blur(function(){
		
		var action=$("#catform").attr("action");
		
		if(action=="category/addCategory"){
		
		dataObject = {
				'categoryName':$('#categoryName').val()
		};
		console.log(dataObject);
		var categoryName=$('#categoryName').val();
		$.ajax({
		    url: 'category/validateCat?categoryName='+categoryName,
		    type: 'get',
			contentType: "application/json; charset=utf-8",
			dataType:'json',
			data:JSON.stringify(dataObject),
		    success: function(result) {
		        console.log(result); 
		        if (result.status=="EXIST"){	
		        	$("#categoryName").val('');
		        	alert("This Category already exists. Insert new one.");
		        }
		    }
		});
	
		
		}
	});
		
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
		    	table+='<tr ><td>'+result[i].categoryName+ '</td><td>' +'<div style="cursor:pointer;" onclick="assignUpdateValue('+CatID+');">'+"Edit"+'</td><td>' +'<div style="cursor:pointer;" onclick="deleteImage('+CatID+');">'+"Delete"+'</div></td></tr>';
		    });  
		    $('#dataTables-example').append(table);  
	}
	});
	
	
});

function assignUpdateValue(id){
	
	$('#btnUpdCat').prop("disabled", false);
	
	$('#btnAddCat').prop("disabled", true);
	$('#btnAddCat').css("cursor","wait");
	$("#catform").attr("action", "category/updatCategory"); //Will set it
	
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
	    	 $("#hfCatId2").val(Image);
	    	
	    }
	});
	
}

function deleteImage(id){
	
	dataObject={
			'categoryId':id
		};
	$.ajax({
	    url: '../SmartDine/category/deleteCategory',
	    type: 'delete',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:JSON.stringify(dataObject),
	    success: function(result) {
	        console.log(result);
	      
	}
	});
	
}