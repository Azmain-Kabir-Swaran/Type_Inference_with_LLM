package hibernate;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

public class hibernate_class_39 {
    @Transactional
    @SuppressWarnings("unchecked")
    public class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {
        private SessionFactory sessionFactory;

        public void setSessionFactory(final SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }
    }

    public interface GenericDao<T, ID extends Serializable> {
        // Add any necessary methods here
    }
}