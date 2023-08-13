package hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
//ID = 3218631

public class hibernate_class_31
{
    public static List<?> getData ()
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        List<?> result = null;
        try
        {
            session.beginTransaction();
            Query query = session.createQuery("from Users");
            result = query.list();
            session.getTransaction().commit();
            query.setReadOnly(true);
            query.setMaxResults(50);
            session.flush();
            session.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;      
    }

}