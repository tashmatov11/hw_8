package peaksoft.Util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;

import java.util.Properties;
/**
 * Project: hw_8
 * Author: Tashmatov Bektur
 * Date: 25.01.2022 (19:43)
 */
public class Util {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        Properties prop = new Properties();

        prop.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/Peaksoft");
        prop.setProperty("hibernate.connection.username", "postgres");
        prop.setProperty("hibernate.connection.password", "qwe123");
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        prop.setProperty("hibernate.show_sql", "true");
        prop.setProperty("hibernate.hbm2ddl.auto", "update");
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(peaksoft.Entity.User.class);
        cfg.setProperties(prop);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        System.out.println("Connected to hibernate");
        return cfg.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        return buildSessionFactory();
    }
    public static void shutDown() {
        getSessionFactory().close();
    }
}
