package dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.catalina.Manager;


import dto.UserInfo;

public class UserDao {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			
			public void save(UserInfo info){
				entityTransaction.begin();
				entityManager.persist(info);
				entityTransaction.commit();
			}
//			
//			
//			  
			  public UserInfo fetch(long mobile)
			  {
				  List<UserInfo> list =entityManager.createQuery("select x from UserInfo x where mobile=?1").setParameter(1, mobile).getResultList();
				  if(list.isEmpty())
				  {
					  return null;
				  }
				  else{
					  return list.get(0);
				  }
			  }

			  public UserInfo fetch(String email)
			  {
				  List<UserInfo> list =entityManager.createQuery("select x from UserInfo x where email=?1").setParameter(1, email).getResultList();
				  if(list.isEmpty())
				  {
					  return null;
				  }
				  else{
					  return list.get(0);
				  }
			  }
			  public List<UserInfo> fetchAll(){
				  return entityManager.createQuery("select x from UserInfo x").getResultList();
			  }
			  public void delete(UserInfo info){
				  entityTransaction.begin();
				  entityManager.remove(info);
				  entityTransaction.commit();
			  }
			  
			  public UserInfo fetch(int id){
				return entityManager.find(UserInfo.class, id);
		  }	
			  
			 
			  
			  
			  
			  
			  
			  
			  
}
