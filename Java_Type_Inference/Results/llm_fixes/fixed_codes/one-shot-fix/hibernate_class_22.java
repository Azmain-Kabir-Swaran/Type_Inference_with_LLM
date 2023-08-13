import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.google.gson.JsonObject;

public class hibernate_class_22 {
    public JsonObject check() {
        Session session = null;
        JsonObject check = new JsonObject();
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();

            String username = null;
            boolean justusername = false;
            if (justusername) {
                String hquery = "SELECT username FROM User user WHERE username = :username";
                Query<String> query = session.createQuery(hquery, String.class);
                query.setParameter("username", username);
                String user = query.uniqueResult();
                if (user == null) {
                    check.addProperty("indatabase", false);
                } else {
                    check.addProperty("indatabase", true);
                }
                check.addProperty("justusername", true);
            } else {
                String hquery = "SELECT username FROM User user WHERE username = :username AND password = :password";
                Query<String> query = session.createQuery(hquery, String.class);
                query.setParameter("username", username);
                String password = null;
                query.setParameter("password", password);
                String user = query.uniqueResult();
                if (user == null) {
                    check.addProperty("indatabase", false);
                } else {
                    check.addProperty("indatabase", true);
                }
                check.addProperty("justusername", false);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.flush();
            session.close();
        }
        return check;
    }
}