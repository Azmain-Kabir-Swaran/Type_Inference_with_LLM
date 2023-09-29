package gwt;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.SimplePanel;

public class gwt_class_7 {
    public class GWTMemoryIssue implements EntryPoint {
        //Run with or without table
        private static final boolean WITH_TABLE = false;

        private Panel panel;
        private Timer timer;
        private SimplePanel table;

        public void onModuleLoad() {
            RootPanel rootPanel = RootPanel.get();

            this.panel = new VerticalPanel();
            this.panel.setSize("100%", "100%");

            rootPanel.add(panel);

            if (WITH_TABLE) {
                loadTable();
            }else{
                startUpdateTask();
            }

        }

        private void startUpdateTask() {
            this.timer = new Timer() {

                public void run() {
                }
            };
            this.timer.scheduleRepeating(2000);
        }

        public void loadTable() {
            Runnable onLoadCallback = new Runnable() {
                public void run() {
                    GWTMemoryIssue.this.table = new SimplePanel();
                    GWTMemoryIssue.this.table.setSize("100%", "100%");
                    GWTMemoryIssue.this.panel.add(GWTMemoryIssue.this.table);
                    GWTMemoryIssue.this.startUpdateTask();
                }
            };

        }

    }
}