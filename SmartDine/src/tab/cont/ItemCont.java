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
import tab.entity.Item;
import tab.entity.ItemBean;
import tab.entity.ItemJsonResponse;
import tab.entity.SubCategory;
import tab.service.ItemService;
import tab.utils.FileOperations;

@Controller
@RequestMapping("/item")
public class ItemCont {
	@Autowired
	ItemService itemServices;
	private boolean flag=false;
	String status=null;
	static final Logger logger = Logger.getLogger(Category.class);
	
	
	//Add Item
	
	@RequestMapping(value="/addItem", method = RequestMethod.POST)
	 public void addSubCategory(HttpServletRequest requst,HttpServletResponse response, @RequestParam(value="itemImage",required=false)MultipartFile image) throws ServletException, IOException{
			Item item=null;
			String imgFile=null;
			String fileName=requst.getParameter("itemName");
			int catid=Integer.parseInt(requst.getParameter("SelectCat"));
			int subcatid=Integer.parseInt(requst.getParameter("SelectSubCat"));
			String type=requst.getParameter("DDTyp");
			String spicy=requst.getParameter("DDSplvl");
			Double prFull=Double.parseDouble(requst.getParameter("TxtPriceFull"));
			Double prHalf=Double.parseDouble(requst.getParameter("TxtPriceHalf"));
			String avail=requst.getParameter("ItemAvail");
			String desc=requst.getParameter("TxtDesc");
			Category category=new Category();
			category.setCategoryId(catid);
			SubCategory subCategory=new SubCategory();
			subCategory.setSubCategoryId(subcatid);
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
					item=new Item();
					item.setItemImage(fullPath);
					item.setCategory(category);
					item.setSubCategory(subCategory);
					item.setItemName(fileName);
					item.setItemType(type);
					item.setItemSpicyLevel(spicy);
					item.setPriceFull(prFull);
					item.setPriceHalf(prHalf);
					item.setItemAvailability(avail);
					item.setItemDesc(desc);
					System.out.println("ok");
				boolean flag=itemServices.addItem(item);
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
	        response.sendRedirect("http://85.25.196.222:8083/SmartDine/Item.jsp");
	    }
	
	
	//Validate Item
	
	
			@RequestMapping(value = "/validateItem", method = RequestMethod.GET)
			public @ResponseBody CategoryJsonResponse validateItem( @RequestParam(value = "itemName") String itemName) {
		    	CategoryJsonResponse catJsonResponse=new CategoryJsonResponse();
			    try {
			        Item item = itemServices.validateItem(itemName);
			        if(item!=null){
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
	
	
	//ItemList by Item Type in Descending order
	
	@RequestMapping(value = "/itemList", method = RequestMethod.GET)
	public @ResponseBody List<Item> getItemList(){
		List<Item> itemList = new ArrayList<Item>();
		try {
			System.out.println("HELLO");
			itemList = itemServices.getItemList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemList;
	}
	
	//ItemList by category and sub-category in ascending order
	
	@RequestMapping(value = "/itemListById", method = RequestMethod.GET)
	public @ResponseBody List<ItemBean> getItemListByCategoryId(@RequestParam(value = "categoryId") int categoryId,@RequestParam(value = "subCategoryId") int subCategoryId){
		List<ItemBean> itemListByCategoryId = new ArrayList<ItemBean>();
		try {
			System.out.println("HELLO");
			System.out.println(categoryId);
			System.out.println(subCategoryId);
			itemListByCategoryId = itemServices.getItemListByCategoryId(categoryId,subCategoryId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemListByCategoryId;
	}
	
	
	// Delete Item
	
	@RequestMapping(value="/deleteItem", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ItemJsonResponse deleteItem(@Valid @RequestBody Item item){
		ItemJsonResponse itemJsonResponse = new ItemJsonResponse();
		List<Item> itemById = new ArrayList<Item>();
		int itemId=item.getItemId();
		System.out.println(item.getItemId());
		String name=null;
		try{
			itemById = itemServices.getItemById(itemId);
			System.out.println(itemById);
			for(int i=0;i<itemById.size();i++){
				 name=itemById.get(i).getItemImage();
				 }
			System.out.println(name);
			flag = itemServices.deleteItem(item);
			if(flag){
				itemJsonResponse.setStatus("SUCCSS");
			}else {
				itemJsonResponse.setStatus("FAILED");
			}
		}catch (Exception e){
			itemJsonResponse.setStatus(e.toString());
			e.printStackTrace();
			logger.error(e);
			System.out.println(e);
		}
		return itemJsonResponse;
		
	}
	
	
	//Item By itemId
	
	@RequestMapping(value = "/itemById", method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Item> itemById( @RequestParam(value = "itemId") int itemId) {
    	List<Item> itemById = new ArrayList<Item>();
	    try {
	    	itemById = itemServices.getItemById(itemId);	        
	    	return itemById;
	       } catch (Exception e) {
	    	logger.error("Exception occurs in", e);
	    }
	   	return itemById;
	}
	
	
	//Update Category
	
	@RequestMapping(value="/updateItem", method = RequestMethod.POST)
	public void updateSubCategory(HttpServletRequest requst,HttpServletResponse response, @RequestParam(value="itemImage",required=false)MultipartFile image)throws ServletException, IOException{
		Item item=null;
		String imgFile=null;
		String fileName=requst.getParameter("itemName");
		System.out.println(fileName);
		int catid=Integer.parseInt(requst.getParameter("SelectCat"));
		int subcatid=Integer.parseInt(requst.getParameter("SelectSubCat"));
		Category category=new Category();
		category.setCategoryId(catid);
		SubCategory subCategory=new SubCategory();
		subCategory.setSubCategoryId(subcatid);
		String hfname=requst.getParameter("hfCatId2");
		String name=requst.getParameter("hfCatId3");
		System.out.println("Hidden field is: "+hfname);
		System.out.println("image field name is: "+name);
		int id=Integer.parseInt(requst.getParameter("hfCatId"));
		String type=requst.getParameter("DDTyp");
		String spicy=requst.getParameter("DDSplvl");
		Double prFull=Double.parseDouble(requst.getParameter("TxtPriceFull"));
		Double prHalf=Double.parseDouble(requst.getParameter("TxtPriceHalf"));
		String avail=requst.getParameter("ItemAvail");
		String desc=requst.getParameter("TxtDesc");
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
			item=new Item();
			item.setItemId(id);
			item.setCategory(category);
			item.setSubCategory(subCategory);
			item.setItemName(fileName);
			item.setItemImage(fullPath);
			item.setItemType(type);
			item.setItemSpicyLevel(spicy);
			item.setPriceFull(prFull);
			item.setPriceHalf(prHalf);
			item.setItemAvailability(avail);
			item.setItemDesc(desc);
			boolean flag=itemServices.updateItem(item);
			if(flag){
				FileOperations.deleteFile(name);
				status="SUCCESS";
			}else{
				status="UNSUCCESS";
			}
			}
			
		}catch(Exception e){
			logger.error("Error occours in : ",e);
			e.printStackTrace();
		}
		}
		else if (hfname.equals(name)) {
			System.out.println("only update ");
			try {
				item=new Item();
				item.setItemId(id);
				item.setCategory(category);
				item.setSubCategory(subCategory);
				item.setItemName(fileName);
				item.setItemImage(hfname);
				item.setItemType(type);
				item.setItemSpicyLevel(spicy);
				item.setPriceFull(prFull);
				item.setPriceHalf(prHalf);
				item.setItemAvailability(avail);
				item.setItemDesc(desc);
				boolean flag=itemServices.updateItem(item);
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
		response.sendRedirect("http://85.25.196.222:8083/SmartDine/Item.jsp");
	}

}
