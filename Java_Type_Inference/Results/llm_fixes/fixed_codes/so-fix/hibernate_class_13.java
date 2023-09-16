import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tblUser")
public class HibernateClass13 implements Serializable, Cloneable {

    @Id
    @Column(name = "CountyId", nullable = false)
    private Integer countyId;

    @Id
    @Column(name = "Username", length = 25, nullable = false)
    private String username;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CountyId", referencedColumnName = "CountyId", nullable = false, insertable=false, updatable=false),
        @JoinColumn(name = "Username", referencedColumnName = "Username", nullable = false, insertable=false, updatable=false)
    })
    private County county;

    @Column(name = "Name", length = 50, nullable = true)
    private String name;

    @Column(name = "Password", length = 30, nullable = true)
    private String password;

    @Column(name = "Role", nullable = false)
    private Integer role;

    @ManyToMany(targetEntity=Permission.class,
            cascade={ CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name="tblUserPermission",
            joinColumns = { @JoinColumn(name="CountyId", referencedColumnName = "CountyId"), @JoinColumn(name="Username", referencedColumnName = "Username") },
            inverseJoinColumns = { @JoinColumn(name="PermissionId", referencedColumnName = "PermissionId") })
    private Collection<Permission> permissions;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="county")
    @org.hibernate.annotations.IndexColumn(name="version")
    private List<Version> versions;

    // Getters and setters
}