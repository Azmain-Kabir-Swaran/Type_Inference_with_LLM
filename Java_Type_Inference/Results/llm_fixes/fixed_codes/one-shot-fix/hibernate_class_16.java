import org.hibernate.Session;
import java.util.List;
import com.hibernate.Event;

public class hibernate_class_16 {
    Session hibernateSession;

    public void setHibernateSession(Session hibernateSession) throws Exception {
        this.hibernateSession = hibernateSession;
    }

    @SuppressWarnings("unchecked")
    public String execute() {
        List<Event> events = hibernateSession.createQuery("from Event").list();

        for (Event theEvent : events) {
            // blah blah...
        }

        return "success";
    }
}