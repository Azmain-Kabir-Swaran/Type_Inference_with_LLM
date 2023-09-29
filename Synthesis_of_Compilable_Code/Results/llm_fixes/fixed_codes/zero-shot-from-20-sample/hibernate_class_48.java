package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;

import org.hibernate.engine.spi.PersistentAttributeInterceptable;
import org.hibernate.engine.spi.PersistentAttributeInterceptor;
import org.hibernate.proxy.StatelessProxy;
import org.hibernate.proxy.pojo.BasicLazyInitializer;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public abstract class hibernate_class_48 extends RemoteServiceServlet implements RemoteService {

    private static final long serialVersionUID = 1L;
    private HibernateUtil gileadHibernateUtil = new HibernateUtil();

    public hibernate_class_48() {
        SessionFactory session = null;
        gileadHibernateUtil.setSessionFactory(session);

        PersistentAttributeInterceptable interceptable = new PersistentAttributeInterceptable() {
            private static final long serialVersionUID = 1L;
            private PersistentAttributeInterceptor interceptor;

            @Override
            public PersistentAttributeInterceptor $$_hibernate_getInterceptor() {
                return interceptor;
            }

            @Override
            public void $$_hibernate_setInterceptor(PersistentAttributeInterceptor interceptor) {
                this.interceptor = interceptor;
            }
        };

        BasicLazyInitializer lazyInitializer = new BasicLazyInitializer(
                interceptable,
                null,
                null,
                null,
                null
        );

        StatelessProxy statelessProxy = new StatelessProxy(
                lazyInitializer,
                null,
                null,
                null
        );

        gileadHibernateUtil.setProxy(statelessProxy);

        setBeanManager(interceptable);
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