import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class hibernate_class_11 {

    @Entity
    @Table(name = "User")
    public static class User implements Serializable {

        private static final long serialVersionUID = 2209767646758652729L;

        @Id
        @Column(name="id", nullable = false)
        private Integer id;

        @Column(name="name", length = 200, nullable = true)
        private String name;

        /* Getters, Setters, toString, equals & hashCode */
    }
}