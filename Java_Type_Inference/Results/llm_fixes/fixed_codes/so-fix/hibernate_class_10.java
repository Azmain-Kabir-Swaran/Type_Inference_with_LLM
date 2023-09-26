import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;

public class hibernate_class_10 implements Serializable {
    private String providerId;
    private String providerName;

    private static final long serialVersionUID = 81073;

    public static void load(Session session, List<String> values){
        hibernate_class_10 ProviderInfo = new hibernate_class_10(); 

        ProviderInfo.setProviderId( values.get(0) );
        ProviderInfo.setProviderName( values.get(1));

        session.save( ProviderInfo );
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String name) {
        this.providerName = name;
    }

    public String getProviderId() {
        return this.providerId;
    }

    public void setProviderId( String id ) {
        this.providerId = id;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}