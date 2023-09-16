import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.*;

public class gwt_class_32 implements EntryPoint {
    public void onModuleLoad() {
        String url = "http://gd.geobytes.com/gd?after=-1&variables=GeobytesCountry,GeobytesCity";
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
        try {
            Request request = builder.sendRequest(null, new RequestCallback() {
                public void onError(Request request, Throwable exception) {
                }

                public void onResponseReceived(Request request, Response response) {
                    GWT.log(response.getText() + "Response");

                    if (200 == response.getStatusCode()) {
                        GWT.log(response.getText());
                    } else {
                        GWT.log(response.getText());
                    }
                }
            });
        } catch (RequestException e) {
            e.printStackTrace();
        }
    }
}