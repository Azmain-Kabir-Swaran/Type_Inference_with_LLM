import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class hibernate_class_12 {
    public void main() {
        Session session = null;
        try {
            org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration().configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            session = sessionFactory.openSession();

            String id = (String) javax.faces.context.FacesContext.getCurrentInstance()
                    .getExternalContext().getRequestParameterMap().get("storeId");

            Transaction t = session.beginTransaction();
            t.commit();
        } catch (Exception e) {
        } finally {
            session.close();
        }
    }
}