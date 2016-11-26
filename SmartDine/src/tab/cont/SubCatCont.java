package tab.cont;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tab.entity.Category;
import tab.entity.CategoryJsonResponse;
import tab.entity.SubCategory;
import tab.entity.SubCategoryBean;
import tab.service.SubCategoryService;
import tab.utils.FileOperations;

@Controller
@RequestMapping("/subCategory")
public class SubCatCont {
	
	@Autowired
	private SubCategoryService subCategoryService;
	private boolean flag;
	String status=null;
	static final Logger logger = Logger.getLogger(Category.class);
	
	
	//Add Sub-Category
	
	@RequestMapping(value="/addSubCategory", method = RequestMethod.POST)
	 public void addSubCategory(HttpServletRequest requst,HttpServletResponse response, @RequestParam(value="subCategoryImage",required=false)MultipartFile image) throws ServletException, IOException{
			SubCategory subCategory=null;
			String imgFile=null;
			String fileName=requst.getParameter("subCategoryName");
			int catid=Integer.parseInt(requst.getParameter("SelectCat"));
			Category category=new Category();
			category.setCategoryId(catid);
			
			System.out.println(fileName);
			String hostname="http://85.25.196.222:8083/";
			String fullPath=null;
			System.out.println("controller body");
	        try
	        {
	            if(image != null)
	            {
	            	Date date = new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss") ;
					imgFile=FileOperations.saveImage(fileName+dateFormat.format(date).toString()+".jpg",image);
					fullPath=hostname+imgFile;	
					subCategory=new SubCategory();
					subCategory.setCategory(category);
					subCategory.setSubCategoryName(fileName);
					subCategory.setSubCategoryImage(fullPath);
				boolean flag=subCategoryService.addSubCategory(subCategory);
				System.out.println(flag);
	                if(flag){
	                	status="SUCCESS";
	                } else{
	                	status="UnSuccessful";
	                }
	            }
	        }
	        catch(Exception e)
	        {
	            logger.error("Error occours in : ", e);
	        }
	        response.sendRedirect("http://85.25.196.222:8083/SmartDine/SubCategory.jsp");
	    }
	
	
	//View Sub-Category List
	
		@RequestMapping(value = "/subCategoryList", method = RequestMethod.GET)
		public @ResponseBody List<SubCategory> getSubCategoryList(){
			List<SubCategory> subCategoryList = new ArrayList<SubCategory>();
			try {
				System.out.println("HELLO");
				subCategoryList = subCategoryService.getSubCategoryList();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return subCategoryList;
		}
		
		
		//Sub-Category List By Category Id
		
		@RequestMapping(value = "/subCategoryListById", method = RequestMethod.GET)
		public @ResponseBody List<SubCategoryBean> getSubCategoryListById(@RequestParam(value = "categoryId") int categoryId){
			List<SubCategoryBean> subCategoryListById = new ArrayList<SubCategoryBean>();
			try {
				System.out.println("HELLO");
				subCategoryListById = subCategoryService.getSubCategoryListById(categoryId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return subCategoryListById;
		}
		
		
		//Delete Category
		
		
		@RequestMapping(value="/deleteSubCategory", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public CategoryJsonResponse deleteSubCategory(@Valid @RequestBody SubCategory subCategory,HttpServletResponse response){
			CategoryJsonResponse categoryJsonResponse = new CategoryJsonResponse();
			List<SubCategoryBean> subCategoryListById = new ArrayList<SubCategoryBean>();
			int subCategoryId=subCategory.getSubCategoryId();
			System.out.println(subCategory.getSubCategoryId());
			String name=null;
			try{
				subCategoryListById = subCategoryService.getSubCategoryListById(subCategoryId);
				for(int i=0;i<subCategoryListById.size();i++){
					 name=subCategoryListById.get(i).getSubCategoryImage();
					 }
				System.out.println(name);
				boolean flag = subCategoryService.deleteSubCategory(subCategory);
				System.out.println(flag);
				if(flag){
					FileOperations.deleteFile(name);
					categoryJsonResponse.setStatus("SUCCESS");
				}else {
					categoryJsonResponse.setStatus("FAILED");
				}
			}catch (Exception e){
				categoryJsonResponse.setStatus(e.toString());
				logger.error(e);
				System.out.println(e);
			}
			
			System.out.println(categoryJsonResponse.getStatus());
			return categoryJsonResponse;
			
		}
		
		
		//Validate Sub-Category
		
		
		@RequestMapping(value = "/validateSubCat", method = RequestMethod.GET)
		public @ResponseBody CategoryJsonResponse validateSubCategory( @RequestParam(value = "subCategoryName") String subcatName) {
	    	CategoryJsonResponse catJsonResponse=new CategoryJsonResponse();
		    try {
		        SubCategory subcategory = subCategoryService.validateSubCategory(subcatName);
		        if(subcategory!=null){
		        	catJsonResponse.setStatus("EXIST");
		        }else{
		        	catJsonResponse.setStatus("NOT EXIST");
		        }
		        System.out.println(catJsonResponse);
		    	return catJsonResponse;
		       } catch (Exception e) {
		    	logger.error("Exception occurs in", e);
		    	catJsonResponse.setStatus(e.toString());
		    }
		   	return catJsonResponse;
		}
		
		
		//Sub-Category List By Sub-Category Id
		
				@RequestMapping(value = "/subCategoryById", method = RequestMethod.GET)
				public @ResponseBody List<SubCategory> getSubCategoryById(@RequestParam(value = "subCategoryId") int subCategoryId){
					List<SubCategory> subCategoryListById = new ArrayList<SubCategory>();
					try {
						System.out.println("HELLO");
						subCategoryListById = subCategoryService.getSubCategoryById(subCategoryId);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return subCategoryListById;
				}
		
				

				//Update Category
				
				@RequestMapping(value="/updatSubCategory", method = RequestMethod.POST)
				public void updateSubCategory(HttpServletRequest requst,HttpServletResponse response, @RequestParam(value="subCategoryImage",required=false)MultipartFile image)throws ServletException, IOException{
					CategoryJsonResponse categoryJsonRespons = new CategoryJsonResponse();
					SubCategory subCategory=null;
					String imgFile=null;
					String fileName=requst.getParameter("subCategoryName");
					System.out.println(fileName);
					String hfname=requst.getParameter("hfCatId2");
					String name=requst.getParameter("hfCatId3");
					System.out.println("Hidden field is: "+hfname);
					System.out.println("image field name is: "+name);
					int id=Integer.parseInt(requst.getParameter("hfCatId"));
					String hostname="http://85.25.196.222:8083/";
					String fullPath=null;
					System.out.println("Update");
					if(!hfname.equals(name)){
						System.out.println("image update ");
					
					try{
						if(image != null){
							Date date = new Date();
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss") ;
							imgFile=FileOperations.saveImage(fileName+dateFormat.format(date).toString()+".jpg",image);
						fullPath=hostname+imgFile;	
						subCategory=new SubCategory();
						subCategory.setSubCategoryId(id);
						subCategory.setSubCategoryName(fileName);
						subCategory.setSubCategoryImage(fullPath);
						boolean flag=subCategoryService.updateSubCategory(subCategory);
						if(flag){
							FileOperations.deleteFile(name);
							status="SUCCESS";
						}else{
							status="UNSUCCESS";
						}
						}
						
					}catch(Exception e){
						logger.error("Error occours in : ",e);
						categoryJsonRespons.setStatus(e.toString());
					}
					}
					else if (hfname.equals(name)) {
						System.out.println("only update ");
						try {
							subCategory=new SubCategory();
							subCategory.setSubCategoryId(id);
							subCategory.setSubCategoryName(fileName);
							subCategory.setSubCategoryImage(hfname);
							boolean flag=subCategoryService.updateSubCategory(subCategory);
							if(flag){
								FileOperations.deleteFile(name);
								status="SUCCESS";
							}else{
								status="UNSUCCESS";
							}
						} catch (RuntimeException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					response.sendRedirect("http://85.25.196.222:8083/SmartDine/AddCategory.jsp");
				}			
				
}
