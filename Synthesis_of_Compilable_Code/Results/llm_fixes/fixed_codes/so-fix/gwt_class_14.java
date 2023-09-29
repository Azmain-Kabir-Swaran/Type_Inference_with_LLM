import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;

public class gwt_class_14 implements EntryPoint {
    public void onModuleLoad() {
        RequestBuilder rb = new RequestBuilder(RequestBuilder.GET, "http://myweb.com/test.php?id=65472");
        try {
            rb.sendRequest(null, new RequestCallback() {
                public void onError(final Request request, final Throwable exception) {
                    Window.alert(exception.getMessage());
                }

                public void onResponseReceived(final Request request, final Response response) {
                    //do something
                    GWT.log("response: (" + response.getText() + ")", null);
                }
            });
        } catch (final Exception e) {
            Window.alert(e.getMessage());
        }
    }
}