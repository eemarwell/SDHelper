package com.marwell.sdhelper.ConnectionFactory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Eduardo Marwell
 */
public class HibernateUtil {
    
    public SessionFactory getConnection(){
        Configuration config = new Configuration().configure();
        config.addAnnotatedClass(com.marwell.sdhelper.model.Agente.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        return config.buildSessionFactory(builder.build());
    }
    
}
