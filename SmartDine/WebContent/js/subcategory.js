$(document).ready(function(){
	
	$('#btnUpdSubCat').attr("disabled", 'disabled');
	
	$("#subcatform").attr("action", "subCategory/addSubCategory"); //Will set it
	
//Sub-Category add
	
	$("#subCategoryName").blur(function(){
		
		var action=$("#subcatform").attr("action");
		
		if(action=="subCategory/addSubCategory"){
		
		dataObject = {
				'subCategoryName':$('#subCategoryName').val()
		};
		console.log(dataObject);
		var subCategoryName=$('#subCategoryName').val();
		$.ajax({
		    url: 'subCategory/validateSubCat?subCategoryName='+subCategoryName,
		    type: 'get',
			contentType: "application/json; charset=utf-8",
			dataType:'json',
			data:JSON.stringify(dataObject),
		    success: function(result) {
		        console.log(result); 
		        if (result.status=="EXIST"){	
		        	$("#subCategoryName").val('');
		        	alert("This Sub-Category already exists. Insert new one.");
		        }
		    }
		});
	
		
		}
	});
	
	
	// view the category list in dropdown
		
	$.ajax({
	    url: 'category/categoryList',
	    type: 'get',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:"",
	    success: function(result) {
	        console.log(result);
	        var select=$("#SelectCat");
	        $('<option>').text('-- Select Category --').val(0).appendTo(select);
		    $.each(result, function(i, item){
		    	$('<option>').text(item.categoryName).val(item.categoryId).appendTo(select);
		    	
		    });  
		   
	}
	});
	
	
});


//view sub-category list

$.ajax({
    url: 'subCategory/subCategoryList',
    type: 'get',
	contentType: "application/json; charset=utf-8",
	dataType:'json',
	data:"",
    success: function(result) {
        console.log(result);
    var table=$("#dataTables-example");
    $.each(result, function(i, item){
    	var SubCatID=result[i].subCategoryId;
    	table+='<tr ><td>'+result[i].subCategoryName+ '</td><td>' +'<div style="cursor:pointer;" onclick="assignUpdateValue('+SubCatID+');">'+"Edit"+'</td><td>' +'<div style="cursor:pointer;" onclick="deleteImage('+SubCatID+');">'+"Delete"+'</div></td></tr>';
    });   
    $('#dataTables-example').append(table);  
}
});


//view sub-category by category
$("#SelectCat").blur(function(){
	$('#dataTables-example tbody').remove();
	dataObject = {
			'categoryId':$('#SelectCat').val()
	};
	console.log(dataObject);
	var categoryId=$('#SelectCat').val();
$.ajax({
    url: 'subCategory/subCategoryListById?categoryId='+categoryId,
    type: 'get',
	contentType: "application/json; charset=utf-8",
	dataType:'json',
	data:JSON.stringify(dataObject),
    success: function(result) {
        console.log(result);
    var table=$("#dataTables-example");
    $.each(result, function(i, item){
    	var SubCatID=result[i].subCategoryId;
    	table+='<tr ><td>'+result[i].subCategoryName+ '</td><td>' +'<div style="cursor:pointer;" onclick="assignUpdateValue('+SubCatID+');">'+"Edit"+'</td><td>' +'<div style="cursor:pointer;" onclick="deleteImage('+SubCatID+');">'+"Delete"+'</div></td></tr>';
    });   
    $('#dataTables-example').append(table);  
}
});
});


//assigning the value in the field for update

function assignUpdateValue(id){
	
	$('#btnUpdSubCat').prop("disabled", false);
	
	$('#btnAddSubCat').prop("disabled", true);
	$('#btnAddSubCat').css("cursor","wait");
	$("#subcatform").attr("action", "subCategory/updatSubCategory"); //Will set it
	
	var subcatId=id;
	$.ajax({
	    url: 'subCategory/subCategoryById?subCategoryId='+subcatId,
	    type: 'get',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:"",
	    success: function(result) {
	    	console.log(result);
	    	console.log(result[0].subCategoryName);
	    	 var CatName=result[0].subCategoryName;
	    	 var Image=result[0].subCategoryImage;
	    	 var CatId=result[0].subCategoryId;
	    	 console.log(CatName);
	    	 console.log(Image);
	    	 console.log(CatId);
	    	 var select=$("#SelectCat");
	    	 $("#SelectCat").empty();
	    	 $('<option>').text(result[0].category.categoryName).val(result[0].category.categoryId).appendTo(select);
	    	 $("#subCategoryName").val(CatName);
	    	 $("#SubCatImage").attr('src',Image);
	    	 $("#SubCatImage").attr('value',Image);
	    	 $("#hfCatId").val(CatId);
	    	 $("#hfCatId2").val(Image);
	    	 $("#hfCatId3").val(Image);
	    	
	    }
	});
	
}

//delete the sub-category

function deleteImage(id){
	
	dataObject={
			'subCategoryId':id
		};
	$.ajax({
	    url: "subCategory/deleteSubCategory",
	    type: 'delete',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:JSON.stringify(dataObject),
	    success: function(result) {
	        console.log(result);
	      
	}
	});
	
}