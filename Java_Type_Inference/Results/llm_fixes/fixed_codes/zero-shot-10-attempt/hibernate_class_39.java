package hibernate;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.search.exception.SearchException;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.apache.lucene.search.Query;
import org.hibernate.search.query.FullTextQuery;
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
            final Session session = sessionFactory.openSession();
            final Transaction tx = session.beginTransaction();
            try {
                final FullTextSession fullTextSession = Search.getFullTextSession(session);
                final QueryBuilder qb = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(T.class).get();
                final Query luceneQuery = qb.keyword().onFields("field1", "field2").matching(arg0).createQuery();
                final FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery, T.class);
                final List<T> result = fullTextQuery.list();
                tx.commit();
                session.close();
                return result;
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
            return null;
        }
    }
}