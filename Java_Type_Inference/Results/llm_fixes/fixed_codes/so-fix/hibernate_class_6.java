import java.io.File;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateClass6 {

    public static void main(final String[] args) throws MalformedURLException {
        File baseDir = new File("C:\\workspaces\\hobby");
        HibernateClass6 importer = new HibernateClass6();
        Configuration config = importer.setupDb(baseDir);

        if (config != null) {
            importer.importContents(new File(baseDir, "people.xml"), config);
        }
    }

    private void importContents(final File file, final Configuration config) throws MalformedURLException {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = config.buildSessionFactory(registry);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(file);

            List<?> list = document.selectNodes("//Person");
            Iterator<?> iter = list.iterator();

            while (iter.hasNext()) {
                Object personObj = iter.next();
                session.save(personObj);
            }

            session.flush();
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private Configuration setupDb(final File baseDir) throws HibernateException {
        Configuration cfg = new Configuration();
        cfg.configure(new File(baseDir, "hibernate.cfg.xml"));
        cfg.addFile(new File(baseDir, "name/seller/rich/hobby/Person.hbm.xml"));
        cfg.addFile(new File(baseDir, "name/seller/rich/hobby/Hobby.hbm.xml"));

        SchemaExport export = new SchemaExport(cfg);
        export.setOutputFile("hobbyDB.txt");
        export.execute(false, true, false, false);

        return cfg;
    }
}