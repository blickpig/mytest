package com.xin.untils;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateUtils {

     static Configuration cfg;
     static SessionFactory sessionFactory;

    static {
        //加载核心配置文件
         cfg = new Configuration();
        Configuration configure = cfg.configure();
        sessionFactory = configure.buildSessionFactory();
    }
/*    //提供返回与本地线程的session方法
    public static Session getSessionObject(){
        return sessionFactory.getCurrentSession();
    }*/
    //提供方法返回SessionFactory
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void main(String[] args) {

    }
}
