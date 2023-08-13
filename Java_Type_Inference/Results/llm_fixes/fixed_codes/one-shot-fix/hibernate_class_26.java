import org.hibernate.Session;
import java.util.List;
import org.hibernate.query.Query;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;

public class hibernate_class_26 {
    private SessionFactory sessionFactory;

    public static void main(String[] args){
        hibernate_class_26 d = new hibernate_class_26();
        d.run3();
    }

    public void run3(){
        Session session = getSession();
        session.beginTransaction();
        createEntities(session);
        session.getTransaction().commit();

        System.out.println("NOW WITH A NEW TRANSACTION");
        session = getSession();
        session.beginTransaction();

        Query<A> query = session.createQuery("from A", A.class);
        List<A> results = query.list();
        for (int i=0; i<results.size(); i++){
            System.out.println("Row "+i+" was:");
            A a = results.get(i);
            System.out.println("Result "+i);
            System.out.println(a.toString());
        }

        session.getTransaction().commit();
    }

    public void createEntities(Session session){
        for (int i=0; i<2; i++){
            A a = new A();
            B b = new B();
            a.setB(b);
            session.save(a);
        }
    }

    public Session getSession(){
        if (sessionFactory == null){
            Configuration config = new Configuration();
            config.addAnnotatedClass(A.class);
            config.addAnnotatedClass(B.class);
            config.configure();
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties());
            StandardServiceRegistry registry = registryBuilder.build();
            MetadataSources sources = new MetadataSources(registry)
                .addAnnotatedClass(A.class)
                .addAnnotatedClass(B.class);
            org.hibernate.boot.Metadata metadata = sources.getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        }
        Session session = sessionFactory.getCurrentSession();
        return session;
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

        @OneToOne
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

