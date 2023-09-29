import org.hibernate.SessionFactory;
import org.hibernate.Session;
import java.util.List;
import com.example.Name;

public class hibernate_class_50 {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    @SuppressWarnings("unchecked")
    public List<com.example.Name> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<com.example.Name> names = (List<com.example.Name>)session.createQuery("from com.example.Name").list();
        return names;
    }

    public void save(com.example.Name name){
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(name);
        session.flush();
    }
}