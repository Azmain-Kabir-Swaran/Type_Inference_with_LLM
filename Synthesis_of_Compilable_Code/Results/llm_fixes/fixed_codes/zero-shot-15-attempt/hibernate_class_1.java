import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class hibernate_class_1 {
    public class HibernateUserDAO implements hibernate.UserDAO {

        private SessionFactory sessionFactory;

        public HibernateUserDAO() {
            AnnotationConfiguration annotConf = new AnnotationConfiguration();
            annotConf.addAnnotatedClass(hibernate.User.class);
            annotConf.configure();
            sessionFactory = annotConf.buildSessionFactory();
        }

        public void store(hibernate.User user) {
            Session session = sessionFactory.openSession();
            Transaction tx = session.getTransaction();
            try {
                tx.begin();
                session.saveOrUpdate(user);
                tx.commit();
            } catch (RuntimeException e) {
                tx.rollback();
                throw e;
            } finally {
                session.close();
            }
        }

        public hibernate.User getUser(int arg0) {
            return null;
        }

        public hibernate.User getUserByFirstLastName(String arg0, String arg1) {
            return null;
        }

        public hibernate.User getUserByUsername(String arg0) {
            return null;
        }

        public int saveUser(hibernate.User arg0) {
            return 0;
        }
    }
}