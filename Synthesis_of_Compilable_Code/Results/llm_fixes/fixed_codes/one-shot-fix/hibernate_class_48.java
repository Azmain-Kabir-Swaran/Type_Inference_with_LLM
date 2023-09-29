import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class hibernate_class_48 {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        List<Book> list = new ArrayList<Book>();
        list.add(new Book("Java", "Author1"));
        list.add(new Book("Python", "Author2"));
        list.add(new Book("C++", "Author3"));

        Iterator<Book> itr = list.iterator();
        while (itr.hasNext()) {
            Book b = itr.next();
            session.save(b);
        }

        t.commit();
        session.close();
        System.out.println("Successfully saved");
    }
}

class Book {
    private int id;
    private String name, author;

    public Book() {
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}