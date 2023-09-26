import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import hibernate.util.HibernateUtil;

import java.util.List;

public class hibernate_class_41 {
    public static List<?> list(Class<?> className, int start, int limit, String[] searchFilter) {
        Session session = HibernateUtil.getSessionFactory().openSession();
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
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }
}