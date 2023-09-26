package hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.ForeignKey;
import java.io.Serializable;

@Entity
@Table(name = "User")
public class User implements Serializable {

    private static final long serialVersionUID = 2209767646758652729L;

    @Id
    @Column(name="id", nullable = false)
    private Integer id;

    @Column(name="name", length = 200, nullable = true)
    private String name;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "groupId", nullable = false, insertable=false, updatable=false)
    @ForeignKey(name="FK_GroupId")
    private hibernate.UserGroup userGroup;

    /* Getters, Setters, toString, equals & hashCode */
}