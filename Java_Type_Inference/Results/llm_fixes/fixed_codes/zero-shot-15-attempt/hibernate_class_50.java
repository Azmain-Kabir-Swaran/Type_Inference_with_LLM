package hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.entity.Name; // Fix import statement

public class hibernate_class_50 {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<hibernate.entity.Name> getAll() { // Fix import statement
        Session session = this.sessionFactory.getCurrentSession();
        List<hibernate.entity.Name> names = (List<hibernate.entity.Name>)session.createQuery("from hibernate.entity.Name").list(); // Fix import statement
        return names;
    }

    public void save(hibernate.entity.Name name){ // Fix import statement
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(name);
        session.flush();
    }
}