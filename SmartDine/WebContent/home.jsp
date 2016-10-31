<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tab Menu</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>

<script type="text/javascript">
alert("Hllo");
	alert("ok");

$("#login").click(function( event ) {
	dataObject = {
  'userName':$('#txtUName').val(),
  'password':$('#txtPwd').val(),
  'userType':$('#UserType').val()
  };
console.log(dataObject);
	
$.ajax({
    url: '/TabMenu/User/login',
    type: 'post',
	contentType: "application/json; charset=utf-8",
	dataType:'json',
	data:JSON.stringify(dataObject),
    success: function(result) {
    	console.log(result);
//    	console.log(result.user.userId); 
//        console.log(result.user.userTermsCondn);
//        console.log(result);
        	if(result.status=="SUCCESS"){
        		//alert("ok");
        		var userData=result.user.userId;
        		var session = sessionStorage.setItem("UserData",userData);
        		console.log(session);
        		window.location="TabMenu/adminHome.jsp";
        		        		
    }else if (result.status=="ERROR"){	
}else{
	alert("Not ok");
}
}
});
});
</script>
<!-- <script type="text/javascript">
$(document).ready(function(e) {
	
	$("#AdminLogin").click(function(){
		 var Tabuser=$("#UserType").val();
		 var UName=$("#txtUserName").val();
		 var UPassword=$("#txtPassword").val();
		 if(Tabuser == "0")
		 {
		 	alert("Please Select User Type");
			$("#UserType").focus();
			return false;
		 }
		 if(UName==""){
		 	alert("Please Enter User Name");
			$("#txtUserName").focus();
			return false;
		 }
		 if(UPassword==""){
		 	alert("Please Enter Password");
			$("#txtPassword").focus();
			return false;
		 }
		 
	});
	

});

</script> -->
</head>
<body>
<div class="Wrapper">
	<div class="header"> <center><font size="20px">Tab Menu</font></center>
    </div>
    <div class="Reg_FormContainer">
     	<div class="LoginReg_Header">
        	LOGIN
        </div>
       
    		  <!-- Admin Login Panel -->
		        <div class="Adminlogin_Panel">
                <div class="AdminControl_Panel">
                	<div class="AdminLoginPanel_Lbl">User Type : </div>
                    <div  style="width:auto; float:left;padding-left: 20px;">
                    	<select id="UserType" class="AdmininputDD_Css">
                        <option value="0">-- Select User Type --</option>
                        <option>ADMIN</option>
                        
                        </select>
                    </div>
                </div>
            	<div class="AdminControl_Panel">
                	<div class="AdminLoginPanel_Lbl">User Name : </div>
                    <div  style="width:auto; float:left;padding-left: 20px;">
                    	<input type="text" id="txtUserName"  class="Admininput_Css" />
                    </div>
                </div>
                <div class="AdminControl_Panel">
                	<div class="AdminLoginPanel_Lbl">Password : </div>
                    <div  style="width:auto; float:left;padding-left: 20px;">
                    	<input type="password" class="Admininput_Css" id="txtPassword"  />
                    </div>
                </div>
                
            </div>
		    <!-- Admin Login Panel-->
    <div class="Admin_Reg_Row">
        	<input type="submit" class="LogInRegBtn" value="LOGIN" id="login" />
        </div>
       </div>
    
</div>



<!-- <script type="text/javascript" src="js/login.js"></script> -->
<!-- 	<center><b><font size="12">Tab Menu</font></b></center> -->
<!-- 	<ul> -->
<!-- 	<li> -->
<!-- 	<a href="adminHome.jsp">Admin</a> -->
<!-- 	</li> -->
<!-- 	</ul> -->
<%-- 	<img alt="" src="<%=request.getContextPath()%>/Images/confirm.png"> --%>
<%-- 	<%=request.getContextPath()%> --%>
</body>
</html>