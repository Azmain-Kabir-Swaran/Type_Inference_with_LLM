import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class hibernate_class_41 {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = buildSessionFactory();
        Session session = sessionFactory.openSession();
        List results = list(Object.class, 0, 10, new String[]{"searchFilter"});
        session.close();
    }

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
            return sessionFactory;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("There was an error building the session factory");
        }
    }

    @SuppressWarnings("unchecked")
    public static List list(Class className, int start, int limit, String[] searchFilter) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            Criteria criteria = session.createCriteria(className);
            criteria.setFirstResult(start);
            criteria.setMaxResults(limit);

            for (String sf : searchFilter) {
                String[] values = null;
                if (values == null) {
                    if (values.length == 1) {
                        criteria.add(Restrictions.eq(sf, values[0]));
                    } else {
                        criteria.add(Restrictions.in(sf, values));
                    }
                }
            }

            List<?> objects = criteria.list();
            transaction.commit();

            return objects;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}