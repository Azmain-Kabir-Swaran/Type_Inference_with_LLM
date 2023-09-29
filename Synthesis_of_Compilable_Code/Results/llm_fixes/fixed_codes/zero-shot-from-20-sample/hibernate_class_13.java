package hibernate;

import org.hibernate.annotations.IndexColumn;

import javax.persistence.OneToMany;
import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.Id;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import java.io.Serializable;
import javax.persistence.FetchType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
import javax.persistence.Index;

@Entity
@Table(name = "tblUser")
public class hibernate_class_13 implements Serializable, Cloneable {

    @Id
    @Column(name = "CountyId", nullable = false)
    private Integer countyId;

    @Id
    @Column(name = "Username", length = 25, nullable = false)
    private String username;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "CountyId", nullable = false, insertable=false, updatable=false)
    @ForeignKey(name="FK_CountyID")
    private hibernate.County county;

    @Column(name = "Name", length = 50, nullable = true)
    private String name;

    @Column(name = "Password", length = 30, nullable = true)
    private String password;

    @Column(name = "Role", nullable = false)
    private Integer role;

    @ManyToMany(targetEntity=hibernate.Permission.class,
         cascade={ CascadeType.PERSIST, CascadeType.MERGE } )
    @JoinTable(name="tblUserPermission",
         joinColumns = { @JoinColumn(name="Username", referencedColumnName="Username"), @JoinColumn(name="CountyId", referencedColumnName="CountyId") },
         inverseJoinColumns = { @JoinColumn(name="PermissionId", referencedColumnName="PermissionId") })
   private Collection<hibernate.Permission> permissions;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="county")
    @IndexColumn(name="version")
    private List<hibernate.Version> versions;

}