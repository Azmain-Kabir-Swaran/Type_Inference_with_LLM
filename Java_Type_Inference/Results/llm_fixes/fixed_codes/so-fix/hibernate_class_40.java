import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import java.util.Iterator;
import java.util.List;

public class hibernate_class_40 {

    public static void main(String[] args) {

        Session session = null;

        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();

            System.out.println("selecting records");
            Query q = session.getNamedQuery("getRecordsSP");
            List l = q.list();

            for(Iterator<?> it = l.iterator(); it.hasNext();) {
                Object[] row = (Object[]) it.next();
                System.out.println(row.length);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
}