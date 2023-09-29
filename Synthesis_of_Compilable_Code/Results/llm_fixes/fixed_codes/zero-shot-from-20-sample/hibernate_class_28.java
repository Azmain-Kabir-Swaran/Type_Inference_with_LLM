import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class hibernate_class_28 implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name="user_id")
    private hibernate.User user;
    @OneToMany(targetEntity=hibernate_class_28.class)
    @JoinColumn(name="parent_id")
    @org.hibernate.annotations.Index(name="id", columnList="id", base=0)
    private List<hibernate_class_28> comments = new ArrayList<hibernate_class_28>();
    @Column(name="article_id", length=10)
    private int articleId;
    @Column(name="text", length=8192)
    private String text;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public hibernate.User getUser() {
        return user;
    }

    public void setUser(hibernate.User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment [" + "articleId " + articleId + " " + "id " + id + " "  + "text " + text + " " + "]";
    }
}