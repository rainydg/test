package com.cui.hao.service;

import java.util.List;

import com.cui.hao.meta.Product;
import com.cui.hao.meta.Trx;


public interface ContentService {
	
	public void addContent(double price, String title, String image, String summary, String detail);
	
	public void updateContent(int id, double price, String title, String image, String summary, String detail);

	public List<Product> getProductList();
	
//	public List<Product> getProductListByid(Integer userId);
	
	public List<Trx> geitTrx();
	
	public void buypro(Trx trx);
	
	
    public void delProduct(int id);
    
    public void findTrx(int id);
    
    public Trx getTrxPid(int productId);
	
	public Product putProuct(int id);
	
	
	


}
