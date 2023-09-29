package hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.Session;

import com.google.gwt.json.client.JSONObject;

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
                Query<String> query = session.createQuery(hquery, String.class);
                query.setParameter(0, username);
                String user = query.uniqueResult();
                if (user == null) {
                    check.put("indatabase", false);
                } else {
                    check.put("indatabase", true);
                }
                check.put("justusername", true);
            } else {
                String hquery = "Select username from User user Where username = :user and password = :pass ";
                Query<String> query = session.createQuery(hquery, String.class);
                query.setParameter("user", username);
                String password = null;
                query.setParameter("pass", password);
                String user = query.uniqueResult();
                if (user == null) {
                    check.put("indatabase", false);
                } else {
                    check.put("indatabase", true);
                }
                check.put("justusername", false);
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