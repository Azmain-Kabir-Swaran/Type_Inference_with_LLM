import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsonpRequestBuilder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.json.client.JSONObject;

public class gwt_class_29 implements EntryPoint {
    // private static final String SERVER_URL = "http://localhost:8094/data/view/";
    private static final String SERVER_URL = "http://www.google.com/calendar/feeds/developer-calendar@google.com/public/full?alt=json-in-script&callback=insertAgenda&orderby=starttime&max-results=15&singleevents=true&sortorder=ascending&futureevents=true";
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";

    public void onModuleLoad() {
        JsonpRequestBuilder requestBuilder = new JsonpRequestBuilder();
        // requestBuilder.setTimeout(10000);
        requestBuilder.requestObject(SERVER_URL, new Jazz10RequestCallback());
    }

    class Jazz10RequestCallback implements AsyncCallback<JSONObject> {

        @Override
        public void onFailure(Throwable caught) {
            Window.alert("Failed to send the message: " + caught.getMessage());
        }

        @Override
        public void onSuccess(JSONObject result) {
            Window.alert(result.toString());
        }
    }
}