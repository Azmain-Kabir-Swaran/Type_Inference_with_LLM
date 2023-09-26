import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.apache.log4j.BasicConfigurator;
import java.util.Iterator;
import java.util.List;

public class hibernate_class_35 {    
    public static void main(String[] args) {
        BasicConfigurator.configure();
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from vij");
            List list = query.list();
            for (Iterator it = list.iterator(); it.hasNext();) {
                // Code inside the loop
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