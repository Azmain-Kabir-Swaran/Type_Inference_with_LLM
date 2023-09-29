import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class hibernate_class_7 {
    public class HibernateUtils {
        private final SessionFactory sessionFactory;
        private Session session;

        public HibernateUtils() {
            this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        }

        public HibernateUtils(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }

        public Session requestSession() {
            session = sessionFactory.openSession();
            return session;
        }
    }
}