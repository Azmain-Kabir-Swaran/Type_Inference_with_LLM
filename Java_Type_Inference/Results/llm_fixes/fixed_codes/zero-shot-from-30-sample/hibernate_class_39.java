package hibernate;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.search.SearchException;
import org.springframework.transaction.annotation.Transactional;

public class hibernate_class_39 {
    @Transactional
    public class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {
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

        public void update(final T transientObject) {
            final Session session = sessionFactory.openSession();
            final Transaction tx = session.beginTransaction();
            try {
                session.saveOrUpdate(transientObject);
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
        }

        public void delete(final T persistentObject) {
            final Session session = sessionFactory.openSession();
            final Transaction tx = session.beginTransaction();
            try {
                session.delete(persistentObject);
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
        }

        public boolean exists(ID arg0) {
            return false;
        }

        public List<T> findByNamedQuery(String arg0, Map<String, Object> arg1) {
            return null;
        }

        public T get(ID arg0) {
            return null;
        }

        public List<T> getAll() {
            return null;
        }

        public List<T> getAllDistinct() {
            return null;
        }

        public void reindex() {

        }

        public void reindexAll(boolean arg0) {

        }

        public void remove(T arg0) {

        }

        public void remove(ID arg0) {

        }

        public T save(T arg0) {
            return null;
        }

        public List<T> search(String arg0) throws org.hibernate.search.SearchException {
            return null;
        }
    }
}