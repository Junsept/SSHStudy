package com.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.domain.Category;
import com.domain.Hero;

public class TestHibernate {
	public static void main(String[] args) {
        //读取hibernate.cfg.xml文件  
        Configuration cfg = new Configuration().configure(); 
        //建立SessionFactory  
        SessionFactory factory =cfg.buildSessionFactory();
        //取得session  
        Session session = null;
        try{  
            //开启session  
            session = factory.openSession();  
            //开启事务  
            session.beginTransaction();  
            //插入
            
/*            Category category = new Category();
            category.setName("AP");
            session.save(category);
            
            Hero hero = new Hero();  
            hero.setName("test");
            hero.setHp(100);
            hero.setDamage(100);
            hero.setImgsrc("image");
            hero.setCategory(category);
            session.save(hero);  */
            
            //获取
            //Hero hero1 = (Hero) session.get(Hero.class, 28);
            Hero hero1 = (Hero) session.load(Hero.class, 28);//属性延迟加载
            System.out.println("log1");
            System.out.println("id=28的英雄是: " + hero1.getName());
            
            //修改
            hero1.setName("TEST");
            session.update(hero1);
            
            //删除
            //session.delete(hero1);
            
            //HQL
            String name = "";
            Query q = session.createQuery("from Hero p where p.name like ?");
            q.setString(0, "%"+name+"%");
            @SuppressWarnings("unchecked")
			List<Hero> hr = q.list();
            for (Hero p : hr) {
                System.out.println(p.getName());
            }
            
            //criteria
            Criteria cr = session.createCriteria(Hero.class);
            cr.add(Restrictions.like("name", "%"+name+"%"));
            cr.setFirstResult(3);
            cr.setMaxResults(5);
			@SuppressWarnings("unchecked")
			List<Hero> hr1 = cr.list();
            for (Hero p : hr1) {
                System.out.println(p.getName());
            }
            
			//一级缓存session
			System.out.println("log1");
			Category c1 = (Category)session.get(Category.class, 1);
			System.out.println("log2");
			Category c2 = (Category)session.get(Category.class, 1);//不会显示SQL语句
			//提交事务  
			session.getTransaction().commit();              
			//二级缓存SessionFactory
			Session session2 = factory.openSession();
			session2.beginTransaction();
			System.out.println("log3");
			Category p3 = (Category) session2.get(Category.class, 1);//会显示    
			session2.getTransaction().commit();

              
        }catch(Exception e){  
            e.printStackTrace();  
            //回滚事务  
            session.getTransaction().rollback();  
        }finally{  
            if(session != null){  
                if(session.isOpen()){  
                    //关闭session  
                    session.close();  
                }  
            }  
        } 
    }
}
