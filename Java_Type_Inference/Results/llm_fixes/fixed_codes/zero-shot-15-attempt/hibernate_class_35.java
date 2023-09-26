package hibernate;
import org.hibernate.HibernateException;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernate_class_35 {    
	public static void main(String[] args) {
	    BasicConfigurator.configure();
	    Configuration configuration = new Configuration().configure();
	    SessionFactory sessionFactory = configuration.buildSessionFactory();
	    Session session = sessionFactory.openSession();
	    Transaction transaction = null;
	    try {
	        transaction = session.beginTransaction();
//	        Label label = new Label("vijay");
	        Query query=session.createQuery("from vij");
	        List list=query.list();
	            for (Iterator it=list.iterator();it.hasNext();)
	        {
//	            System.out.println(label.getId());          
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