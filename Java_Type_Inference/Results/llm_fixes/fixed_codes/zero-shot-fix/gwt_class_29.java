package gwt;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;

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
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, SERVER_URL);
        try {
            requestBuilder.sendRequest(null, new Jazz10RequestCallback());
        } catch (RequestException e) {
            Window.alert(SERVER_ERROR);
        }
    }

    class Jazz10RequestCallback implements RequestCallback {

        @Override
        public void onResponseReceived(Request request, Response response) {
            if (response.getStatusCode() == 200) {
                Window.alert(response.getText());
            } else {
                Window.alert(SERVER_ERROR);
            }
        }

        @Override
        public void onError(Request request, Throwable exception) {
            Window.alert(SERVER_ERROR);
        }
    }
}