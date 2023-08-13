package hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Table;

@Entity
@Table(name = "tblPermission")
public class Permission implements Serializable, Cloneable {

    private static final long serialVersionUID = 7155322069731920447L;

    @Id
    @Column(name = "PermissionId", length = 8, nullable = false)
    private String permissionId = "";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CountyId", nullable = false)
    private County county;

    @Column(name = "Permission", nullable = true)
    private Integer permission = 1;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Item> items;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<User> users;

    /** Getters and Setters **/
}

@Entity
@Table(name = "tblCounty")
class County {

}

@Entity
@Table(name = "tblItem")
class Item {

}

@Entity
@Table(name = "tblUser")
class User {

}