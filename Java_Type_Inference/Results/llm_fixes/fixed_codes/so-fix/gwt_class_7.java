import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class gwt_class_7 implements EntryPoint {

    private static final boolean WITH_TABLE = false;

    private Panel panel;
    private Timer timer;

    public void onModuleLoad() {
        RootPanel rootPanel = RootPanel.get();

        this.panel = new VerticalPanel();
        this.panel.setSize("100%", "100%");

        rootPanel.add(panel);

        if (!WITH_TABLE) {
            startUpdateTask();
        }
    }

    private void startUpdateTask() {
        this.timer = new Timer() {
            public void run() {
                // GWTMemoryIssue.this.getTableData();
            }
        };
        this.timer.scheduleRepeating(2000);
    }
}