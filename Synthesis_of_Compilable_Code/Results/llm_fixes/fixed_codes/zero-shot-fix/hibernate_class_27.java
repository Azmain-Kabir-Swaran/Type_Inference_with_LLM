import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import com.example.hibernate.HibernateUtil;
import com.example.hibernate.ProjectAssignment;

public class hibernate_class_27 {

    public static List<ProjectAssignment> getAllResources() {
        List<ProjectAssignment> projectMasters;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select distinct aid, pid, userName from ProjectAssignment");
        projectMasters = (List<ProjectAssignment>) query.list();
        session.close();

        return projectMasters;
    }
}