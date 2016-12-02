$(document).ready(function(){
	
	$('#btnUpdItem').attr("disabled", true);
	
	$("#itemform").attr("action", "item/addItem"); //Will set it
	
//Item Name Validate
	
	$("#itemName").blur(function(){
		
		var action=$("#itemform").attr("action");
		
		if(action=="item/addItem"){
		
		dataObject = {
				'itemName':$('#itemName').val()
		};
		console.log(dataObject);
		var itemName=$('#itemName').val();
		$.ajax({
		    url: 'item/validateItem?itemName='+itemName,
		    type: 'get',
			contentType: "application/json; charset=utf-8",
			dataType:'json',
			data:JSON.stringify(dataObject),
		    success: function(result) {
		        console.log(result); 
		        if (result.status=="EXIST"){	
		        	$("#itemName").val('');
		        	alert("This Item already exists. Insert new one.");
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
	        var selectSub=$("#SelectSubCat");
	        $('<option>').text('-- Select Sub-Category --').val(0).appendTo(selectSub);
		    $.each(result, function(i, item){
		    	$('<option>').text(item.categoryName).val(item.categoryId).appendTo(select);
		    	
		    });  
		   
	}
	});
	
	
});


//view item list

$.ajax({
    url: 'item/itemList',
    type: 'get',
	contentType: "application/json; charset=utf-8",
	dataType:'json',
	data:"",
    success: function(result) {
        console.log(result);
    var table=$("#itemTable");
    $.each(result, function(i, item){
    	var ItemId=result[i].itemId;
    	table+='<tr ><td>'+result[i].itemName+ '</td><td>' +'<div style="cursor:pointer;" onclick="assignUpdateValue('+ItemId+');">'+"Edit"+'</td><td>' +'<div style="cursor:pointer;" onclick="deleteImage('+ItemId+');">'+"Delete"+'</div></td></tr>';
    });   
    $('#itemTable').append(table);  
}
});


//view sub-category by category
$("#SelectCat").blur(function(){
	//$('#itemTable tbody').remove();
	$("#SelectSubCat").empty();
	var select=$("#SelectSubCat");
    $('<option>').text('-- Select Sub-Category --').val(0).appendTo(select);
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
	    $.each(result, function(i, item){
	    	$('<option>').text(item.subCategoryName).val(item.subCategoryId).appendTo(select);
	    	
	    });   
}
});
});



//view item by category and sub-category
$("#SelectSubCat").blur(function(){
	$('#itemTable tbody').remove();
	dataObject = {
			'categoryId':$('#SelectCat').val(),
			'subCategoryId':$('#SelectSubCat').val()
	};
	console.log(dataObject);
	var categoryId=$('#SelectCat').val();
	var subCategoryId=$('#SelectSubCat').val();
$.ajax({
    url: 'item/itemListById?categoryId='+categoryId+'&subCategoryId='+subCategoryId,
    type: 'get',
	contentType: "application/json; charset=utf-8",
	dataType:'json',
	data:JSON.stringify(dataObject),
    success: function(result) {
        console.log(result);
        var table=$("#itemTable");
        $.each(result, function(i, item){
        	var ItemId=result[i].itemId;
        	console.log(ItemId);
        	table+='<tr ><td>'+result[i].itemName+ '</td><td>' +'<div style="cursor:pointer;" onclick="assignUpdateValue('+ItemId+');">'+"Edit"+'</td><td>' +'<div style="cursor:pointer;" onclick="deleteImage('+ItemId+');">'+"Delete"+'</div></td></tr>';
        });   
        $('#itemTable').append(table); 
}
});
});



//assigning the value in the field for update

function assignUpdateValue(id){
	
	$('#btnUpdItem').prop("disabled", false);
	
	$('#btnAddItem').prop("disabled", true);
	$('#btnAddItem').css("cursor","wait");
	$("#itemform").attr("action", "item/updateItem"); //Will set it
	
	var itemId=id;
	$.ajax({
	    url: 'item/itemById?itemId='+itemId,
	    type: 'get',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:"",
	    success: function(result) {
	    	console.log(result);
	    	console.log(result[0].itemName);
	    	 var ItmName=result[0].itemName;
	    	 var Image=result[0].itemImage;
	    	 var ItmId=result[0].itemId;
	    	 var prfull=result[0].priceFull;
	    	 var prhalf=result[0].priceHalf;
	    	 var itmTyp=result[0].itemType;
	    	 var spclv=result[0].itemSpicyLevel;
	    	 var avl=result[0].itemAvailability;
	    	 var desc=result[0].itemDesc;
	    	 console.log(ItmName);
	    	 console.log(Image);
	    	 console.log(ItmId);
	    	
	    	 var select=$("#SelectCat");
	    	 $("#SelectCat").empty();
	    	 $('<option>').text(result[0].category.categoryName).val(result[0].category.categoryId).appendTo(select);
	    	 var selectsub=$("#SelectSubCat");
	    	 $("#SelectSubCat").empty();
	    	 $('<option>').text(result[0].subCategory.subCategoryName).val(result[0].subCategory.subCategoryId).appendTo(selectsub);
	    	 
	    	 $("#itemName").val(ItmName);
	    	 
	    	 $("#DDTyp").val(itmTyp);
	    	 $("#DDSplvl").val(spclv);
	    	 
	    	 $("#ItemAvail").val(avl);
	    	 $("#TxtDesc").val(desc);
	    	 $("#TxtPriceFull").val(prfull);
	    	 $("#TxtPriceHalf").val(prhalf);
	    	 $("#CatImage").attr('src',Image);
	    	 $("#CatImage").attr('value',Image);
	    	 $("#hfCatId").val(ItmId);
	    	 $("#hfCatId2").val(Image);
	    	 $("#hfCatId3").val(Image);
	    	
	    }
	});
	
}

//delete the sub-category

function deleteImage(id){
	
	dataObject={
			'itemId':id
		};
	$.ajax({
	    url: 'item/deleteItem',
	    type: 'delete',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:JSON.stringify(dataObject),
	    success: function(result) {
	    	console.log(result);
	        	if(result.status=="SUCCESS"){
	        		window.location="Item.jsp";
	        		        		
	    }
	}
	});
	
}