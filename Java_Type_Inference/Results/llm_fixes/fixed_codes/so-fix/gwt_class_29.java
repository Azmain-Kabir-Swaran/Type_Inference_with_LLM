import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Window;

public class gwt_class_29 implements EntryPoint {
    private static final String SERVER_URL = "https://www.google.com/calendar/feeds/developer-calendar@google.com/public/full?alt=json";
    
    public void onModuleLoad() {
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, SERVER_URL);
        try {
            requestBuilder.sendRequest(null, new Jazz10RequestCallback());
        } catch (Exception e) {
            Window.alert("Failed to send the request: " + e.getMessage());
        }
    }

    class Jazz10RequestCallback implements RequestCallback {
        @Override
        public void onResponseReceived(Request request, Response response) {
            if (response.getStatusCode() == 200) {
                String responseText = response.getText();
                Window.alert(responseText);
            } else {
                Window.alert("Error with status code: " + response.getStatusCode());
            }
        }

        @Override
        public void onError(Request request, Throwable throwable) {
            Window.alert("An error occurred while sending the request: " + throwable.getMessage());
        }
    }
}