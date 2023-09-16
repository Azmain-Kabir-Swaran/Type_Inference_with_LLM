import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.http.client.*;
import com.google.gwt.user.client.Window;

public class gwt_class_42 implements EntryPoint {

    String url = "http://localhost/phpmyadmin/tesdb3/datauser.php";

    public void LoadData() throws RequestException {

        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);

        builder.sendRequest(null, new RequestCallback() {
            @Override
            public void onError(Request request, Throwable exception) {
                Window.alert("error " + exception);
            }

            public void onResponseReceived(Request request,
                                           Response response) {
                if (Response.SC_OK == response.getStatusCode()) {
                    Window.alert("ok -" + response.getText() + "-" + response.getStatusCode());
                } else {
                    Window.alert("error2 -" + response.getText() + response.getStatusText() + "-" + response.getStatusCode());
                }
            }
        });
    }

    public void onModuleLoad() {
        try {
            LoadData();
        } catch (RequestException e) {
            e.printStackTrace();
        }
    }
}