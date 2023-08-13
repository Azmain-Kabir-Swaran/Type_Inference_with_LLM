package hibernate;

import net.sf.gilead.core.PersistentBeanManager;
import net.sf.gilead.core.hibernate.HibernateUtil;
import net.sf.gilead.core.store.stateless.StatelessProxyStore;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class hibernate_class_48 extends RemoteServiceServlet implements GreetingService {

    private static final long serialVersionUID = 1L;
    
    private HibernateUtil gileadHibernateUtil;
    
    public hibernate_class_48() {
        super();
        gileadHibernateUtil = new HibernateUtil();
        
        Configuration config = new Configuration();
        config.configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        gileadHibernateUtil.setSessionFactory(sessionFactory);
        
        PersistentBeanManager persistentBeanManager = new PersistentBeanManager();
        persistentBeanManager.setPersistenceUtil(gileadHibernateUtil);
        persistentBeanManager.setProxyStore(new StatelessProxyStore());
        setBeanManager(persistentBeanManager);
    }

    public String greetServer(String S) {
      SessionFactory sessionFactory = gileadHibernateUtil.getSessionFactory();
      Session session = sessionFactory.openSession();
      Transaction tr = session.beginTransaction();
      session.save(S);
      tr.commit();
      session.close();
      return S;
    }
}
