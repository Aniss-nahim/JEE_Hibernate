package com.bean;

import org.glassfish.webservices.node.ServiceReferenceNode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.jboss.weld.bootstrap.api.helpers.ServiceRegistries;

import com.sun.xml.rpc.naming.ServiceReferenceResolver;

public class ManyToManyTest {
	
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		
		configuration.addAnnotatedClass(Voiture.class);
		configuration.addAnnotatedClass(Marque.class);
		configuration.addAnnotatedClass(Chauffeur.class);
		
		ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		
		SessionFactory sessionFact = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFact.openSession();
		
		// adding marque
		Marque m = new Marque();
		m.setNom("BMW");
		session.save(m);
		
		Transaction transaction = session.beginTransaction();
		try {
			
			Voiture v = new Voiture();
			Chauffeur chf = new Chauffeur();
			
			// adding voiture
			v.setNom("M3");
			v.setMatricule("B13-4554-465");
			v.setMarque(m);
			session.save(v);
			
			// adding chauffeur
			chf.setNom("Aniss");
			chf.setTelephone("08545785");
			session.save(chf);
			
			//insert in ManyToMany table voiture - chauffeur
			v = session.load(Voiture.class, v.getId());
			chf = session.load(Chauffeur.class, chf.getId());
			
			v.getChauffeurs().add(chf);
			chf.getVoitures().add(v);
			
			session.update(chf);
			
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
		}
		
		session.close();
		
		
		
	}

}
