import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import java.util.List;

public class hibernate_class_41 {
    @SuppressWarnings("unchecked")
    public static List list(Class<?> className,int start,int limit,String[] searchFilter){
        
        // Create session factory
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
        Session session = sessionFactory.openSession();

        // Remaining code is same as before
        Transaction transaction = null; 
        try {
            transaction = session.beginTransaction();

            Criteria criteria = session.createCriteria(className);
            criteria.setFirstResult(start);
            criteria.setMaxResults(limit);
            
            for(String sf : searchFilter){
                String[] values = null;
                if(values == null){
                    if(values.length == 1) {
                        criteria.add(Restrictions.eq(sf, values[0]));
                    }else{
                        criteria.add(Restrictions.in(sf, values));
                    }
                }
            }

            List<Object> objects = (List<Object>) criteria.list();
            
            transaction.commit();
            return objects;

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally{
            session.close();
            sessionFactory.close();
        }

        return null;
    }
}