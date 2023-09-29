package hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class hibernate_class_50 {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<hibernate.Name> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<hibernate.Name> names = (List<hibernate.Name>)session.createQuery("from hibernate.Name").list();
        return names;
    }

    public void save(hibernate.Name name){
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(name);
        session.flush();
    }
}