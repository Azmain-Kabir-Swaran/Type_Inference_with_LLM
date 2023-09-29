import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class hibernate_class_38 {

    public static void main(String... args) {
        Configuration config = new Configuration();
        config.configure();
        SessionFactory sessionFact = config.buildSessionFactory();
        Session ses = sessionFact.openSession();
        Transaction tx = ses.beginTransaction();
        String bean ="";
        ses.save(bean);
        tx.commit();
        ses.close();
    }
}