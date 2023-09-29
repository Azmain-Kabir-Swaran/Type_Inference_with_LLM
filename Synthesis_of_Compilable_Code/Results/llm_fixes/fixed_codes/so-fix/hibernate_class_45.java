import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class hibernate_class_45 {
    public static void main(String[] args) {
        org.hibernate.SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
        org.hibernate.Session session = factory.openSession();
        session.beginTransaction();

        session.save("aa");
        session.getTransaction().commit();
        session.close();
    }
}