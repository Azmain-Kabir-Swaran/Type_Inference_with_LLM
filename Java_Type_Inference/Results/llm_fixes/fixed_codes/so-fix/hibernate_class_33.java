import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateClass33 {

    private static HibernateClass33 instance = null;
    private static SessionFactory sessionFactory;

    public static HibernateClass33 getInstance() {
        if (instance == null) {
            instance = new HibernateClass33().init();
        }

        return instance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    private HibernateClass33 init() {
        Configuration cfg = new Configuration();

        cfg.addAnnotatedClass(UserClass.class);
        cfg.addAnnotatedClass(User.class);

        cfg.setProperties(System.getProperties());
        cfg.configure();
        sessionFactory = cfg.buildSessionFactory();
        return this;
    }

    public static void main(String[] args) {
        HibernateClass33.getInstance();
    }
}