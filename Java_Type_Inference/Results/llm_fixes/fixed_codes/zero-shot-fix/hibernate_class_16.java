package hibernate;

import java.util.List;
import org.hibernate.Session;
import hibernate.Event;

public class hibernate_class_16 {

    public class Events {
        Session hibernateSession;

        public void setHibernateSession(Session hibernateSession) throws Exception {
            this.hibernateSession = hibernateSession;
        }

        public void sethibernateSession(Session hibernateSession) throws Exception {
            this.hibernateSession = hibernateSession;
        }

        @SuppressWarnings("unchecked")
        public String execute() {

            List<Event> events = hibernateSession.createQuery("from hibernate.Event", Event.class).list();

            for (Event theEvent : events) {
                // blah blah...
            }

            return "success";
        }
    }
}