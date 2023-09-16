import java.io.Serializable;
import java.util.List;

public class hibernate_class_9 implements Serializable {
    private int patientId;
    private String patientName;
    private String providerId; // foreign key to provider

    private static final long serialVersionUID = 81073;

    public static void load(org.hibernate.Session session, List<String> values) {
        hibernate_class_9 PatientInfo = new hibernate_class_9();

        PatientInfo.setPatientId(Integer.parseInt(values.get(0)));
        PatientInfo.setPatientName(values.get(1));
        PatientInfo.setProviderId(values.get(2));

        session.save(PatientInfo);
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int PatientId) {
        this.patientId = PatientId;
    }

    public String getPatientName() {
        return this.patientName;
    }

    public void setPatientName(String PatientName) {
        this.patientName = PatientName;
    }

    public String getProviderId() {
        return this.providerId;
    }

    public void setProviderId(String id) {
        this.providerId = id;
    }

    public String getProvider() {
        return this.providerId;
    }

    public void setProvider(String id) {
        this.providerId = id;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}