import org.hibernate.SessionFactory;
import org.hibernate.Query;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONBoolean;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class hibernate_class_22 {
    public JSONObject check() {
        Session session = null;
        JSONObject check = new JSONObject();
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); 
            session = sessionFactory.openSession();
            String username = null;
            boolean justusername = false;
            if (justusername) {
                String hquery = "Select username from User user Where username = ? ";
                Query query = session.createQuery(hquery);
                query.setParameter(0, username);
                String user = (String) query.uniqueResult();
                if (user == null) {
                    check.put("indatabase", JSONBoolean.getInstance(false));
                } else {
                    check.put("indatabase", JSONBoolean.getInstance(true));
                }
                check.put("justusername", JSONBoolean.getInstance(true));
            } else {
                String hquery = "Select username from User user Where username = :user and password = :pass ";
                Query query = session.createQuery(hquery);
                query.setParameter("user", username);
                String password = null;
                query.setParameter("pass", password);
                String user = (String) query.uniqueResult();
                if(user == null) {
                    check.put("indatabase", JSONBoolean.getInstance(false));
                } else {
                    check.put("indatabase", JSONBoolean.getInstance(true));
                }
                check.put("justusername", JSONBoolean.getInstance(false));
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.flush();
            session.close();
        }
        return check;
    }
}