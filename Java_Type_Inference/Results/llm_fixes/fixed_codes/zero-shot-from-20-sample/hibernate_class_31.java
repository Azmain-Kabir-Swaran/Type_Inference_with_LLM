package hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;

public class hibernate_class_31 {
    public static List<Users> getData() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        List<Users> result = null;
        try {
            session.beginTransaction();
            Query<Users> query = session.createQuery("from Users", Users.class);
            result = query.list();
            session.getTransaction().commit();
            query.setReadOnly(true);
            query.setMaxResults(50);
            session.flush();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}