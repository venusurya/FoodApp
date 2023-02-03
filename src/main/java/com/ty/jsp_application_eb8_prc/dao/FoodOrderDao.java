package com.ty.jsp_application_eb8_prc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.jsp_application_eb8_prc.dto.FoodOrder;
import com.ty.jsp_application_eb8_prc.dto.User;

public class FoodOrderDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}

	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		foodOrder.setEmail(foodOrder.getEmail());
		entityManager.merge(foodOrder);
		entityTransaction.commit();

		return foodOrder;
	}
	
	
	public FoodOrder getFoodOrderByEmail(String email) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT u FROM  FoodOrder u WHERE u.email=?1");
		query.setParameter(1, email);
		FoodOrder order = (FoodOrder) query.getSingleResult();
		return order;
	}

}
