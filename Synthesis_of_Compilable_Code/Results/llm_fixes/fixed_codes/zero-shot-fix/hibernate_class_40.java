package hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class hibernate_class_40 {

    public static void main(String[] args) {

        Session session = null;

        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();

            System.out.println("selecting records");
            Query<Object[]> q = session.getNamedQuery("getRecordsSP");
            System.out.print("Done");
            List<Object[]> l = q.list();

            for (Iterator<Object[]> it = l.iterator(); it.hasNext();) {
                Object[] row = it.next();
                System.out.println(row.length);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
}