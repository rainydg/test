package com.cui.hao.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.cui.hao.dao.ContentMapper;
import com.cui.hao.meta.Content;
import com.cui.hao.meta.Product;
import com.cui.hao.meta.Trx;
import com.cui.hao.service.ContentService;

@Component("contentService")

public class ContentServiceimpl implements ContentService {
	
	@Autowired
	private ContentMapper contentMapper;

	
	public void addContent(double price, String title, String image, String summary,String detail) {
		contentMapper.addContent(price, title, image, summary, detail);
	}
	
	
	public void updateContent(int id,double price, String title, String image, String summary, String detail) {
		contentMapper.updateContent(id, price, title, image, summary, detail);
		
	}

	
	public void buypro(Trx trx) {
		contentMapper.addTrx(trx);
		
	}
	
	
	public List<Product> getProductList() {
		return contentMapper.content();
	}
	
	
	public List<Trx> geitTrx() {
		
		return contentMapper.getTrxBy();
	}
	
	
	
	//通过id查找商品 ，并且展示
		public Product putProuct(int id) {
		 Product pt = contentMapper.getContentid(id);
		
		
		return pt;	
		}

	
		public void delProduct(int id) {
			contentMapper.deleteProduct(id);
		}
		
		public Trx getTrxPid(int productId) {
			return contentMapper.getTrxPid(productId);
			
		}
		
		public void findTrx(int id) {
			contentMapper.getTrxid(id);
			
		}
		
	
//	@Override
//	public List<Product> getProductListByid(Integer userId) {
//		List<Product> pt = new ArrayList<Product>();
//		Trx trx = new Trx();
//		trx.setPersonId(userId);
//		List<Trx> tr = contentMapper.getTrxByid(trx);
//		for( Product pts : contentMapper.content()){
//			if(userId !=null){
//				for(Trx trxe :tr){
//					if(trxe.getPersonId()==pts.getId()){
//						pts.setBuy(true);
//					}
//					
//				}
//				
//			}
//		}
//		
//			return pt;	
//	}
	
//	@Override
//	public List<Product> getContent(Integer userId) {
//		List<Product> products = new ArrayList<Product>();
//		Person person = new Person();
//		person.setId(userId);
//		List<Trx> trxl = contentMapper.getTrxUser(person);
//		List<Content> productst = contentMapper.content();
//		for(Content pt : productst){
//			Product ct = new Product();
//			ct.setId(pt.getId());
//			   ct.setTitle(pt.getTitle());
//			   ct.setImage(pt.getImage());
//			   ct.setPrice(pt.getPrice());
//			   ct.setBuy(pt.isBuy());
//			   ct.setSell(pt.isSell());
//			if(userId != null){
//				for(Trx trxx:trxl){
//					if(trxx.getProductId()==ct.getId()){
//						ct.setBuy(true);
//					}
//				}
//			}
//		}
//		return products;
//	}
	

	

}
