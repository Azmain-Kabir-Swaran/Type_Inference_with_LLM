package hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class hibernate_class_40 {

    public static void main(String[] args) {
        Session session = null;

        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();

            System.out.println("selecting records");
            
            @SuppressWarnings("unchecked")
            List<Object[]> l = session.getNamedQuery("getRecordsSP").list();

            for (Iterator<Object[]> it = l.iterator(); it.hasNext();) {
                Object[] row = it.next();
                System.out.println(row.length);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }
}