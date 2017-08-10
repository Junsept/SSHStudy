package com.controller;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TestStruts extends ActionSupport{
	private String name;
	private File img;
    private String imgFileName;
    private String imgContentType;
    private Date date;
    public String getName(){
    	return name;
    }
    public void setName(String name){
    	this.name = name;
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
    public Date getDate(){
    	return date;
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
    public void setDate(Date date){
    	this.date = date;
    }
	public String logintest() throws IOException{   
		setName("zmj");
        File f = new File("D://imagebystruts");
        if (!f.exists()) {  
            f.mkdir();  
        }         
        FileUtils.copyFile(img, new File(f, imgFileName));

    	return "success";
  
  
    }
}
