<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tab Menu</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>


</head>
<body>
<div class="Wrapper">
	<div class="header"> <center><font size="20px">Smart Dine</font></center>
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
        	<input type="" class="LogInRegBtn" value="LOGIN" id="login" onclick="return validate_required();" />
        </div>
       </div>
    
</div>

<script type="text/javascript">

function validate_required() {

    var Utype = document.getElementById("UserType").value;
    var name = document.getElementById("txtUserName").value;
    var Pass = document.getElementById("txtPassword").value;
    
    if (Utype == 0) {
        alert("Please Select User Type");
        return false;
    }

    if (name=="") {
        alert("Please Entent User Name");
        return false;
    }
   
    if (Pass == "") {
        alert("Please Entent Password");
        return false;
    }
   
    
    
    
    else {
        return true;
    }
}

</script>

<script type="text/javascript" src="js/login.js"></script>
</body>
</html>