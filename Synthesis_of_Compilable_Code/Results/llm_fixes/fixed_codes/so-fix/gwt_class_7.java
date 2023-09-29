import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.visualization.client.visualizations.Table;
import com.google.gwt.visualization.client.visualizations.Table.Options;

public class gwt_class_7 {
    public class GWTMemoryIssue implements EntryPoint {
        //Run with or without table
        private static final boolean WITH_TABLE = false;

//		private final TestServiceAsync rpcService = GWT.create(TestService.class);

        private Panel panel;
        private Timer timer;
        private Table table;

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

        private void startUpdateTask() {
            this.timer = new Timer() {

                public void run() {
//		            GWTMemoryIssue.this.getTableData();

                }
            };
            this.timer.scheduleRepeating(2000);
        }

        public void loadTable() {
            Runnable onLoadCallback = new Runnable() {
                public void run() {
//		            GWTMemoryIssue.this.table = new Table(createTableData(), createTableOptions());
                    GWTMemoryIssue.this.table.setSize("100%", "100%");
                    GWTMemoryIssue.this.panel.add(GWTMemoryIssue.this.table);
                    GWTMemoryIssue.this.startUpdateTask();
                }
            };

//		    VisualizationUtils.loadVisualizationApi(onLoadCallback, Table.PACKAGE);
        }

        private Options createTableOptions() {
            Options options = new Table.Options();

            return options;
        }
