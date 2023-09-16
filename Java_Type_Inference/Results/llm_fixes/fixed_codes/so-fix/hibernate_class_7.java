import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private final SessionFactory sessionFactory;
    private Session session;

    public HibernateUtils() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public HibernateUtils(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session requestSession() {
        if (session != null && session.isOpen()) {
            return session;
        } else {
            session = sessionFactory.openSession();
            return session;
        }
    }

    public static void main(String[] args) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.requestSession();
        // rest of the code
    }
}