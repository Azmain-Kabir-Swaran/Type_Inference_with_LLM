package gwt;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GwtClass29 implements EntryPoint {
    private static final String SERVER_URL = "http://www.google.com/calendar/feeds/developer-calendar@google.com/public/full?alt=json-in-script&callback=insertAgenda&orderby=starttime&max-results=15&singleevents=true&sortorder=ascending&futureevents=true";
    private static final String SERVER_ERROR = "An error occurred while attempting to contact the server. Please check your network connection and try again.";

    public void onModuleLoad() {
        JsonpRequestBuilder requestBuilder = new JsonpRequestBuilder();
        requestBuilder.requestObject(SERVER_URL, new Jazz10RequestCallback());
    }

    static class Jazz10RequestCallback implements AsyncCallback<JsArray<Article>> {

        @Override
        public void onFailure(Throwable caught) {
            Window.alert("Failed to send the message: " + caught.getMessage());
        }

        @Override
        public void onSuccess(JsArray<Article> result) {
            for (int i = 0; i < result.length(); i++) {
                Window.alert(result.get(i).toString());
            }
        }
    }

    public static class Article extends JavaScriptObject {

        protected Article() {}

        // ... getter methods ...

        public final native String getTitle() /*-{ return this.title.$t; }-*/;
        public final native String getContent() /*-{ return this.content.$t; }-*/;
    }
}