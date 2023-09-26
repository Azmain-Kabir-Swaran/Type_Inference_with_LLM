import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import java.util.List;
import java.util.Iterator;

public class hibernate_class_35 {    
    public static void main(String[] args) {
        BasicConfigurator.configure();
        Session session = HibernateUtil.getSessionFactory().openSession();
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