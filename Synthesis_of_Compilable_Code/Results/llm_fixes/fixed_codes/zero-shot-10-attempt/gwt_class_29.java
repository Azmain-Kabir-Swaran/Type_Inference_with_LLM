package gwt;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class gwt_class_29 implements EntryPoint {
    // private static final String SERVER_URL = "http://localhost:8094/data/view/";
    private static final String SERVER_URL = "http://www.google.com/calendar/feeds/developer-calendar@google.com/public/full?alt=json-in-script&callback=insertAgenda&orderby=starttime&max-results=15&singleevents=true&sortorder=ascending&futureevents=true";
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        JsonpRequestBuilder requestBuilder = new JsonpRequestBuilder();
        try {
            requestBuilder.requestObject(SERVER_URL, new Jazz10RequestCallback());
        } catch (com.google.gwt.http.client.RequestException e) {
            Window.alert("Failed to send the message: " + e.getMessage());
        }
    }

    class Jazz10RequestCallback implements RequestCallback {
        @Override
        public void onResponseReceived(Request request, Response response) {
            Window.alert(response.getText());
        }

        @Override
        public void onError(Request request, Throwable exception) {
            Window.alert("Failed to send the message: " + exception.getMessage());
        }
    }
}