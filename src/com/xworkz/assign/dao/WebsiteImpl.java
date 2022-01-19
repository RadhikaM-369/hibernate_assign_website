package com.xworkz.assign.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.xworkz.assign.entity.WebsiteEntity;
import com.xworkz.assign.util.EMFUtil;

public class WebsiteImpl implements WebsiteInterf{

	public void putAll(List<WebsiteEntity> entity) {
		EntityManager manager=EMFUtil.getEntityManagerFactory().createEntityManager();
		
		EntityTransaction trans=manager.getTransaction();
		trans.begin();
		int flushcount=0;
									
			try {
				for(WebsiteEntity webEntity:entity) {
					manager.persist(webEntity);
					
					if(flushcount>=10) {
						manager.flush();
						
						flushcount=0;
						System.out.println("flusing the data"+flushcount);
						manager.clear();
					}
				
					flushcount++;
				}	trans.commit();
			} 
			catch (PersistenceException e) {
				e.printStackTrace();
				trans.rollback();
			}
		}

	@Override
	public WebsiteEntity getByNameGoogle() {
		EntityManager manager=EMFUtil.getEntityManagerFactory().createEntityManager();
		
		try {
		Query query=manager.createNamedQuery("getByNameGoogle");
		
		Object obj=query.getSingleResult();
		WebsiteEntity wEntityy=(WebsiteEntity) obj;
		
		return wEntityy;
		}
		catch(PersistenceException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public WebsiteEntity getByLikeUrly() {
     EntityManager manager=EMFUtil.getEntityManagerFactory().createEntityManager();
		
		try {
		Query query=manager.createNamedQuery("getByLikeUrly");
		
		Object obj=query.getSingleResult();
		WebsiteEntity wEntityy=(WebsiteEntity) obj;
		
		return wEntityy;
		}
		catch(PersistenceException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public WebsiteEntity getByMinSince() {
		EntityManager manager=EMFUtil.getEntityManagerFactory().createEntityManager();
		
		try {
		Query query=manager.createNamedQuery("getByMinSince");
		
		Object obj=query.getSingleResult();
		WebsiteEntity wEntityy=(WebsiteEntity) obj;
		
		return wEntityy;
		}
		catch(PersistenceException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public WebsiteEntity getByMaxSince() {
		EntityManager manager=EMFUtil.getEntityManagerFactory().createEntityManager();
		
		try {
		Query query=manager.createNamedQuery("getByMaxSince");
		
		Object obj=query.getSingleResult();
		WebsiteEntity wEntityy=(WebsiteEntity) obj;
		
		return wEntityy;
		}
		catch(PersistenceException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public WebsiteEntity getBySecondMinSince() {
		EntityManager manager=EMFUtil.getEntityManagerFactory().createEntityManager();
		
		try {
		Query query=manager.createNamedQuery("getBySecondMinSince");
		
		Object obj=query.getSingleResult();
		WebsiteEntity wEntityy=(WebsiteEntity) obj;
		
		return wEntityy;
		}
		catch(PersistenceException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public WebsiteEntity getBySecondMaxSince() {
		EntityManager manager=EMFUtil.getEntityManagerFactory().createEntityManager();
		
		try {
		Query query=manager.createNamedQuery("getBySecondMaxSince");
		
		Object obj=query.getSingleResult();
		WebsiteEntity wEntityy=(WebsiteEntity) obj;
		
		return wEntityy;
		}
		catch(PersistenceException e) {
			e.printStackTrace();
		}
		return null;
	}	
	}








/*	@Override
	public void save(WebsiteEntity webEntity) {

		EntityManagerFactory entityManagerFactory=EMFUtil.getEntityManagerFactory();
				
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction trans=entityManager.getTransaction();
		
		trans.begin();
		entityManager.persist(webEntity);
		trans.commit();
	}*/
