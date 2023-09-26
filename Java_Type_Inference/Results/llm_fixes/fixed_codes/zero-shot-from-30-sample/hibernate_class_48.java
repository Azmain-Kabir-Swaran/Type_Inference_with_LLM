import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import hibernate.StatelessProxyStore;
import hibernate.GreetingService;
import hibernate.PersistentRemoteService;
import hibernate.PersistentBeanManager;
import hibernate.HibernateUtil;

public abstract class hibernate_class_48 extends PersistentRemoteService implements GreetingService {

    private static final long serialVersionUID = 1L;
    private HibernateUtil gileadHibernateUtil = new HibernateUtil();

    public hibernate_class_48() {
        SessionFactory session = null;
        gileadHibernateUtil.setSessionFactory(session);

        PersistentBeanManager persistentBeanManager = new PersistentBeanManager();
        persistentBeanManager.setPersistenceUtil(gileadHibernateUtil);
        persistentBeanManager.setProxyStore(new StatelessProxyStore());

        setBeanManager(persistentBeanManager);
    }

    public String greetServer(String S) {
        Session session = gileadHibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.save(S);
        tr.commit();
        session.close();
        return S;
    }

}