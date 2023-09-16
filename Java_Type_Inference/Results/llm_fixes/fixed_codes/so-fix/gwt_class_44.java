import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.dom.client.Style.Unit;

public class GwtClass44 extends ResizeComposite {

    private static GwtClass44 instance = null;

    public static void getInstance(final AsyncCallback<GwtClass44> callback) {
        GWT.runAsync(new com.google.gwt.core.client.RunAsyncCallback() {

            @Override
            public void onSuccess() {
                if (instance == null) {
                    instance = new GwtClass44();
                }
                callback.onSuccess(instance);
            }

            @Override
            public void onFailure(Throwable reason) {
                callback.onFailure(reason);
            }
        });
    }

    private GwtClass44() {
        DockLayoutPanel dockLayoutPanel = new DockLayoutPanel(Unit.EM);
        dockLayoutPanel.addNorth(new Label("North!"), 7);
        dockLayoutPanel.addWest(new Label("West!"), 15);
        dockLayoutPanel.add(new Label("Center! :D"));
        initWidget(dockLayoutPanel);
    }
}