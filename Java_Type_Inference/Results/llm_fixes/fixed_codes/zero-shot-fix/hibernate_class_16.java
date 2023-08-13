package hibernate;

import java.util.List;

import org.hibernate.Session;

public class Event {
    // event properties and methods
}

public class HibernateClass16 {
    public static class Events {
        private Session hibernateSession;

        public void setHibernateSession(Session hibernateSession) {
            this.hibernateSession = hibernateSession;
        }

        public String execute() {

            List<Event> events = hibernateSession.createQuery("from Event").list();

            for (Event theEvent : events) {
                // blah blah...
            }

            return "success";
        }
    }
}