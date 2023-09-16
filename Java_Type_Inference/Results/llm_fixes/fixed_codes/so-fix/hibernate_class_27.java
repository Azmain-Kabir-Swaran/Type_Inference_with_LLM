import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class hibernate_class_27 {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            System.err.println("Initial SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static List<ProjectAssignment> getAllResources() {
        List<ProjectAssignment> projectMasters;

        try (Session session = sessionFactory.openSession()) {
            Query<ProjectAssignment> query = session.createQuery("select distinct new hibernate_class_27.ProjectAssignment(aid, pid, userName) from ProjectAssignment", ProjectAssignment.class);
            projectMasters = query.getResultList();
        }

        return projectMasters;
    }

    public static class ProjectAssignment implements java.io.Serializable {
        private short aid;
        private String pid;
        private String userName;

        public ProjectAssignment() {
        }

        public ProjectAssignment(short aid) {
            this.aid = aid;
        }

        public ProjectAssignment(short aid, String pid, String userName) {
            this.aid = aid;
            this.pid = pid;
            this.userName = userName;
        }

        public short getAid() {
            return this.aid;
        }

        public void setAid(short aid) {
            this.aid = aid;
        }

        public String getPid() {
            return this.pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getUserName() {
            return this.userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}