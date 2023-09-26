import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;

public class xstream_class_38 {
    XStream xstream = new XStream();
    @XStreamAlias("bookdetails")
    public class BookDetails
    {
        private int bookId;
        private String bookName;
        private int amount;
    }

    @XStreamAlias("Books")
    public class Books
    {
        private List<BookDetails> bookDetails = new ArrayList<BookDetails>();
    }

    public BookDetails convertXml(String xml)
    {
        xstream.processAnnotations(Books.class);
        xstream.processAnnotations(BookDetails.class);
        xstream.addImplicitCollection(Books.class, "bookDetails");
        Books b = (Books) xstream.fromXML(xml);
        return b.bookDetails.get(0);
    }
}