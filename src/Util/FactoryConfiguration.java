package Util;


import Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
        private static FactoryConfiguration factoryConfiguration;
        private SessionFactory sessionFactory;

        private FactoryConfiguration() {
            // configure() -> load and config Hibernate.cfg.xml file to SessionFactory
            // addAnnotatedClass() -> define which Entity that gonna use to Persist
            Configuration configuration = new Configuration().configure()
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(Product.class)
                    .addAnnotatedClass(Order.class)
                    .addAnnotatedClass(Supplier.class)
                    .addAnnotatedClass(OrderDetail.class);

            // build a SessionFactory and assign it to sessionFactory reference
            sessionFactory = configuration.buildSessionFactory();
        }
        public static FactoryConfiguration getInstance() {
            return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration()
                    : factoryConfiguration;
        }
        // return a new Session through sessionFactory
        public Session getSession() {
            return sessionFactory.openSession();
        }
    }

