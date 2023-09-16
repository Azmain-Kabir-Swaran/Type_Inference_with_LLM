import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateUtil {
    public static SessionFactory getSessionFactory() {
        // return the SessionFactory
    }
}

public class Hibernate_class_47 {
    public static boolean registerEvent() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Transaction t = null;
        try {
            Session s = sf.openSession();
            t = s.beginTransaction();
            s.persist("aa");
            t.commit();
            return true;
        } catch (Exception ex) {
            System.err.println("Error -->" + ex.getMessage());
            if (t != null) t.rollback();
            return false;
        }
    }
}