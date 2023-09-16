@Entity
public class HibernateClass28 implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private HibernateUser user;
    
    @OneToMany(targetEntity=HibernateClass28.class)
    @JoinColumn(name="parent_id")
    private List<HibernateClass28> comments = new ArrayList<HibernateClass28>();
    
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

    public HibernateUser getUser() {
        return user;
    }

    public void setUser(HibernateUser user) {
        this.user = user;
    }

    public List<HibernateClass28> getComments() {
        return comments;
    }

    public void setComments(List<HibernateClass28> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "HibernateClass28 [articleId=" + articleId + ", id=" + id + ", text=" + text + "]";
    }
}

@Entity
class HibernateUser implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}