package dao.imp;

import java.util.List;

import javax.persistence.*;

import dao.entities.Personne;
import dao.interfaces.IPersonneDao;

public class PersonneDaoImp implements IPersonneDao{
	
	private EntityManager entityManager;
	
	public PersonneDaoImp() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UP_FASTANDFURIOUS");
		
		entityManager = entityManagerFactory.createEntityManager();
	}

	public void insert(Personne p) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(p);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		
	}	

	public void update(Personne p) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.merge(p);
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
			Personne p = entityManager.find(Personne.class, id);
			entityManager.remove(p);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	public List<Personne> all() {
		Query query = entityManager.createQuery("select p from Personne p");
		return query.getResultList();
	}

}
