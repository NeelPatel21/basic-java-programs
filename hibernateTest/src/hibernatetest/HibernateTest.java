/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Neel Patel
 */
public class HibernateTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        User u=new User(109,"htrc");
        User u1=new User(10,"fbhtrc");
        User u2=new User(95,"kyuhtrc");
        System.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/hibernate");
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        s.save(u);
        s.save(u1);
        s.save(u2);
        //u=s.get(User.class,9);
        System.out.println("conn : "+System.getProperty("hibernate.connection.url"));
        s.getTransaction().commit();
        s.close();
        sf.close();
    }
    
}
