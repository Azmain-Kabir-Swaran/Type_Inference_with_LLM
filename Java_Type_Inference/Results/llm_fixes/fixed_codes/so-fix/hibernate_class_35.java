import org.apache.log4j.BasicConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class HibernateClass35 {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Vij"); // Changed "vij" to "Vij"
            List list = query.list();
            for (Iterator it = list.iterator(); it.hasNext(); ) {
                //System.out.println(label.getId());
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