package com.gestion;

import java.util.List;

import com.bean.Chauffeur;
import com.crud.DAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

public class GestionChauffeurDAO implements DAO<Chauffeur>{

	public void insert(Chauffeur c) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(c);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		
	}

	public void update(Chauffeur c) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Chauffeur chf = (Chauffeur) session.load(Chauffeur.class, c.getId());
			chf.setNom(c.getNom());
			chf.setTelephone(c.getTelephone());
			session.update(chf);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		session.close();	
	}

	public void delete(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Chauffeur chf = session.load(Chauffeur.class, id);
			session.delete(chf);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		session.close();	
	}

	public List<Chauffeur> all() {
		Session session = HibernateUtil.getSessionFactory().openSession();		
		String qr = "select v from Chauffeur v"; //Entity name
		Query query = session.createQuery(qr);
		return query.list();
	}
	
}
