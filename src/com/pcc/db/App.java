package com.pcc.db;

import java.util.*;
import javax.persistence.*;



public class App {
	private static final String UNIT_NAME = "JPA-Test";
	private static EntityManagerFactory factory;
	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		EMP inM = new EMP();
		//factory.getProperties().put("javax.persistence.jdbc.password", "passw0rd");
		factory.getProperties().forEach((k,v) -> System.err.println(k + " : " + v));
		
		inM.setEname("Anton");
		inM.setJob("Mauer");
		inM.setSal(2200);
		
		em.persist(inM);
		em.getTransaction().commit();
		
		Query q = em.createQuery("select m from EMP m");
		//Query q = em.createNativeQuery("SELECT * FROM EMP");
		
		List<EMP> modelList = q.getResultList();
		System.out.println(modelList.size());
		
		for(Object m : modelList){
			System.out.println(m);
		}
		
		em.close();
		
	}

}
