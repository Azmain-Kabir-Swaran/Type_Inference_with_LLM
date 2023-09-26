package hibernate;
import java.util.List;
import org.hibernate.Session;

/**
 * This class represents the data mapper for an employee to the
 * database.
 */
public class hibernate_class_16{
    public static class Event {
        // Event class implementation
    }

    public static class Events {
        org.hibernate.Session hibernateSession;

        public void setHibernateSession(org.hibernate.Session hibernateSession) throws Exception {
            this.hibernateSession = hibernateSession;
        }
        public void sethibernateSession(org.hibernate.Session hibernateSession) throws Exception {
            this.hibernateSession = hibernateSession;
        }

        @SuppressWarnings("unchecked")
        public String execute() {
            List<Event> events = hibernateSession.createQuery("from hibernate_class_16.Event").list();

            for (hibernate_class_16.Event theEvent : events) {
                // blah blah...
            }

            return "success";
        }
    }
}