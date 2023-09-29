import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.Id;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import javax.persistence.FetchType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

import javax.persistence.JoinTable;

//ID = 1483026

public class hibernate_class_14 {
    @Entity
    @Table(name = "tblPermission")
    public class Permission implements Serializable, Cloneable {

        private static final long serialVersionUID = 7155322069731920447L;

        @Id
        @Column(name = "PermissionId", length = 8, nullable = false)
        private String PermissionId = "";

        @ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name = "CountyId", nullable = false, foreignKey = @ForeignKey(name="FK_CountyID"))
//      private County county;

        @Column(name = "Permission", nullable = true)
        private Integer permission = 1;

        @ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE},
              mappedBy = "Permissions",
              targetEntity = hibernate_class_14.Item.class )
        private Collection<hibernate_class_14.Item> items;

        @ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE},
              mappedBy = "Permissions",
              targetEntity = hibernate_class_14.User.class )
        private Collection<hibernate_class_14.User> users;

        /** Getters and Setters **/
    }

    @Entity
    @Table(name = "tblItem")
    public class Item implements Serializable, Cloneable {

        private static final long serialVersionUID = 7155322069731920447L;

        @Id
        @Column(name = "ItemId", length = 8, nullable = false)
        private String ItemId = "";

        @ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE},
              targetEntity = hibernate_class_14.Permission.class )
        @JoinTable(name="tblPermissionItem", 
          joinColumns=@JoinColumn(name="ItemId"),
          inverseJoinColumns=@JoinColumn(name="PermissionId")
        )
        private Collection<hibernate_class_14.Permission> Permissions;

        /** Getters and Setters **/
    }

    @Entity
    @Table(name = "tblUser")
    public class User implements Serializable, Cloneable {

        private static final long serialVersionUID = 7155322069731920447L;

        @Id
        @Column(name = "UserId", length = 8, nullable = false)
        private String UserId = "";

        @ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE},
              targetEntity = hibernate_class_14.Permission.class )
        @JoinTable(name="tblPermissionUser", 
          joinColumns=@JoinColumn(name="UserId"),
          inverseJoinColumns=@JoinColumn(name="PermissionId")
        )
        private Collection<hibernate_class_14.Permission> Permissions;

        /** Getters and Setters **/
    }
}