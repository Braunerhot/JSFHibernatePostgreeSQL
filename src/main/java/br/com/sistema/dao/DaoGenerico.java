package br.com.sistema.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.sistema.jpautil.JPAUtil;

public class DaoGenerico<E> {

	public void salvar(E entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entitytransaction = entityManager.getTransaction();
		entitytransaction.begin();
		entityManager.persist(entidade);
		entitytransaction.commit();
		entityManager.close();
	}

	public E merge(E entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entitytransaction = entityManager.getTransaction();
		entitytransaction.begin();

		E retorno = entityManager.merge(entidade);

		entitytransaction.commit();
		entityManager.close();
		return retorno;
	}

	public void delete(E entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entitytransaction = entityManager.getTransaction();
		entitytransaction.begin();
		
		entityManager.remove(entidade);
		
		entitytransaction.commit();
		entityManager.close();
	}
	
	public void deletePorId(E entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Object id = JPAUtil.getPrimaryKey(entidade);
		entityManager.createQuery("delete from " + entidade.getClass().getCanonicalName() + " where id = " + id).executeUpdate();
		
		entityTransaction.commit();
		entityManager.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<E> getListEntity(Class<E> entidade){
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		List<E> retorno = entityManager.createQuery("from " + entidade.getName()).getResultList();
		
		entityTransaction.commit();
		entityManager.close();
		return retorno;
	}

}
