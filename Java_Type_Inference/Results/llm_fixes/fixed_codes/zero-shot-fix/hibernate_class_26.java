package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.List;

public class hibernate_class_26 {
    private SessionFactory sessionFactory;

    public static void main(String[] args) {
        hibernate_class_26 d = new hibernate_class_26();
        d.run3();
    }

    public void run3() {
        Session session = getSession();
        session.beginTransaction();

        createEntities(session);

        session.getTransaction().commit();

        System.out.println("NOW WITH A NEW TRANSACTION");
        session = getSession();
        session.beginTransaction();

        List<A> results = session.createQuery("from A").list();
        for (int i = 0; i < results.size(); i++) {
            System.out.println("Row " + i + " was:");
            A a = results.get(i);
            System.out.println("Result " + i);
            System.out.println(a.toString());
        }

        session.getTransaction().commit();
    }

    public void createEntities(Session session) {
        for (int i = 0; i < 2; i++) {
            A a = new A();
            B b = new B();
            a.setB(b);
            session.save(a);
        }
    }

    public Session getSession() {
        if (sessionFactory == null) {
            AnnotationConfiguration config = new AnnotationConfiguration();
            config.addAnnotatedClass(A.class);
            config.addAnnotatedClass(B.class);
            config.configure();
            new SchemaExport(config).create(true, true);
            sessionFactory = config.buildSessionFactory();
        }
        return sessionFactory.getCurrentSession();
    }

    @Entity
    public static class A {
        private Integer id;
        private B b;

        public A() {
            super();
        }

        @Id
        @GeneratedValue
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @OneToOne(cascade = javax.persistence.CascadeType.ALL)
        @Cascade(CascadeType.ALL)
        @Fetch(FetchMode.JOIN)
        public B getB() {
            return b;
        }

        public void setB(B b) {
            this.b = b;
        }
    }

    @Entity
    public static class B {
        private Integer id;

        public B() {
            super();
        }

        @Id
        @GeneratedValue
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
}