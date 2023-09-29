import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;

public class gwt_class_31 {
    public static void main(String arg[]) throws com.google.gwt.http.client.RequestException {
        String serverUrl = null;
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST, URL.encode(serverUrl));
        requestBuilder.setHeader("Content-Type", "application/x-www-form-urlencoded");
        requestBuilder.setHeader("Expires", "0");
        String postData = null;
        requestBuilder.sendRequest(postData, new RequestCallback() {
            public void onError(Request request, Throwable exception) {
                //Do nothing
            }

            public void onResponseReceived(Request request, Response response) {
                //sometimes when the server is restarted, I get response.getStatusCode() = 304 and the response.getText() as blank
            }
        });
    }
}