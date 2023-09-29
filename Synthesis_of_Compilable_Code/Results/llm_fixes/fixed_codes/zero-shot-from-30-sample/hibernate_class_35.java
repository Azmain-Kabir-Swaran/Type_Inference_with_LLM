package hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.apache.log4j.BasicConfigurator;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;

public class hibernate_class_35 {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from vij");
            List list = query.list();
            for (Iterator it = list.iterator(); it.hasNext();) {
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
}