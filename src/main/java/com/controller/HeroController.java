package com.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.domain.Category;
import com.domain.Hero;
import com.opensymphony.xwork2.ActionSupport;

public class HeroController extends ActionSupport{
	private Hero hero;
	private File img;
	private String imgFileName;
	private String imgContentType;
	public Hero getHero(){
		return hero;
	}
	public void setHero(Hero hero){
		this.hero = hero;
	}
	public File getImg(){
		return img;
	}
    public String getImgFileName(){
    	return imgFileName;
    }
    public String getImgContentType(){
    	return imgContentType;
    }
	public void setImg(File img){
		this.img = img;
	}
    public void setImgFileName(String imgFileName){
    	this.imgFileName = imgFileName;
    }
    public void setImgFileContentType(String imgContentType){
    	this.imgContentType = imgContentType;
    }
	public String submithero() throws IOException{
        //读取hibernate.cfg.xml文件  
        Configuration cfg = new Configuration().configure(); 
        //建立SessionFactory  
        SessionFactory factory =cfg.buildSessionFactory();
        //取得session   
        Session session = null;
        //开启session  
        session = factory.openSession();  
        //开启事务  
        session.beginTransaction(); 
        
		System.out.println(hero.getName());
		System.out.println(hero.getDamage());
		System.out.println(hero.getHp());
		System.out.println(imgFileName);
		
        hero.setImgsrc(imgFileName);
        
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml" );
 
        Category c = (Category) context.getBean("c");
        System.out.println(c.getName());
        session.save(hero);
        session.getTransaction().commit();
        
		File f = new File("D://imagebystruts");
        if (!f.exists()) {  
            f.mkdir();  
        }   
        
        FileUtils.copyFile(img, new File(f, imgFileName));
        return "success";
	}
}
