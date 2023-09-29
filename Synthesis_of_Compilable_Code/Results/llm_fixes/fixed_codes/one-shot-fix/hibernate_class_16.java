package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;
import hibernate.Event;

public class hibernate_class_16 {

    public class Events {
        org.hibernate.Session hibernateSession;

        public void setHibernateSession(org.hibernate.Session hibernateSession) throws Exception {
            this.hibernateSession = hibernateSession;
        }

        public void sethibernateSession(org.hibernate.Session hibernateSession) throws Exception {
            this.hibernateSession = hibernateSession;
        }

        @SuppressWarnings("unchecked")
        public String execute() {

            List<hibernate.Event> events = hibernateSession.createQuery("from hibernate.Event").list();

            for (hibernate.Event theEvent : events) {
                // blah blah...
            }

            return "success";
        }
    }

}