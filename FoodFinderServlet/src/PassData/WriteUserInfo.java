package PassData;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class WriteUserInfo {
	private static SessionFactory factory; 
	   public static void main(String[] args) {
	      
	      try {
	         factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	      
	   }
	   
	   /* Method to CREATE an user in the database */
	   public Integer addUser(String fname, String lname, String email, String city, LocalDateTime date){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer userID = null;
	      
	      try {
	         tx = session.beginTransaction();
	         UserInfo user = new UserInfo(fname, lname, email, city, date);
	         userID = (Integer) session.save(user); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return userID;
	   }
	   
	   /* Method to  READ all the users */
	   public void listUsers( ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         List users = session.createQuery("FROM UserData").list(); 
	         for (Iterator iterator = users.iterator(); iterator.hasNext();){
	            UserInfo user = (UserInfo) iterator.next(); 
	            System.out.print("First Name: " + user.getFirstName()); 
	            System.out.print("  Last Name: " + user.getLastName()); 
	            System.out.print("  Email: " + user.getEmail());
	            System.out.println("  Salary: " + user.getCity()); 
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   /* Method to UPDATE city for an user */
	   public void updateUser(Integer userID, String city ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         UserInfo user = (UserInfo)session.get(UserInfo.class, userID); 
	         user.setCity( city );
			 session.update(user); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   /* Method to DELETE a user from the records */
	   public void deleteUser(Integer userID){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         UserInfo user = (UserInfo)session.get(UserInfo.class, userID); 
	         session.delete(user); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
}
