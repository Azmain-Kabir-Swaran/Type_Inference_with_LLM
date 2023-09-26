package gwt;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.jsonp.client.JsonpResponse;
import com.google.gwt.user.client.Window;

import com.google.gwt.http.client.RequestException;

public class gwt_class_29 {
    private static final String SERVER_URL = "http://www.google.com/calendar/feeds/developer-calendar@google.com/public/full?alt=json-in-script&callback=insertAgenda&orderby=starttime&max-results=15&singleevents=true&sortorder=ascending&futureevents=true";
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";

    public void onModuleLoad() {
        JsonpRequestBuilder requestBuilder = new JsonpRequestBuilder();
        try {
            requestBuilder.requestObject(SERVER_URL, new Jazz10RequestCallback());
        } catch (RequestException e) {
            Window.alert(SERVER_ERROR);
        }
    }

    class Jazz10RequestCallback implements AsyncCallback<JsonpResponse> {
        @Override
        public void onFailure(Throwable caught) {
            Window.alert("Failed to send the message: " + caught.getMessage());
        }

        @Override
        public void onSuccess(JsonpResponse result) {
            Window.alert(result.toString());
        }
    }
}