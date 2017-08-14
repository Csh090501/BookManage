package org.model;

import java.sql.Date;

public class Student {
	private String readerId;
	private String name;
	private String spec;
	private boolean sex;
	private String born;
	private int num;
	private int snum;
	private byte[] photo;
	//省略上面属性的get和set方法
	public String getReaderId(){
		return this.readerId;
	}
	public void setReaderId(String readerId){
		this.readerId = readerId;
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public String getSpec(){
		return this.spec;
	}
	public void setSpec(String spec){
		this.spec = spec;
	}
	
	public boolean getSex(){
		return this.sex;
	}
	public void setSex(boolean sex){
		this.sex = sex;
	}
	
	public String getBorn(){
		return this.born;
	}
	public void setBorn(String born){
		this.born = born;
	}
	
	public int getNum(){
		return this.num;
	}
	public void setNum(int num){
		this.num = num;
	}
	
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public byte[] getPhoto(){
		return this.photo;
	}
	public void setPhoto(byte[] photo){
		this.photo = photo;
	}
}
