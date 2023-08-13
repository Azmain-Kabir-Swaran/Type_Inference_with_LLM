package hibernate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;

public class hibernate_class_27 {

    private static Session session;

    public static void main(String[] args) {
        List<ProjectAssignment> projectMasters = getAllResources();
        
        for (ProjectAssignment projectMaster : projectMasters) {
            System.out.println(projectMaster.getAid() + " - " + projectMaster.getPid() + " - " + projectMaster.getUserName());
        }
    }

    public static List<ProjectAssignment> getAllResources() {
        List<ProjectAssignment> projectMasters;

        session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
        Query query = session.createQuery("select distinct aid, pid, userName from ProjectAssignment");
        projectMasters = query.list();

        session.close();

        return projectMasters;
    }

    public class ProjectAssignment implements java.io.Serializable {

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