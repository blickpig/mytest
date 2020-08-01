package com.xin;

import com.xin.pojo.Role;
import com.xin.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import com.xin.untils.*;

public class testDemo {
    @Test
    public void save(){
        Session session = null;
        Transaction transaction = null;
        SessionFactory sessionFactory = null;
        try {
            //与本地线程绑定的session
            /*session = hibernateUtils.getSessionObject();*/
            sessionFactory = hibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            User user1 = new User();
            user1.setUser_name("lucy");
            user1.setUser_password("174753");
            User user2 = new User();
            user2.setUser_name("mary");
            user2.setUser_password("030228");

            Role role1 = new Role();
            role1.setRole_name("总经理");
            role1.setRole_memo("总经理");
            Role role2 = new Role();
            role2.setRole_name("秘书");
            role2.setRole_memo("秘书");
            Role role3 = new Role();
            role3.setRole_name("司机");
            role3.setRole_memo("司机");
            //建立关系，把角色放入用户
            user1.getSetRole().add(role1);
            user1.getSetRole().add(role2);
            user2.getSetRole().add(role2);
            user2.getSetRole().add(role3);

            session.save(user1);
            session.save(user2);

            transaction.commit();
        }catch (Exception e ){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
            sessionFactory.close();

        }
    }

    @Test
    public void delete(){
        Session session = null;
        Transaction transaction = null;
        SessionFactory sessionFactory = null;
        try {
            //与本地线程绑定的session
            /*session = hibernateUtils.getSessionObject();*/
            sessionFactory = hibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            User user = session.get(User.class, 1);
            session.delete(user);

            transaction.commit();
        }catch (Exception e ){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
            sessionFactory.close();

        }
    }

    @Test
    public void testTable(){
        Session session = null;
        Transaction transaction = null;
        SessionFactory sessionFactory = null;
        try {
            //与本地线程绑定的session
            /*session = hibernateUtils.getSessionObject();*/
            sessionFactory = hibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();



            transaction.commit();
        }catch (Exception e ){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
            sessionFactory.close();

        }
    }
}
