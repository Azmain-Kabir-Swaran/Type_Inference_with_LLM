package hibernate;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.CascadeType;

@Entity
public class HibernateClass25 {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private B b;

    public HibernateClass25() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    @Entity
    public static class B {

        @Id
        @GeneratedValue
        private Integer id;

        public B() {
            super();
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
}