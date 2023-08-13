package hibernate;

import java.util.List;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.CascadeType;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.Column;

@Entity
@Cacheable(true)
public class Part implements Serializable {

    @Id
    private int id;
    
    @Column(name = "PART_NAME")
    private String name;
    
    private static final long serialVersionUID = 1L;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Part mainPart;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "mainPart_id", referencedColumnName = "id")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private List<Part> parts;

    public Part() {
        super();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Part getMainPart() {
        return mainPart;
    }

    public void setMainPart(Part mainPart) {
        this.mainPart = mainPart;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

}