import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
//import org.json.simple.JSONObject;   <-- remove this line
//import org.json.simple.parser.JSONParser;   <-- remove this line

public class hibernate_class_22 {
    public static void main(String[] args) {
        Session session = null;
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
                    System.out.println("indatabase: false");
                } else {
                    System.out.println("indatabase: true");
                }
                System.out.println("justusername: true");
            } else {
                String hquery = "Select username from User user Where username = :user and password = :pass ";
                Query query = session.createQuery(hquery);
                query.setParameter("user", username);
                String password = null;
                query.setParameter("pass", password);
                String user = (String) query.uniqueResult();
                if (user == null) {
                    System.out.println("indatabase: false");
                } else {
                    System.out.println("indatabase: true");
                }
                System.out.println("justusername: false");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.flush();
            session.close();
        }
    }
}