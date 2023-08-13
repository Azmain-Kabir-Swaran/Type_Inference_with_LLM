package hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "User")
public class User implements Serializable {

    private static final long serialVersionUID = 2209767646758652729L;

    @Id
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "groupId", referencedColumnName = "id", nullable = false)
    private UserGroup userGroup;

    // Getters, Setters, toString, equals & hashCode
}

@Entity
@Table(name = "UserGroup")
class UserGroup implements Serializable {

    private static final long serialVersionUID = 2209767646758652729L;

    @Id
    private Integer id;

    private String groupName;

    // Getters, Setters, toString, equals & hashCode
}