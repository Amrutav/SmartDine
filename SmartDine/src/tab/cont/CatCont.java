package tab.cont;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
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

@Controller
@RequestMapping("/category")
public class CatCont {
	@Autowired
	private CategoryService categoryServices;
	private boolean flag=false;
	static final Logger logger = Logger.getLogger(Category.class);
	
	@RequestMapping(value="/addCategory", method = RequestMethod.POST)
	public ModelAndView addCategory(HttpServletRequest requst, @RequestParam(value="categoryImage",required=false)MultipartFile image){
		String status=null;
		Map<String, Object> model= new HashMap<>();
		Category category=null;
		String imgFile=null;
		String fileName=requst.getParameter("categoryName");
		String hostname="http://85.25.196.222:8080/";
		String fullPath=null;
		System.out.println("controller body");
		try{
			if(image != null){
				Date date = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss") ;
				imgFile=saveImage(fileName+dateFormat.format(date).toString()+".jpg",image);
			fullPath=hostname+imgFile;	
			category=new Category();
			category.setCategoryName(fileName);
			category.setCategoryImage(fullPath);
			flag=categoryServices.addCategory(category);
			if(flag){
				status="SUCCESS";
				System.out.println(status);
				model.put("Status", status);
			}else{
				status="UnSuccessful";
				System.out.println(status);
				model.put("Status", status);
			}
			}else{
				System.out.println("no image");
			}
			
		}catch(Exception e){
			logger.error("Error occours in : ",e);
		}
		return new ModelAndView("AddCategory", model);
	}
	
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
	
	@RequestMapping(value="/deleteCategory", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryJsonResponse deleteCategory(@Valid @RequestBody Category category){
		CategoryJsonResponse categoryJsonResponse = new CategoryJsonResponse();
		System.out.println(category.getCategoryId());
		try{
			flag = categoryServices.deleteCategory(category);
			System.out.println(flag);
			if(flag){
				categoryJsonResponse.setStatus("SUCCSS");
			}else {
				categoryJsonResponse.setStatus("FAILED");
			}
		}catch (Exception e){
			categoryJsonResponse.setStatus(e.toString());
			logger.error(e);
			System.out.println(e);
		}
		return categoryJsonResponse;
		
	}
	
	@RequestMapping(value="/updatCategory", method = RequestMethod.POST)
	public @ResponseBody CategoryJsonResponse updateCategory(HttpServletRequest requst, @RequestParam(value="categoryImage",required=false)MultipartFile image){
		CategoryJsonResponse categoryJsonRespons = new CategoryJsonResponse();
		Category category=null;
		String imgFile=null;
		String fileName=requst.getParameter("catgoryName");
		String hostname="http://85.25.196.222:8080/";
		String fullPath=null;
		System.out.println("controller body");
		try{
			if(image != null){
				Date date = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss") ;
				imgFile=saveImage(fileName+dateFormat.format(date).toString()+".jpg",image);
			fullPath=hostname+imgFile;	
			category=new Category();
			category.setCategoryName(fileName);
			category.setCategoryImage(fullPath);
			flag=categoryServices.addCategory(category);
			if(flag){
				categoryJsonRespons.setStatus("SUCCSS");
			}else{
				categoryJsonRespons.setStatus("FAILED");
			}
			}
			
		}catch(Exception e){
			logger.error("Error occours in : ",e);
			categoryJsonRespons.setStatus(e.toString());
		}
		return categoryJsonRespons;
	}
	
	@RequestMapping(value="welcome", method=RequestMethod.POST)
	public ModelAndView welcome(HttpServletRequest requst,@RequestParam(value="entry")String name){
		System.out.println("body");
		String view= requst.getParameter("entry");
		System.out.println(view);
		Map<String, Object> model= new HashMap<>();
		model.put("msg", view);
		return new ModelAndView("test", model);
		
	}
	
	private String saveImage(String filename, MultipartFile image)throws RuntimeException, IOException {

		//save image starts
		String imgSrc=null;
		try {
			
			String rootPath = System.getProperty("catalina.home");
			logger.debug(rootPath);
			logger.info(rootPath);
		    File dir = new File(rootPath + File.separator + "webapps" + File.separator + "TabMenu" + File.separator + "Images");
		    if (!dir.exists())
		     dir.mkdirs();
			File file = new File(dir.getAbsolutePath()+ File.separator+ filename);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
			logger.debug("Go to the location:  "
					+ file.toString()
					+ " on your computer and verify that the image has been stored.");
			imgSrc= "TabMenu" + File.separator + "Images" + File.separator + filename;
			return imgSrc;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Failed!", e);
		}
		return imgSrc;
		//save image ends
	}
}
