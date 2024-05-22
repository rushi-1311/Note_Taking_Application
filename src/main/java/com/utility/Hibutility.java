package com.utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Hibutility {

	 public static SessionFactory factory = null;
	 public static SessionFactory getSessionFactory()
	 {
		 
		 Configuration config =  
				  new Configuration().configure("hibernate.cfg.xml");
		 
		 ServiceRegistry registry  = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		 factory = config.buildSessionFactory(registry);
		 
		 return factory;
	 }
}
