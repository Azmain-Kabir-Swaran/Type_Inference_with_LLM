package hibernate;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "tblUser")
public class HibernateClass13 implements Serializable, Cloneable {

    @Id
    @Column(name = "CountyId", nullable = false)
    private Integer countyId;

    @Id
    @Column(name = "Username", length = 25, nullable = false)
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CountyId", nullable = false, insertable = false, updatable = false)
    private HibernateClass12.County county;

    @Column(name = "Name", length = 50, nullable = true)
    private String name;

    @Column(name = "Password", length = 30, nullable = true)
    private String password;

    @Column(name = "Role", nullable = false)
    private Integer role;

    @ManyToMany(targetEntity = HibernateClass10.Permission.class, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "tblUserPermission", joinColumns = {
            @JoinColumn(name = "Username", referencedColumnName = "Username"),
            @JoinColumn(name = "CountyId", referencedColumnName = "CountyId") }, inverseJoinColumns = {
                    @JoinColumn(name = "PermissionId", referencedColumnName = "PermissionId") })
    private Collection<HibernateClass10.Permission> permissions;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "county")
    private List<HibernateClass10.Version> versions;

    /** Getters and setters **/
}