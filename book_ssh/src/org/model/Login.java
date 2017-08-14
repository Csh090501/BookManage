package org.model;
public class Login {
	//属性
	private Integer id;			//用户ID
	private String name;		//用户名
	private String password;	//密码
	private int role;		//角色
	
	//属性 id 的 get/set 方法
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	
	//属性 name 的 get/set 方法
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}

	//属性 password 的 get/set 方法
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	
	//属性 role 的 get/set 方法
	public int getRole(){
		return this.role;
	}
	public void setRole(int role){
		this.role = role;
	}
}
