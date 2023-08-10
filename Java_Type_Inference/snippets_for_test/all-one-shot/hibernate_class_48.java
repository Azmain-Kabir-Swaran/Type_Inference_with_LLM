package hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.example.client.GreetingService;
import com.example.server.HibernateUtil;
//ID = 4346254



public abstract class hibernate_class_48 extends PersistentRemoteService implements GreetingService 
{

    private static final long serialVersionUID = 1L;
    private HibernateUtil gileadHibernateUtil = new HibernateUtil();
    public hibernate_class_48 ()
    {
    	SessionFactory session = null;
         gileadHibernateUtil.setSessionFactory(session);

                PersistentBeanManager persistentBeanManager = new PersistentBeanManager();
                persistentBeanManager.setPersistenceUtil(gileadHibernateUtil);
                persistentBeanManager.setProxyStore(new StatelessProxyStore());

                setBeanManager(persistentBeanManager);
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