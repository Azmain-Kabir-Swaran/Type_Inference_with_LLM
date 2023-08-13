package hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernate_class_47 {
  
    public static boolean registerEvent() {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Transaction t = null;
        try  {
            Session s  = sf.openSession();
            t = s.beginTransaction();
            s.persist("aa");
            t.commit();
            return true;
        } catch(Exception ex) {
            System.err.println("Error -->"  + ex.getMessage());
            if (t != null) t.rollback();
            return false;
        }
    }
}