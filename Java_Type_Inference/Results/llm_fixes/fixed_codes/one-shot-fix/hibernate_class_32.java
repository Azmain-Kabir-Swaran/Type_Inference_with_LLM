import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Indexes;

@Entity
@Table(name = "log_entries", 
       indexes = { @Index(name = "idx", columnList = "job, version, schedule, dttmRun, pid") })
public class HibernateClass32 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    @Column(name = "job")
    private String job;
  
    @Column(name = "version")
    private String version;
  
    @Column(name = "schedule")
    private String schedule;
  
    @Column(name = "dttmRun")
    private String dttmRun;
  
    @Column(name = "pid")
    private int pid;
  
    @Column(name = "command")
    private String command;
  
    @Column(name = "duration")
    private int duration;

    // getters and setters...
}