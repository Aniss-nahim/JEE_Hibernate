package dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.entities.Chauffeur;
import dao.interfaces.IChauffeurDao;

public class ChauffeurDaoImp implements IChauffeurDao{
	
	// Entity manager
	private EntityManager entityManager;
	
	public  ChauffeurDaoImp() {
		//Entity manager Factory
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UP_FASTANDFURIOUS");
		
		//Creation de l'objet entity manager
		entityManager = entityManagerFactory.createEntityManager();
	}


	public void insert(Chauffeur t) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(t);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		
	}

	public void update(Chauffeur t) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.merge(t);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	public void delete(Long id) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			Chauffeur p = entityManager.find(Chauffeur.class, id);
			entityManager.remove(p);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		
	}

	public List<Chauffeur> all() {
		Query query = entityManager.createQuery("select c from Chauffeur c");
		return query.getResultList();
	}

}
