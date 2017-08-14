package org.model;

public class Book {
	private String ISBN;
	private String bookName;
	private String author;
	private String publisher;
	private float price;
	private int cnum;
	private int snum;
	private String summary;
	private byte[] photo;
	//省略上面属性的get和set方法
	public String getISBN(){
		return this.ISBN;
	}
	public void setISBN(String ISBN){
		this.ISBN = ISBN;
	}
	
	public String getBookName(){
		return this.bookName;
	}
	public void setBookName(String bookName){
		this.bookName = bookName;
	}
	
	public String getAuthor(){
		return this.author;
	}
	public void setAuthor(String author){
		this.author = author;
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
	
	public int getCnum(){
		return this.cnum;
	}
	public void setCnum(int cnum){
		this.cnum = cnum;
	}
	
	public int getSnum(){
		return this.snum;
	}
	public void setSnum(int snum){
		this.snum = snum;
	}
	
	public String getSummary(){
		return this.summary;
	}
	public void setSummary(String summary){
		this.summary = summary;
	}
	
	public byte[] getPhoto(){
		return this.photo;
	}
	public void setPhoto(byte[] photo){
		this.photo = photo;
	}
}
