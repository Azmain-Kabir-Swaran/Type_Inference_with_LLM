import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.json.JSONObject;

public class hibernate_class_22 {
    public JSONObject check()
    {
        Session session = null;
        JSONObject check = new JSONObject();
        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); 
            session = sessionFactory.openSession();

            String username = null;
            boolean justusername=false;
            if (justusername){
                String hquery = "Select username from User user Where username = ? ";
                Query query = session.createQuery(hquery);
                query.setString(0, username);
                String user = (String) query.uniqueResult();
                if (user == null)
                {
                    check.put("indatabase", "false");
                }
                else
                {
                    check.put("indatabase", "true");
                }
                check.put("justusername", true);
            }
            else
            {
                String hquery = "Select username from User user Where username = :user and password = :pass ";
                Query query = session.createQuery(hquery);
                query.setString("user", username);
                String password = null;
                query.setString("pass", password);
                String user = (String) query.uniqueResult();
                if(user ==null)
                {
                    check.put("indatabase", false);
                }
                else
                {
                    check.put("indatabase", true);
                }
                check.put("justusername", false);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            session.flush();
            session.close();
        }
        return check;
    }
}