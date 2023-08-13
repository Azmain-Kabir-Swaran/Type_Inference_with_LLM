package hibernate;
import org.hibernate.Session;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.Map;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

public class hibernate_class_39 {
    @Transactional
    @SuppressWarnings("unchecked")
    public static class GenericDaoImpl<T, ID extends Serializable> implements
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

        public void update(final T transientObject) {
            final Session session = sessionFactory.openSession();
            final Transaction tx = session.beginTransaction();
            try {
                session.saveOrUpdate(transientObject);
                tx.commit();
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
        }

        public void delete(final T persistentObject) {
            final Session session = sessionFactory.openSession();
            final Transaction tx = session.beginTransaction();
            try {
                session.delete(persistentObject);
                tx.commit();
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
        }

        @Override
        public boolean exists(ID arg0) {
            return false;
        }

        @Override
        public List<T> findByNamedQuery(String arg0, Map<String, Object> arg1) {
            return null;
        }

        @Override
        public T get(ID arg0) {
            return null;
        }

        @Override
        public List<T> getAll() {
            return null;
        }

        @Override
        public List<T> getAllDistinct() {
            return null;
        }

        @Override
        public void reindex() {

        }

        @Override
        public void reindexAll(boolean arg0) {

        }

        @Override
        public void remove(T arg0) {

        }

        @Override
        public void remove(ID arg0) {

        }

        @Override
        public T save(T arg0) {
            return null;
        }

        @Override
        public List<T> search(String arg0) throws SearchException {
            return null;
        }
    }

    public interface GenericDao<T, ID extends Serializable> {
        boolean exists(ID id);
        List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams);
        T get(ID id);
        List<T> getAll();
        List<T> getAllDistinct();
        void reindex();
        void reindexAll(boolean async);
        void remove(T object);
        void remove(ID id);
        T save(T object);
        List<T> search(String searchTerm) throws SearchException;
    }

    public static class SearchException extends Exception {
        
    }
}