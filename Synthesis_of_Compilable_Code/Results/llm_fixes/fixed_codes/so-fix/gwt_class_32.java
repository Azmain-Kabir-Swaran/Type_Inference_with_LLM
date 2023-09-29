import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;

public class gwt_class_32 implements EntryPoint {
    public void onModuleLoad() {
        String url = "http: gd.geobytes.com/gd?after=-1&variables=GeobytesCountry,GeobytesCity";
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
        try {
            Request request = builder.sendRequest(null, new RequestCallback() {
                public void onError(Request request, Throwable exception) {
                }

                public void onResponseReceived(Request request, Response response) {
                    System.out.println(response.getText() + "Response");

                    if (200 == response.getStatusCode()) {
                        Window.alert(response.getText());
                    } else {
                        Window.alert(response.getText());
                    }
                }
            });
        } catch (RequestException e) {
            e.printStackTrace();
        }
    }
}