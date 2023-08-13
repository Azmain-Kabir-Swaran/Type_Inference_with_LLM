package hibernate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Column;

@Entity
@Table(name = "User")
public class User implements Serializable {

    private static final long serialVersionUID = 2209767646758652729L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer id;

    @Column(name="name", length = 200, nullable = true)
    private String name;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "groupId", nullable = false, insertable=false, updatable=false)
    private UserGroup userGroup;

    /* Getters, Setters, toString, equals & hashCode */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", userGroup=" + userGroup + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return id == other.id && name.equals(other.name) && userGroup.equals(other.userGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userGroup);
    }
}