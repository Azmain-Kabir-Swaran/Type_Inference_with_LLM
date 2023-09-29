import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "tblPermission")
public class Permission implements Serializable, Cloneable {

    private static final long serialVersionUID = 7155322069731920447L;

    @Id
    @Column(name = "PermissionId", length = 8, nullable = false)
    private String PermissionId = "";

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "CountyId", nullable = false)
    @ForeignKey(name="FK_CountyID")
    private hibernate.County county;

    @Column(name = "Permission", nullable = true)
    private Integer permission = 1;

    @ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE},
          mappedBy = "Permissions",
          targetEntity = hibernate.Item.class )
    private Collection<hibernate.Item> items;

    @ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE},
          mappedBy = "Permissions",
          targetEntity = hibernate.User.class )
    private Collection<hibernate.User> users;

    /** Getters and Setters **/
}