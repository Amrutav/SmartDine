package tab.cont;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.servlet.ModelAndView;

import tab.entity.Category;
import tab.entity.CategoryJsonResponse;
import tab.service.CategoryService;
import tab.utils.FileOperations;

@Controller
@RequestMapping("/category")
public class CatCont {
	@Autowired
	private CategoryService categoryServices;
	private boolean flag;
	String status=null;
	static final Logger logger = Logger.getLogger(Category.class);
	
	
	//Add Category
	
	@RequestMapping(value="/addCategory", method = RequestMethod.POST)
	 public void addCategory(HttpServletRequest requst,HttpServletResponse response, @RequestParam(value="categoryImage",required=false)MultipartFile image) throws ServletException, IOException{
	    	
			Category category=null;
			String imgFile=null;
			String fileName=requst.getParameter("categoryName");
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
					category=new Category();
					category.setCategoryName(fileName);
					category.setCategoryImage(fullPath);
				boolean flag=categoryServices.addCategory(category);
				System.out.println(flag);
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
	        response.sendRedirect("http://85.25.196.222:8083/SmartDine/AddCategory.jsp");
	    }
	
	
	//View Category List
	
	@RequestMapping(value = "/categoryList", method = RequestMethod.GET)
	public @ResponseBody List<Category> getCategoryList(){
		List<Category> categoryList = new ArrayList<Category>();
		try {
			System.out.println("HELLO");
			categoryList = categoryServices.getCategoryList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryList;
	}
	
	
	//Category By Category Id
	
	@RequestMapping(value = "/categoryListById", method = RequestMethod.GET)
	public @ResponseBody List<Category> getCategoryListById(@RequestParam(value = "categoryId") int categoryId){
		List<Category> categoryListById = new ArrayList<Category>();
		String name=null;
		try {
			System.out.println("HELLO");
			categoryListById = categoryServices.getCategoryListById(categoryId);
			for(int i=0;i<categoryListById.size();i++){
				System.out.println(categoryListById.get(i).getCategoryName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<categoryListById.size();i++){
			 name=categoryListById.get(i).getCategoryName();
			System.out.println(categoryListById.get(i).getCategoryName());
			System.out.println(categoryListById.get(i).getCategoryImage());}
		System.out.println(name);
		return categoryListById;
	}
	
	
	//Delete Category
	
	
	@RequestMapping(value="/deleteCategory", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CategoryJsonResponse deleteCategory(@Valid @RequestBody Category category,HttpServletResponse response){
		CategoryJsonResponse categoryJsonResponse = new CategoryJsonResponse();
		List<Category> categoryListById = new ArrayList<Category>();
		int categoryId=category.getCategoryId();
		System.out.println(category.getCategoryId());
		String name=null;
		//String xxx="D:/Images/knhk20160915150337.jpg";
		try{
			categoryListById = categoryServices.getCategoryListById(categoryId);
			for(int i=0;i<categoryListById.size();i++){
				 name=categoryListById.get(i).getCategoryImage();
				 }
			System.out.println(name);
			boolean flag = categoryServices.deleteCategory(category);
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
		
		//response.sendRedirect("http://localhost:8080/SmartDine/AddCategory.jsp");
		
	}
	
	
	
	//Update Category
	
	@RequestMapping(value="/updatCategory", method = RequestMethod.POST)
	public void updateCategory(HttpServletRequest requst,HttpServletResponse response, @RequestParam(value="categoryImage",required=false)MultipartFile image)throws ServletException, IOException{
		CategoryJsonResponse categoryJsonRespons = new CategoryJsonResponse();
		Category category=null;
		String imgFile=null;
		String fileName=requst.getParameter("categoryName");
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
			category=new Category();
			category.setCategoryId(id);
			category.setCategoryName(fileName);
			category.setCategoryImage(fullPath);
			boolean flag=categoryServices.updateCategory(category);
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
				category=new Category();
				category.setCategoryId(id);
				category.setCategoryName(fileName);
				category.setCategoryImage(hfname);
				boolean flag=categoryServices.updateCategory(category);
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
	
	
	
	//Model and View Test
	
	@RequestMapping(value="welcome", method=RequestMethod.GET)
	public ModelAndView welcome(HttpServletRequest requst/*,@RequestParam(value="entry")String name*/){
		System.out.println("body");
		String view= "Hello";
				//requst.getParameter("entry");
		System.out.println(view);
		Map<String, Object> model= new HashMap<>();
		model.put("msg", view);
		return new ModelAndView("AddCategory", model);
		
	}
	
	
	
	//Validate Category
	
	
	@RequestMapping(value = "/validateCat", method = RequestMethod.GET)
	public @ResponseBody CategoryJsonResponse validateCategory( @RequestParam(value = "categoryName") String catName) {
    	CategoryJsonResponse catJsonResponse=new CategoryJsonResponse();
	    try {
	        Category category = categoryServices.validateCategory(catName);
	        if(category!=null){
	        	catJsonResponse.setStatus("EXIST");
	        }else{
	        	catJsonResponse.setStatus("NOT EXIST");
	        }
	    	return catJsonResponse;
	       } catch (Exception e) {
	    	logger.error("Exception occurs in", e);
	    	catJsonResponse.setStatus(e.toString());
	    }
	   	return catJsonResponse;
	}
	
}
