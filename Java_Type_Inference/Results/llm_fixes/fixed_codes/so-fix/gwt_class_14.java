import com.google.gwt.http.client.*;
import com.google.gwt.core.client.*;
import com.google.gwt.user.client.Window;

public class gwt_class_14 implements EntryPoint {
    public void onModuleLoad() {
        RequestBuilder rb = new RequestBuilder(RequestBuilder.GET, "http://myweb.com/test.php?id=65472");
        try {
            rb.sendRequest(null, new RequestCallback() {
                public void onError(Request request, Throwable exception) {
                    Window.alert(exception.getMessage());
                }

                public void onResponseReceived(Request request, Response response) {
                    // do something
                    GWT.log("response: (" + response.getText() + ")", null);
                }
            });
        } catch (final Exception e) {
            Window.alert(e.getMessage());
        }
    }
}