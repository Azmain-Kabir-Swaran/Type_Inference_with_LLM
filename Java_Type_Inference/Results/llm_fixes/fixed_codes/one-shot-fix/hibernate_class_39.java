import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class hibernate_class_39 {
    @Transactional
    public class GenericDaoImpl<T, ID extends Serializable> implements
            GenericDao<T, ID> {
        private SessionFactory sessionFactory;

        public void setSessionFactory(final SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }

        public ID create(final T newInstance) {
            ID id = null;
            final Session session = sessionFactory.openSession();
            final Transaction tx = session.beginTransaction();
            try {
                id = (ID) session.save(newInstance);
                tx.commit();
                session.close();
            } catch (final Exception e) {
                if (tx != null) {
                    tx.rollback();
                }
                e.printStackTrace();
            } finally {
                if (session.isOpen()) {
                    session.close();
                }
            }
            return id;
        }

        public T read(final ID primaryKey) {
            T id = null;
            final Session session = sessionFactory.openSession();
            final Transaction tx = session.beginTransaction();
            try {
                id = (T) session.get("aaa", primaryKey);
                tx.commit();
                session.close();
            } catch (final Exception e) {
                if (tx != null) {
                    tx.rollback();
                }
                e.printStackTrace();
            } finally {
                if (session.isOpen()) {
                    session.close();
                }
            }
            return id;
        }
    }
}