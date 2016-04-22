package com.cui.hao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.cui.hao.meta.Trx;
import com.cui.hao.meta.User;
import com.cui.hao.meta.Content;
import com.cui.hao.meta.Product;



public interface ContentMapper {
	
	@Results({
		@Result (property = "id", column = "id"),
		@Result (property = "price", column = "price"),
		@Result (property = "title", column = "title"),
		@Result (property = "image", column = "icon"),
		@Result (property = "summary", column = "abstract"),
		@Result (property = "detail", column = "text"),
	})
	@Select("Select * from content")
	public List<Product> content();
	
	@Results({
		@Result (property = "id", column = "id"),
		@Result (property = "price", column = "price"),
		@Result (property = "title", column = "title"),
		@Result (property = "image", column = "icon"),
		@Result (property = "summary", column = "abstract"),
		@Result (property = "detail", column = "text"),
	})
	@Select("Select * from content")
	public List<Content> contentw();
	
	@Results({
		@Result (property = "id", column = "id"),
		@Result (property = "price", column = "price"),
		@Result (property = "title", column = "title"),
		@Result (property = "image", column = "icon"),
		@Result (property = "summary", column = "abstract"),
		@Result (property = "detail", column = "text"),
	})
	@Select("Select * from content where id=#{id}")
	public Product getContentid(int id);
	
	
	@Results({
		@Result (property = "id", column = "id"),
		@Result (property = "price", column = "price"),
		@Result (property = "title", column = "title"),
		@Result (property = "image", column = "icon"),
		@Result (property = "summary", column = "abstract"),
		@Result (property = "detail", column = "text"),
	})
	@Insert("insert into content (price, title, icon, abstract, text) values(#{price}, #{title}, #{icon}, #{abstract}, #{text})")
	public void addContent(@Param("price") double price,@Param("title") String title,@Param("icon") String image,
			@Param("abstract") String summary,@Param("text") String detail);
	
	@Results({
		@Result (property = "id", column = "id"),
		@Result (property = "price", column = "price"),
		@Result (property = "title", column = "title"),
		@Result (property = "image", column = "icon"),
		@Result (property = "summary", column = "abstract"),
		@Result (property = "detail", column = "text"),
	})
	@Update("update content set price=#{price}, title=#{title}, icon=#{icon}, abstract=#{abstract}, text=#{text} where id=#{id}")
	public void updateContent(@Param("id") int id,@Param("price") double price,@Param("title") String title,@Param("icon") String image,
			@Param("abstract") String summary,@Param("text") String detail);
	
	@Results({
		@Result (property = "id", column = "id"),
		@Result (property = "productId", column = "contentId"),
		@Result (property = "personId", column = "personId"),
		@Result (property = "buyprice", column = "price"),
		@Result (property = "time", column = "time"),
	})
	@Delete("Delete from content where id=#{id}")
	public void deleteProduct(@Param("id") int id);
	
	//Trx
	

	@Results({
		@Result (property = "id", column = "id"),
		@Result (property = "contentId", column = "contentId"),
		@Result (property = "personId", column = "personId"),
		@Result (property = "price", column = "price"),
		@Result (property = "time", column = "time"),

	})
	@Select("Select * from trx where contentId=#{contentId}")
	public Trx getTrxPid(@Param("contentId") int productId);
	
	@Select("Select * from trx where id=#{id}")
	public Product getTrxid(int id);
	
	
	@Results({
		@Result (property = "id", column = "id"),
		@Result (property = "contentId", column = "contentId"),
		@Result (property = "personId", column = "personId"),
		@Result (property = "price", column = "price"),
		@Result (property = "time", column = "time"),

	})
	@Insert("Insert into trx (contentId, personId, price, time) values(#{contentId}, #{personId}, #{price}, #{time})")
	public void addTrx(Trx trx);
	
	
	@Select("Select * from trx")
	public List<Trx> getTrxBy();
	
	@Select("Select * from trx where personId=#{personId}")
	public List<Trx> getTrxByid(Trx trx);

	@Select("Select * from trx where contentId=#{contentId}")
	public List<Trx> getTrxUser(User user);

}
