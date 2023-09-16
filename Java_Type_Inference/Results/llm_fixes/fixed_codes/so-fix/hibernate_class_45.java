import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Date;

public class hibernate_class_45 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        // Fixed code starts here
        Message m1 = new Message();
        m1.setText("Hibernated a message on " + new Date());
        session.save(m1);
        // Fixed code ends here

        session.getTransaction().commit();
        session.close();
    }
}

class Message {
    private String text;
    
    public Message() {}
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
}