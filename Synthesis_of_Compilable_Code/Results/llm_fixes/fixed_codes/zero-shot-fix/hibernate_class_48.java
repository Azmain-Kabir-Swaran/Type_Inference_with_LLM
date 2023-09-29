package hibernate;

import net.sf.gilead.core.hibernate.HibernateUtil;
import net.sf.gilead.core.PersistentBeanManager;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import net.sf.gilead.core.store.stateless.StatelessProxyStore;

public abstract class hibernate_class_48 extends RemoteServiceServlet implements GreetingService {

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