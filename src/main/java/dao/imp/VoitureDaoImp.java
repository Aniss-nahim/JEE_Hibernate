package dao.imp;

import java.util.List;

import javax.persistence.*;

import dao.entities.Voiture;
import dao.interfaces.IVoitureDao;

public class VoitureDaoImp implements IVoitureDao{
	
	// Entity manager
	private EntityManager entityManager;
	
	public VoitureDaoImp () {
		//Entity manager Factory
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UP_FASTANDFURIOUS");
		
		//Creation de l'objet entity manager
		entityManager = entityManagerFactory.createEntityManager();
	}

	public void insert(Voiture v) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(v);	
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	public void update(Voiture v) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.merge(v);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	public void delete(Long idVoiture) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			Voiture v = entityManager.find(Voiture.class, idVoiture);
			entityManager.remove(v);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	public List<Voiture> all() {
		Query query = entityManager.createQuery("select v from Voiture v");
		return query.getResultList();
	}
	
}
