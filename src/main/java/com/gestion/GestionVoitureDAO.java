package com.gestion;

import com.crud.DAO;
import com.bean.Voiture;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.Query;


public class GestionVoitureDAO implements DAO<Voiture> {
	
	
	public void insert(Voiture v) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(v);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		session.close();		
	}
	
	public void update(Voiture v) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Voiture vr = (Voiture) session.load(Voiture.class, v.getId());
			vr.setNom(v.getNom());
			vr.setMatricule(v.getMatricule());
			session.update(vr);
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
			Voiture v = session.load(Voiture.class, id);
			session.delete(v);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		session.close();	
	}
	
	public List<Voiture> all(){		
		List<Voiture> voitureList = new ArrayList();
		Session session = HibernateUtil.getSessionFactory().openSession();		
		String qr = "select v from Voiture v"; //Entity name
		Query query = session.createQuery(qr);
		voitureList = query.list();
		return voitureList;
	}
}
