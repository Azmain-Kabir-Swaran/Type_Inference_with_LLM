package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class HibernateUserDAO implements UserDAO {
   private SessionFactory sessionFactory;

   public HibernateUserDAO() {
    Configuration config = new Configuration();
    config.configure();
    config.addAnnotatedClass(User.class);
    sessionFactory = config.buildSessionFactory();
   }

   public void store(User user) {
    Session session = sessionFactory.openSession();
    Transaction tx = session.getTransaction();
    try {
     tx.begin();
     session.saveOrUpdate(user);
     tx.commit();
    } catch (RuntimeException e) {
     tx.rollback();
     throw e;
    } finally {
     session.close();
    }
   }

   @Override
    public User getUser(int id) {
      Session session = sessionFactory.openSession();
      try {
        return (User) session.get(User.class, id);
      } catch (RuntimeException e) {
        throw e;
      } finally {
        session.close();
      }
    }
   
   @Override
    public User getUserByFirstLastName(String firstName, String lastName) {
      Session session = sessionFactory.openSession();
      try {
        String query = "FROM User u WHERE u.firstName = :firstName AND u.lastName = :lastName";
        return (User) session.createQuery(query)
                            .setParameter("firstName", firstName)
                            .setParameter("lastName", lastName)
                            .uniqueResult();
      } catch (RuntimeException e) {
        throw e;
      } finally {
        session.close();
      }
    }
   
   @Override
    public User getUserByUsername(String username) {
      Session session = sessionFactory.openSession();
      try {
        String query = "FROM User u WHERE u.username = :username";
        return (User) session.createQuery(query)
                            .setParameter("username", username)
                            .uniqueResult();
      } catch (RuntimeException e) {
        throw e;
      } finally {
        session.close();
      }
    }
   
   @Override
    public int saveUser(User user) {
      Session session = sessionFactory.openSession();
      Transaction tx = session.getTransaction();
      try {
        tx.begin();
        int id = (int) session.save(user);
        tx.commit();
        return id;
      } catch (RuntimeException e) {
        tx.rollback();
        throw e;
      } finally {
        session.close();
      }
    }
}