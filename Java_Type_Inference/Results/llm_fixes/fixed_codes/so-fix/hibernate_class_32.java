import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Index;

@Entity
@Table(name="log_entries",
    indexes = { @Index(name="idx", columnList = "job, version, schedule, dttmRun, pid" ) } )
public class HibernateClass32 {
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String job;
  private String version;
  private String schedule;
  private String dttmRun;
  private int pid;
  private String command;
  private int duration;

  // getters and setters...
}