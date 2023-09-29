package hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernate_class_47 {

    public static boolean registerEvent() {

        Configuration configuration = new Configuration().configure();
        SessionFactory sf = configuration.buildSessionFactory();
        Transaction t = null;
        try {
            Session s = sf.openSession();
            t = s.beginTransaction(); // start a new transaction
            s.persist("aa");
            t.commit(); // commit transaction
            return true;
        } catch (Exception ex) {
            System.err.println("Error -->" + ex.getMessage());
            if (t != null)
                t.rollback(); // rollback transaction on exception
            return false;
        }
    }
}