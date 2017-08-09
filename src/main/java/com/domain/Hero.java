package com.domain;

public class Hero{
	private int id;
	private String name;
	private int hp;
	private int damage;
	private String imgsrc;
	private Category category;
	
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public int getHp(){
		return hp;
	}
	public int getDamage(){
		return damage;
	}
	public String getImgsrc(){
		return imgsrc;
	}
	public Category getCategory(){
		return category;
	}
	public void setId(int id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setHp(int hp){
		this.hp = hp;
	}
	public void setDamage(int damage){
		this.damage = damage;
	}
	public void setImgsrc(String imgsrc){
		this.imgsrc = imgsrc;
	}
	public void setCategory(Category category){
		this.category = category;
	}
}
