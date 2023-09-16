import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernate_class_18 {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure();
            return configuration.buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory1() {
        return sessionFactory;
    }

    private static final SessionFactory sessionFactory1 = buildSessionFactory1();

    private static SessionFactory buildSessionFactory1() {
        try {
            Configuration configuration = new Configuration().configure();
            return configuration.buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}

