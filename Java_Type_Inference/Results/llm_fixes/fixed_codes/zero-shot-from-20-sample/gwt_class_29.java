package gwt;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.jsonp.client.JsonpRequestBuilder.JsonpCallback;
import com.google.gwt.user.client.Window;

public class gwt_class_29 {
    private static final String SERVER_URL = "http://www.google.com/calendar/feeds/developer-calendar@google.com/public/full?alt=json-in-script&callback=insertAgenda&orderby=starttime&max-results=15&singleevents=true&sortorder=ascending&futureevents=true";
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";

    public void onModuleLoad() {
        JsonpRequestBuilder requestBuilder = new JsonpRequestBuilder();
        requestBuilder.requestObject(SERVER_URL, new Jazz10RequestCallback());
    }

    class Jazz10RequestCallback implements JsonpCallback<JavaScriptObject> {
        @Override
        public void onFailure(Throwable caught) {
            Window.alert("Failed to send the message: " + caught.getMessage());
        }

        @Override
        public void onSuccess(JavaScriptObject result) {
            Window.alert(result.toString());
        }
    }
}