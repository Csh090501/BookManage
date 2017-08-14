package org.model;
import java.util.Date;

public class Lend {
	private String readerId;
	private String bookName;
	private String publisher;
	private float price;
	private String ISBN;
	private String lTime;
	//生成上述属性的get和set方法
	
	
	public String getReaderId(){
		return this.readerId;
	}
	public String getlTime() {
		return lTime;
	}
	public void setlTime(String lTime) {
		this.lTime = lTime;
	}
	public void setReaderId(String readerId){
		this.readerId = readerId;
	}
	
	public String getBookName(){
		return this.bookName;
	}
	public void setBookName(String bookName){
		this.bookName = bookName;
	}
	
	public String getPublisher(){
		return this.publisher;
	}
	public void setPublisher(String publisher){
		this.publisher = publisher;
	}
	
	public float getPrice(){
		return this.price;
	}
	public void setPrice(float price){
		this.price = price;
	}
	
	public String getISBN(){
		return this.ISBN;
	}
	public void setISBN(String ISBN){
		this.ISBN = ISBN;
	}

}
