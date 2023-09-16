package hibernate;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class hibernate_class_35 {    
    public static void main(String[] args) {
        BasicConfigurator.configure();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            
            Query query = session.createQuery("from vij");
            List<?> list = query.list();
            
            for (Iterator<?> it = list.iterator(); it.hasNext();) {
                // Code here
            }
            
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Include the HibernateUtil class below
    static class HibernateUtil {
        private static SessionFactory sessionFactory;
        
        public static SessionFactory getSessionFactory() {
            if (sessionFactory == null) {
                Configuration configuration = new Configuration().configure();
                sessionFactory = configuration.buildSessionFactory();
            }
            return sessionFactory;
        }
    }
}