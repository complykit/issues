/*
 * complykit.org
 * Created: 21-mar-2010
 */

package org.complykit.issues.test;

import org.hibernate.cfg.Configuration;

/**
 *
 * @author mrice
 */
public class HibernateTestConfiguration {
    private final static Configuration config;
    static {
        config=new Configuration();
        
        config.setProperty("hibernate.hbm2ddl.auto", "create");
        config.setProperty("hibernate.show_sql", "true");

        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        //config.setProperty("hibernate.connection.driver_class", "org.apache.derby.jdbc.EmbeddedDriver");
        //config.setProperty("hibernate.connection.url", "jdbc:derby:/databases/issues/;create=true");
        
        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/issues");
        config.setProperty("hibernate.connection.username", "root");
        config.setProperty("hibernate.connection.password", "abc123");
        config.setProperty("hibernate.connection.pool_size", "5");

        config.addAnnotatedClass(org.complykit.issues.model.RISCIssue.class);

    }
    public static Configuration getConfig() {
        return config;
    }
}
