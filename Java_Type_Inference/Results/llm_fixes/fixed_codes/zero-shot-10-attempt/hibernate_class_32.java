import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Column;

@Entity
@Table(name="log_entries",
    indexes = { @Index(name="idx", columnList = "job, version, schedule, dttmRun, pid" ) } )
public class hibernate_class_32 {
  @Id @GeneratedValue
  Long id;
  @Column
  String job;
  @Column
  String version;
  @Column
  String schedule;
  @Column
  String dttmRun;
  @Column
  int pid;
  @Column
  String command;
  @Column
  int duration;

  // getters and setters...
}