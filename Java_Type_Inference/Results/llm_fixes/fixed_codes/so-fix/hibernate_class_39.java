import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericDao<T, ID extends Serializable> {

    ID create(T newInstance);

    T read(ID primaryKey);

    void update(T transientObject);

    void delete(T persistentObject);

    boolean exists(ID id);

    List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams);

    T get(ID id);

    List<T> getAll();

    List<T> getAllDistinct();

    void reindex();

    void reindexAll(boolean async);

    void remove(T obj);

    void remove(ID id);

    T save(T obj);

    List<T> search(String searchTerm) throws SearchException;

    class SearchException extends Exception {
        // custom exception code
    }
}

public class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ID create(T newInstance) {
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

    public T read(ID primaryKey) {
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

    public void update(T transientObject) {
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

    public void delete(T persistentObject) {
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
}