import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.BeforeSelectionEvent;
import com.google.gwt.event.logical.shared.BeforeSelectionHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.TabBar;

public class GwtClass48 implements EntryPoint {
    @Override
    public void onModuleLoad() {
        TabBar bar = new TabBar();
        bar.addTab("foo");
        bar.addTab("bar");
        bar.addTab("baz");
        bar.addSelectionHandler(new SelectionHandler<Integer>() {
            @Override
            public void onSelection(SelectionEvent<Integer> event) {
                Window.alert("you clicked tab " + event.getSelectedItem());
            }
        });
        bar.addBeforeSelectionHandler(new BeforeSelectionHandler<Integer>() {
            @Override
            public void onBeforeSelection(BeforeSelectionEvent<Integer> event) {
                event.cancel();
            }
        });
    }
}