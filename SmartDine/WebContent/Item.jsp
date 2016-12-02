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


<link rel="stylesheet" type="text/css" href="css/dd.css" />
<script src="js/jquery.dd.min.js"></script>

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
  				<a href="AddUser.jsp" class="list-group-item active BrdLine">User</a>
				<a href="AddCategory.jsp" class="list-group-item active BrdLine">Category</a>
				<a href="SubCategory.jsp" class="list-group-item active BrdLine">Sub-Category</a>
                <a href="Item.jsp" class="list-group-item active BrdLine">Item</a>
  				</div>
  		  		<div class="list-group">
  				
				
  				</div>
  		  		
        </div>
        
        <form method="post" enctype="multipart/form-data" id="itemform">
        <div class="col-lg-8" >
        	<div id="Div1" class="row" style="margin-top: 5px; margin-bottom: 10px;">
                            <div id="DIVEditCatList">
                           
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Catagory</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                   
                                     <select name="SelectCat" id="SelectCat" class="form-control">
                                     	
                                     </select>
                                </div>
                               
                            </div>
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Sub Catagory</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                   
                                     <select name="SelectSubCat" id="SelectSubCat" class="form-control">

                                     </select>
                                </div>
                               
                            </div>
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Item Name</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                     <input name="itemName" type="text" id="itemName" class="form-control">
                                </div>
                               
                            </div>
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Item Type</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                   
                                   <select name="DDTyp" class="form-control" id="DDTyp" style="width:200px">
                                  	<option value=0>-- Select Type --</option>
      								<option value="Veg" data-image="img/Veg.jpg">Veg</option>
      								<option value="NonVeg" data-image="img/NonVeg.jpg">NonVeg</option>
      								</select>
                                     
                                </div>
                               
                            </div>
                           
                                </div>
                          
                          
                          <div id="DIVEditCatList" style="float: left; width: 100%;">
                           
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Spicy Level</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                   
                                    <select name="DDSplvl" class="form-control" id="DDSplvl" style="width:200px">
      								<option value=0>-- Select Spicy Level --</option>
      								<option value="Low" data-image="img/Low.png" >Low</option>
      								<option value="Medium" data-image="img/Medium.png">Medium</option>
                                    <option value="High" data-image="img/High.png">High</option>
      								</select>
                                     
                                     
                                </div>
                               
                            </div>
                            
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Price (Full)</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                     <input name="TxtPriceFull" type="text" id="TxtPriceFull" class="form-control">
                                </div>
                               
                            </div>
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Price (Half)</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                     <input name="TxtPriceHalf" type="text" id="TxtPriceHalf" class="form-control">
                                </div>
                               
                            </div>
                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Availability</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                    <select name="ItemAvail" id="ItemAvail" class="form-control">
                                     	<option value="0">-- Availability --</option>
                                        <option value="Yes">Yes</option>
                                        <option value="No">No</option>
                                     </select>
                                </div>
                               
                            </div>
                           
                                </div>
                                
                                
                                
                                
<div id="DIVEditCatList">
                           
                            
                            
                            <div class="col-lg-6">
                                <div class="row">
                                    <div class="col-lg-12" style="padding-top: 8px;"><b>Description</b></div>
                                </div>
                                <div class="row" style="margin-left:5px;margin-top:5px;">
                                     <input name="TxtDesc" type="text" id="TxtDesc" class="form-controlTxtArea">
                                </div>
                               
                            </div>
                            <div class="col-lg-6" style="padding-top: 26px;">
                                <div class="col-lg-5" style="padding-top: 8px;">
                                    <b>Image</b>
                                    
                                    <div class="Div_Col_Button_Browse_Btn active">
                    Browse Image
                    	<input type="file" id="itemImage" value="Browse Image" class="FileUpload_Css" name="itemImage" />
                    	
                    </div>

                                </div>
                                <div class="col-lg-7">
                                    
                                         <img id="CatImage" src="img/profile.png" value="" style="height:90px;width:90px;border-width:0px;border:1px solid #ccc;">
                                  
                                </div>
                            </div>
                            
                            
                                </div>
                        </div>
                        <div class="row" style="margin-top: 5px; margin-bottom: 10px;">
                        <div class="col-lg-12 pull-left">
                                <div id="DivUpdate" data-target="" data-toggle="modal">
                                   
                                     
                                
                                     </div>
                                <div data-toggle="modal" id="ADDCategory">
                                     
                                     
                                  <input type="submit" name="btnAddItem" value="Add Item" onclick="return validate();" id="btnAddItem" class="btn btn-primary">
                                    <input type="submit" name="btnUpdItem" onclick="return updatevalidate();" value="Update Item" id="btnUpdItem" class="btn btn-default">
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
                            Item Details
                        </div>
                       
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="itemTable">
                                    <thead>
                                        <tr>
                                           
                                            <th>Item Name</th>
                                            <th>Edit</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                      
                                          
                                     
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

$(document).ready(function(e) {
	$("#DDTyp").msDropdown().data("dd");	
	$("#DDSplvl").msDropdown().data("dd");
});
</script>


<script type="text/javascript">
 function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            
            reader.onload = function (e) {
                $('#CatImage').attr('src', e.target.result);
                console.log($('#CatImage').attr('src'));
                $('#hfCatId3').attr('value', e.target.result);
                console.log($("#hfCatId3").val());
            }
            
            reader.readAsDataURL(input.files[0]);
        }
    }
    
    $("#itemImage").change(function(){
        readURL(this);
    });
    $("#btnReset").click(function(){
    	$("#CatImage").attr("src", "");
    });
    
    
    function validate() {

        var itemName = document.getElementById("itemName").value;
        var fname = document.getElementById("itemImage").value;
        var SelectCat = document.getElementById("SelectCat").value;
        var SelectSubCat = document.getElementById("SelectSubCat").value;
      //alert(fname);
        
       if (SelectCat ==0) {
            alert("Please Select Catagory");
            return false;
        } 
       
       if (SelectSubCat ==0) {
           alert("Please Select Sub-Catagory");
           return false;
       } 
      
      if (itemName =="") {
            alert("Please Enter Item");
            return false;
        }
         if (fname.length < 1) {
            alert("Please Browse File to Upload");
            return false;
        } 

      
        
        
        
        else {
            return true;
        }
    }

    function updatevalidate() {

        var itemName = document.getElementById("itemName").value;
        var fname = document.getElementById("itemImage").value;
      //alert(fname);
        
        if (itemName =="") {
            alert("Please Enter Item");
            return false;
        }     
        
        
        else {
            return true;
        }
    }
    
    
</script>

<script type="text/javascript" src="js/item.js"></script>
<script src="js/classie.js"></script>
<script src="js/nav.js"></script>

</body>
</html>