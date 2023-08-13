import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class SearchException extends RuntimeException {
    public SearchException(String message) {
        super(message);
    }
}

interface GenericDao<T, ID extends Serializable> {
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

    @Override
    public boolean exists(ID id) {
        // TODO: Implement method
        return false;
    }

    @Override
    public List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
        // TODO: Implement method
        return null;
    }

    @Override
    public T get(ID id) {
        // TODO: Implement method
        return null;
    }

    @Override
    public List<T> getAll() {
        // TODO: Implement method
        return null;
    }

    @Override
    public List<T> getAllDistinct() {
        // TODO: Implement method
        return null;
    }

    @Override
    public void reindex() {
        // TODO: Implement method
    }

    @Override
    public void reindexAll(boolean async) {
        // TODO: Implement method
    }

    @Override
    public void remove(T object) {
        // TODO: Implement method
    }

    @Override
    public void remove(ID id) {
        // TODO: Implement method
    }

    @Override
    public T save(T object) {
        // TODO: Implement method
        return null;
    }

    @Override
    public List<T> search(String searchTerm) throws SearchException {
        // TODO: Implement method
        return null;
    }
}