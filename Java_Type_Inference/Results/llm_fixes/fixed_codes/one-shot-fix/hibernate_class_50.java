package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class hibernate_class_50 {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public List<Name> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Name> query = session.createQuery("from Name", Name.class);
        List<Name> names = query.getResultList();
        return names;
    }

    public void save(Name name) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(name);
        session.flush();
    }
}
