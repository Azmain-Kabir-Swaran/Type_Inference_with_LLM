package hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import java.util.List;
import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;

public class hibernate_class_40 {


    public static void main(String[] args) {

        Session session = null;

        try{

            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();

            System.out.println("selecting records");
            Query q = session.getNamedQuery("getRecordsSP");

            System.out.print("Done");
            List l = q.list();


            for(Iterator it = l.iterator() ;it.hasNext();){
                Object[] row = (Object[]) it.next();
                System.out.println(row.length);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            session.flush();
            session.close();

        }
    }
}