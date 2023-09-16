import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalBase64;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class xstream_class_8 extends Activity {

    private String METHOD_NAME = "getName";
    private String NAMESPACE = "http://webservice.app";
    private String SOAP_ACTION = "http://webservice.app/getName";
    public TextView t;

    private static String URL = "http://ip/WS/services/Service?wsdl";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        request.addProperty("user", "user");
        request.addProperty("passwort", "passwort");

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.bodyOut = request;
        envelope.encodingStyle = SoapEnvelope.ENC;
        envelope.setOutputSoapObject(request);
        (new MarshalBase64()).register(envelope);

        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
        androidHttpTransport.debug = true;

        try {
            androidHttpTransport.call(SOAP_ACTION, envelope);
            SoapObject result = (SoapObject) envelope.getResponse();
            if (result != null) {
                XStream xstream = new XStream(new DomDriver());
                String text = xstream.toXML(result.getProperty(0));
            }
        } catch (Exception e) {
            t.setText("FEHLER");
        }
    }
}