import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.Timer;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class gwt_class_7 implements EntryPoint {

    private static final boolean WITH_TABLE = false;

    private Panel panel;
    private Timer timer;

    public void onModuleLoad() {
        RootPanel rootPanel = RootPanel.get();

        this.panel = new VerticalPanel();
        this.panel.setSize("100%", "100%");

        rootPanel.add(panel);

        if (WITH_TABLE) {
            loadTable();
        } else {
            startUpdateTask();
        }
    }
    
    private void loadTable() {
        // Load table code here
    }
    
    private void startUpdateTask() {
        // Update task code here
    }
}