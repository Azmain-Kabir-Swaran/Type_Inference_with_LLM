import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class HibernateClass48 {
    private static final long serialVersionUID = 1L;
    private HibernateUtil gileadHibernateUtil;
    private SessionFactory sessionFactory;
    private PersistentBeanManager persistentBeanManager;

    public HibernateClass48() {
        sessionFactory = // initialize the session factory
        gileadHibernateUtil = new HibernateUtil(sessionFactory);

        persistentBeanManager = new PersistentBeanManager();
        persistentBeanManager.setPersistenceUtil(gileadHibernateUtil);
        persistentBeanManager.setProxyStore(new StatelessProxyStore());

    }

    public String greetServer(String S) {
        Session session = gileadHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.save(S);
        tr.commit();
        session.close();
        return S;
    }

    public static void main(String[] args) {
        HibernateClass48 hibernate = new HibernateClass48();
        String S = "Hello";
        System.out.println(hibernate.greetServer(S));
    }
}