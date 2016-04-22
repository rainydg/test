package com.cui.hao.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.cui.hao.meta.User;
import com.cui.hao.meta.Content;
import com.cui.hao.meta.Plist;
import com.cui.hao.meta.Product;
import com.cui.hao.meta.Trx;
import com.cui.hao.service.ContentService;
import com.cui.hao.service.LoginService;


@Controller
public class ShopController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private ContentService contentService;
	
	//系统入口文档
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(HttpServletRequest req,ModelMap map){
		
		User user = (User) req.getSession().getAttribute("user");
		ArrayList<Product> psd = new ArrayList<Product>();
		List<Product> pl = contentService.getProductList();
		if(user !=null){
			 List<Trx> tr = contentService.geitTrx();
			 for(Product product : pl){
				 for(Trx trx :tr){
//					 if(trx.getPersonId()==user.getId()){
//						 product.setisSell(true);
//					      }
					  if(trx.getProductId()==product.getId()){
						  product.setisBuy(true);
						  product.setisSell(true);
					        }
					 
					  } 
				 psd.add(product);
				 map.addAttribute("productList",  psd);
				 
		         } 
			 
		}else{
			
			map.addAttribute("productList",  pl);
		}
		
		return "index";	
		}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		
		return "login";
		}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout( HttpServletRequest req)throws IOException{
			req.getSession().removeAttribute("user");
		
			return "redirect:/login";
	}
		
	
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public String show( @RequestParam("id") int id,HttpServletRequest req,ModelMap map) throws UnsupportedEncodingException {
		
		 User user = (User) req.getSession().getAttribute("user");
//		 ArrayList<Product> psd = new ArrayList<Product>();
		 Product pt =  contentService.putProuct(id);
		 if(user !=null){
		  List<Trx> tr = contentService.geitTrx();
		    for(Trx trx :tr){
				if(trx.getProductId()==pt.getId()){
					pt.setisBuy(true);
					pt.setBuyprice(trx.getPrice());
				           }  
				map.addAttribute("product",  pt);
		    }
		 }else{
	
			 map.addAttribute("product",  pt);
		 }
		 
		return "show";
	}
	
	
	
	
	@RequestMapping(value="/public",method=RequestMethod.GET)
	public String publics(){
		
		return "public";
		}
	
	@RequestMapping(value="/publicSubmit",method=RequestMethod.POST)
	public String publicSubmit(@RequestParam("price") double price,@RequestParam("title") String title,@RequestParam("image") String image,
			@RequestParam("summary") String summary,@RequestParam("detail") String detail, HttpServletRequest req, ModelMap map){
		
		req.getSession().getAttribute("user");
		contentService.addContent(price, title, image, summary, detail);
		Product product = new Product();
		product.setPrice(price);
		product.setTitle(title);
		product.setImage(image);
		product.setSummary(summary);
		product.setDetail(detail);
		map.addAttribute("product", product);
		
		return "publicSubmit";
		}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(@RequestParam("id") int id,HttpServletRequest req,ModelMap map){
		req.getSession().getAttribute("user");
		Product product =  contentService.putProuct(id);
		
		 map.addAttribute("product",product);
		
		return "edit";
		}
	
	@RequestMapping(value="/editSubmit",method=RequestMethod.POST)
	public String editSubmit(@RequestParam("id") int id,  @RequestParam("price") double price,@RequestParam("title") String title,@RequestParam("image") String image,
			@RequestParam("summary") String summary,@RequestParam("detail") String detail,HttpServletRequest req, ModelMap map) throws UnsupportedEncodingException{
		
		contentService.updateContent(id,price, title, image, summary, detail);
		Product product = new Product();
		product.setId(id);
		product.setPrice(price);
		product.setTitle(title);
		product.setImage(image);
		product.setSummary(summary);
		product.setDetail(detail);
		map.addAttribute("product", product);
		
		return "editSubmit";
		}
	
	@RequestMapping(value="/account",method=RequestMethod.GET)
	public String account(HttpServletRequest req, ModelMap map){
		req.getSession().getAttribute("user");
		ArrayList<Product> psp = new ArrayList<Product>();
		List<Product> ps = contentService.getProductList();
		for(Product ct : ps){
			List<Trx> tr = contentService.geitTrx();
			for( Trx trx : tr){
				if(trx.getProductId()==ct.getId()){
				ct.setBuyprice(trx.getPrice());
				ct.setBuyTime(trx.getBuyTime());
				psp.add(ct);
				
				map.addAttribute("buyList",psp);
			    }
			}
			
		}	
		return "account";
		}
	//异步数据借口文档
	@RequestMapping(value="/api/login", method=RequestMethod.POST)
	public ModelMap userLogin(@RequestParam("userName") String username, @RequestParam("password") String password,
			  ModelMap map,HttpServletRequest req)throws IOException{
		User user = loginService.getUserName(username);
		if( user.getUserName().equals(username) && user.getPassword().equals(password)){
			req.getSession().setAttribute("user", user);
			map.put("code", 200);
			map.put("message", "success");
			map.put("result", true);
			
		}else{
			map.put("code", 404);
			map.put("message", "登陆失败");
			map.put("result", false);
			
		}

		return map;
		
}
	
	@RequestMapping(value="/api/delete",method=RequestMethod.POST)
	public ModelMap delete( @RequestParam("id") int id, HttpServletRequest req,ModelMap map){
		User user = (User) req.getSession().getAttribute("user");
		if(user!=null && user.getUsertype()==1){
			contentService.delProduct(id);
			map.put("code", 200);
			map.put("message", "删除成功");
			map.put("result", true);
		}else{
			map.put("code", 404);
			map.put("message", "删除失败");
			map.put("result", false);
		}
		return map;
	}
	
	@RequestMapping(value="/api/buy",method=RequestMethod.POST)
	public ModelMap buy( @RequestParam("id") int id, HttpServletRequest req,ModelMap map){
		User user = (User) req.getSession().getAttribute("user");
		if(user!=null && user.getUsertype()==0){
			Product product =  contentService.putProuct(id);
			Trx trx = new Trx();
			trx.setProductId(product.getId());
			trx.setPersonId(user.getId());
			trx.setPrice(product.getPrice());
			trx.setTime(new Date().getTime());
			contentService.buypro(trx);
			map.put("code", 200);
			map.put("message", "购买成功");
			map.put("result", true);
		}else{
			map.put("code", 404);
			map.put("message", "购买失败");
			map.put("result", false);
		}
		return map;
	}
}
