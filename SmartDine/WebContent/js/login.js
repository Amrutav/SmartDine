$(document).ready(function(){

		//alert("Inside JavaScript");
		  
		$("#login").click(function(  ) {
			dataObject = {
		  'userName':$('#txtUserName').val(),
		  'password':$('#txtPassword').val(),
		  'userType':$('#UserType').val()
		  };
		console.log(dataObject);
			
		$.ajax({
		    url: 'User/login',
		    type: 'post',
			contentType: "application/json; charset=utf-8",
			dataType:'json',
			data:JSON.stringify(dataObject),
		    success: function(result) {
		    	console.log(result);
		    	alert(result.status);
		        	if(result.status=="SUCCESS"){
		        		var userData=result.user.userId;
		        		var session = sessionStorage.setItem("UserData",userData);
		        		console.log(session);
		        		window.location="AddUser.jsp";
		        		        		
		    }else if (result.status=="ERROR"){	
		}else{
			alert("Wrong Username or Password");
		}
		}
		});
		});


	

});	

