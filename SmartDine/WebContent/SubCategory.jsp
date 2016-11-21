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
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>

<style type="text/css">
.BrdLine{
	border-bottom: 1px solid #ccc;
	}
</style>
</head>
<body>

<div id="Wrapper">
<div class="header">
    </div>
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
  				<a href="AddUser.jsp" class="list-group-item active BrdLine">Add User</a>
				<a href="AddCategory.jsp" class="list-group-item active BrdLine">Add Category</a>
				<a href="SubCategory.jsp" class="list-group-item active BrdLine">Add Sub-Category</a>
  
</div>
  		  
        </div>
        
        <div class="col-lg-8" >
        	<div id="Div1" class="row" style="margin-top: 5px; margin-bottom: 10px;">
                            <div id="DIVEditCatList">
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Catagory</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                   
                                     <select name="SelectCat" id="SelectCat" class="form-control">
                                     	<option value="0">-- Select Catagory --</option>
                                        <option value="1">Catagory One</option>
                                        <option value="2">Catagory Two</option>
                                     </select>
                                </div>
                               
                            </div>
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Sub Catagory</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                     <input name="txtCat" type="text" id="txtSubCat" class="form-control">
                                </div>
                               
                            </div> 
                            <div class="col-lg-6">
                                <div class="col-lg-5" style="padding-top: 8px;">
                                    <b>Image</b>
                                    
                                    <div class="Div_Col_Button_Browse_Btn active">
                    Browse Image
                    	<input type="file" id="Img_files" value="Browse Image" class="FileUpload_Css" />
                    	
                    </div>

                                </div>
                                <div class="col-lg-7">
                                    
                                         <img id="SubCatImage" src="img/profile.png" style="height:90px;width:90px;border-width:0px;border:1px solid #ccc;">
                                  
                                </div>
                            </div>
                                </div>
                            

                        </div>
                        <div class="row">
                        	<div class="col-lg-12">
                                <div id="DivUpdate" data-target="" data-toggle="modal">
                                   
                                     
                                
                                     </div>
                                <div data-toggle="modal" id="ADDSubCat">
                                    
                                    <input type="submit" name="btnAddSubCat" value="Add Sub Catagory" onclick="return validate();" id="btnAddSubCat" class="btn btn-primary">
                                    <input type="submit" name="btnUpdSubCat" onclick="return validate();" value="Update Catagory" id="btnUpdSubCat" class="btn btn-default">
                                   <input type="reset" name="btnReset" value="Reset" id="btnReset" class="btn btn-danger">
                                   
                                </div>
                            </div>
                        </div>
                        
                        <div class="Contain_List">
                        	<div class="panel panel-default">
                        <div class="panel-heading">
                            Sub Catagory List
                        </div>
                       
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                           
                                            <th>Sub Catagory Name</th>
                                            <th>Edit</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                      
                                              <tr>
                                                  
                                                  <td></td>
                                                  <td class="center">
                                                    <a href="#">
                                                          Edit
                                                    </a>
                                                    
                                                  </td>
                                                  <td class="center"><a href="#">Delete</a></td>
                                              </tr>
                                          
                                     
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                        </div>
        </div>
       
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
                            <!--<li id="lIPROFILE">
                                <div style="">
                            		<span style="margin-top:8px;">
                             		<a href="#">
                            		USER TYPE
                           			 </a>
                            		</span>
                         		</div>
                                
                                <div style="padding: 0px 0px 10px 10px;" id="DIVUsertype" style="display:none;">
                          			<a href="#">
                                        <div style="margin-top:0px;margin-left: 10px;">
                                         <span style="display:block;width: 33px; float: left;">
                                            <img src="img/Hr_Icon.png" width="15" height="15">
                                        </span>
                                        <span style="margin-top:1px;">ITEM MANAGEMENT</span>
                                        </div>
                         			</a>
                          			<a href="#">
                         				 <div style="margin-top:0px;margin-left: 10px;">
                         				 <span style="display:block;width: 33px; float: left;">
                                   		 	<img src="img/Emp_Icon.png" width="15" height="15">
                             			 </span>
                         				<span style="margin-top:1px;">WAITER MANAGEMENT</span>
                             			</div>
                         </a>
                         </div>
                                
                                
                            </li>-->
                            
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


<script type="text/javascript" src="js/admin.js"></script>
<script src="js/classie.js"></script>
<script src="js/nav.js"></script>

</body>
</html>