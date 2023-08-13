package hibernate;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "tblPermission")
public class Permission implements Serializable, Cloneable {

    private static final long serialVersionUID = 7155322069731920447L;

    @Id
    @Column(name = "PermissionId", length = 8, nullable = false)
    private String permissionId = "";

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "CountyId", nullable = false)
    private County county;

    @Column(name = "Permission", nullable = true)
    private Integer permission = 1;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
        name = "PermissionItem",
        joinColumns = @JoinColumn(name = "PermissionId"),
        inverseJoinColumns = @JoinColumn(name = "ItemId")
    )
    private Collection<Item> items;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
        name = "PermissionUser",
        joinColumns = @JoinColumn(name = "PermissionId"),
        inverseJoinColumns = @JoinColumn(name = "UserId")
    )
    private Collection<User> users;

    // Getters and Setters
}

// County.java
package hibernate;

import javax.persistence.Entity;

@Entity
class County {
  // County class implementation
}

// Item.java
package hibernate;

import javax.persistence.Entity;

@Entity
class Item {
  // Item class implementation
}

// User.java
package hibernate;

import javax.persistence.Entity;

@Entity
class User {
  // User class implementation
}