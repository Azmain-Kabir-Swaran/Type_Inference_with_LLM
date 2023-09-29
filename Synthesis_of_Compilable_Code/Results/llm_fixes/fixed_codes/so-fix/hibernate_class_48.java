import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import org.hibernate.HibernateUtil;
import org.hibernate.PersistentBeanManager;
import org.hibernate.StatelessProxyStore;

public abstract class hibernate_class_48 extends RemoteServiceServlet {

    private static final long serialVersionUID = 1L;
    private HibernateUtil gileadHibernateUtil = new HibernateUtil();
    public hibernate_class_48 ()
    {
        SessionFactory session = null;
        gileadHibernateUtil.setSessionFactory(session);

        PersistentBeanManager persistentBeanManager = new PersistentBeanManager();
        persistentBeanManager.setPersistenceUtil(gileadHibernateUtil);
        persistentBeanManager.setProxyStore(new StatelessProxyStore());

    }

    public String greetServer(String S) 
    {
        Session session = gileadHibernateUtil.getSessionFactory().openSession();
        Transaction tr= session.beginTransaction();
        session.save(S);
        tr.commit();
        session.close();
        return S;
    }
}