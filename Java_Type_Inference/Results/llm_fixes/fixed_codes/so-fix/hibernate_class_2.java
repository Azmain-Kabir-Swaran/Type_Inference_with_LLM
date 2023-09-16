import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

public class hibernate_class_2 {
    /**
     * Entity implementation class for Entity: Part
     * 
     */
    @Entity
    @Cacheable
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    public class Part implements Serializable {

        private static final long serialVersionUID = 1L;
        
        @Id
        private int id;
        
        @Column(name = "PART_NAME")
        private String name;
        
        @ManyToOne(cascade = javax.persistence.CascadeType.ALL)
        private Part mainPart;
        
        @OneToMany(cascade = javax.persistence.CascadeType.ALL)
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
}