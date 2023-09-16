import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class hibernate_class_24 {
    public static class HibernateInvocationHandler implements InvocationHandler {
        final private org.hibernate.cfg.Configuration config;
        private org.hibernate.SessionFactory realSessionFactory;

        public HibernateInvocationHandler(org.hibernate.cfg.Configuration config) {
            this.config = config;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (false) proxy.hashCode();
            System.out.println("Proxy for SessionFactory called");
            synchronized (this) {
                if (this.realSessionFactory == null) {
                    org.hibernate.SessionFactory sf=null;
                    try {
                        System.out.println("Gonna BUILD one or die trying");
                        sf = this.config.buildSessionFactory();
                    } catch (RuntimeException e) {
                        System.out.println("FAILED to build");
                        sf = null;
                    }
                    this.realSessionFactory = sf;
                }
                return method.invoke(this.realSessionFactory, args);
            }
        }
    }
}