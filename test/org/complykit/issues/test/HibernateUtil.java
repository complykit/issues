/*
 * Created 21-mar-2011 by Michael Rice
 *
 * *** Generated by IDE
 *
 */

package org.complykit.issues.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author mrice
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {

            Configuration config=new Configuration();

            config.setProperty("hibernate.hbm2ddl.auto", "create");
            config.setProperty("hibernate.show_sql", "true");

            config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

            config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");

            config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/issues");
            config.setProperty("hibernate.connection.username", "root");
            config.setProperty("hibernate.connection.password", "abc123");
            config.setProperty("hibernate.connection.pool_size", "5");

            config.addAnnotatedClass(org.complykit.issues.model.RISCIssue.class);
            config.addAnnotatedClass(org.complykit.issues.model.RISCIssueStep.class);
            config.addAnnotatedClass(org.complykit.issues.model.Ticket.class);
            
            sessionFactory=config.buildSessionFactory();

        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
