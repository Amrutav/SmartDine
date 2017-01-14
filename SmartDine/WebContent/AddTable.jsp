<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Panel</title>
<link href="css/style.css"  rel="stylesheet" type="text/css"  />
<link href="css/bootstrap.css"  rel="stylesheet" type="text/css"  />
<link href="css/SlideMenu.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<style type="text/css">
.BrdLine{
	border-bottom: 1px solid #ccc;
	}
</style>
</head>
<body>

<div id="Wrapper">
<div class="header header_Txt">ADMIN PANEL</div>
    <div class="AdminFixedpanel_Container">
        
        <div class="Menu_RightContainer">
        	
        </div>
       
                        <div class="nav-toggler toggle-slide-left EditedF_OpenMenu" id="OpenBtn"> 
                        <div class="Admin_MenuBtn">
                    	<div class="Admin_MenuBtnRow">
                        	<img src="img/SlideCLoseOpen_Top.png" height="20" />
                        </div>
                        
                       
                    </div>
                        </div>
                      
    </div>
    <div class="DashboardContainer_Div">
    	
    	<div class="col-lg-3" >
        	
    			<div class="list-group">
    			<a href="#" class="list-group-item active BrdLine" style="background-color:#000;color:#fff;">USER</a>
  				<a href="AddUser.jsp" class="list-group-item">User</a>
  				<a href="AddTable.jsp" class="list-group-item active BrdLine">Add Table</a>
  				<a href="Assign.jsp" class="list-group-item">Assign Table</a>
  				<a href="#" class="list-group-item active BrdLine" style="background-color:#000;color:#fff;">ITEM</a>
				<a href="AddCategory.jsp" class="list-group-item">Category</a>
				<a href="SubCategory.jsp" class="list-group-item">Sub-Category</a>
				<a href="Item.jsp" class="list-group-item">Item</a>
				<a href="Logout.jsp" class="list-group-item active BrdLine" style="background-color:#000;color:#fff;">LOGOUT</a>
  				</div>
  		  		<div class="list-group">
  				
				
  				</div>
  		  		
        </div>
        
        <form method="post" enctype="multipart/form-data" id="catform">
        <div class="col-lg-8" >
        	<div id="Div1" class="row" style="margin-top: 5px; margin-bottom: 10px;">
                            <div id="DIVEditCatList">
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Table Name</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                     <input name="tableName" type="text" id="tableName" class="form-control">
                                </div>
                               
                            </div>
                                
                            </div>
                          
                        </div>
                        <div class="row" style="margin-top: 5px; margin-bottom: 10px;">
                        <div class="col-lg-12 pull-left">
                                <div id="DivUpdate" data-target="" data-toggle="modal">
                                   
                                     
                                
                                     </div>
                                <div data-toggle="modal" id="ADDCategory">
                                     
                                     
                                  <input type="submit" name="btnAddCat" value="Add Table" onclick="return validate();" id="btnAddCat" class="btn btn-primary">
                                    <input type="submit" name="btnUpdCat" onclick="return validate();" value="Update Table" id="btnUpdCat" class="btn btn-default">
                                   <input type="reset" name="btnReset" value="Reset" id="btnReset" class="btn btn-danger">
                                   <input type="hidden" name="hfCatId" id="hfCatId">
                                   <input type="hidden" name="hfCatId2" id="hfCatId2">
                                   <input type="hidden" name="hfCatId3" id="hfCatId3" value="">
                                </div>
                            </div>
                </div> 
                        
                        <div class="Contain_List">
                        	<div class="panel panel-default">
                        <div class="panel-heading">
                            Table List
                        </div>
                       
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                           
                                            <th>Table Name</th>
                                            <th>Edit</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                      
                                              <!-- <tr>
                                                  
                                                  <td></td>
                                                  <td class="center">
                                                    <a href="#">
                                                          Edit
                                                    </a>
                                                    
                                                  </td>
                                                  <td class="center"><a href="#">Delete</a></td>
                                              </tr> -->
                                          
                                     
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                        </div>
        </div>
        </form>
       
    </div>
    
    
	<div class="Admin_DigiFarm_Container">
    		  <!-- Admin Slide Menu -->
		        	<div style="min-height:0px; height:auto; width:400px;">
        				<nav class="menu slide-menu-left" style="position: absolute;min-height:98%;height: auto;top:0px;width: 400px; ">
                		<ul>
                            <li><div class="SLideMenu_header">
                            	<div class="close-menu EditedF_CLoseMenu">
                    CLOSE
                        <span class="boxclose" style="font-size: 27px;top: 9px;position: absolute;left: 56px;"></span>
                    </div>
                            </div></li>
                            <li><div class="close-menu EditedF_CLoseMenu"></div></li>
                            <li id="#">
                            	<a href="AdminHome.html">
                                        <div style="margin-top:0px;margin-left: 10px;">
                                         <span style="display:block;width: 33px; float: left;">
                                            <img src="img/Hr_Icon.png" width="15" height="15">
                                        </span>
                                        <span style="margin-top:1px;">HOME</span>
                                        </div>
                         			</a>
                            </li>
                            <li id="#">
                            	<a href="#">
                                        <div style="margin-top:0px;margin-left: 10px;">
                                         <span style="display:block;width: 33px; float: left;">
                                            <img src="img/Hr_Icon.png" width="15" height="15">
                                        </span>
                                        <span style="margin-top:1px;">ITEM MANAGEMENT</span>
                                        </div>
                         			</a>
                            </li>
                             <li id="#">
                            	<a href="#">
                                        <div style="margin-top:0px;margin-left: 10px;">
                                         <span style="display:block;width: 33px; float: left;">
                                            <img src="img/Emp_Icon.png" width="15" height="15">
                                        </span>
                                        <span style="margin-top:1px;">WAITER MANAGEMENT</span>
                                        </div>
                         			</a>
                            </li>
                            <li id="#">
                            	<a href="#">
                                        <div style="margin-top:0px;margin-left: 10px;">
                                         <span style="display:block;width: 33px; float: left;">
                                            <img src="img/Hr_Icon.png" width="15" height="15">
                                        </span>
                                        <span style="margin-top:1px;">TABLE MANAGEMENT</span>
                                        </div>
                         			</a>
                            </li>
                            
                            
                  		</ul>
						</nav>
						<!--<div class="nav-toggler toggle-slide-left EditedF_OpenMenu" id="OpenBtn">Click</div>-->
                        
       				</div>
		      <!-- Admin Slide Menu-->
    </div>

</div>

<div>

</div>
<div id="display">

</div>
<script type="text/javascript">
 
    function validate() {

        var categoryName = document.getElementById("tableName").value;
       
        
        if (categoryName =="") {
            alert("Please Enter Catagory");
            return false;
        }
        
        else {
            return true;
        }
    }

</script>
<script type="text/javascript" src="#"></script>
<script src="js/classie.js"></script>
<script src="js/nav.js"></script>

</body>
</html>

<%-- ${pageContext.request.contextPath} --%>