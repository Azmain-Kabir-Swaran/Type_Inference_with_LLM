import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import javax.faces.context.FacesContext;

public class hibernate_class_12 {
    public static void main(String[] args) {
        Session session = null;
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();

            String id = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("storeId");

            Transaction t = session.beginTransaction();
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}