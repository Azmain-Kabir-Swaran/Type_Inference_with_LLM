import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import java.io.Serializable;
import java.util.Collection;

public class hibernate_class_14 {
    @Entity
    @Table(name = "tblPermission")
    public class Permission implements Serializable, Cloneable {

        private static final long serialVersionUID = 7155322069731920447L;

        @Id
        @Column(name = "PermissionId", length = 8, nullable = false)
        private String PermissionId = "";

        @ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name = "CountyId", nullable = false)
        private County county;

        @Column(name = "Permission", nullable = true)
        private Integer permission = 1;

        @ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE},
                mappedBy = "Permissions",
                targetEntity = Item.class )
        @JoinTable(name = "tblPermission_Item",
                joinColumns = @JoinColumn(name = "PermissionId", referencedColumnName = "PermissionId"),
                inverseJoinColumns = @JoinColumn(name = "ItemId", referencedColumnName = "ItemId"))
        private Collection<Item> items;

        @ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE},
                mappedBy = "Permissions",
                targetEntity = User.class )
        @JoinTable(name = "tblPermission_User",
                joinColumns = @JoinColumn(name = "PermissionId", referencedColumnName = "PermissionId"),
                inverseJoinColumns = @JoinColumn(name = "UserId", referencedColumnName = "UserId"))
        private Collection<User> users;

        /** Getters and Setters **/
    }

}

class County {
    // County implementation
}

class Item {
    // Item implementation
}

class User {
    // User implementation
}