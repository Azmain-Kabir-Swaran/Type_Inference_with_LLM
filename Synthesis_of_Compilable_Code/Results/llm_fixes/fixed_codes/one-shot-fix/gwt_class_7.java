import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.visualizations.Table;
import com.google.gwt.visualization.client.visualizations.Table.Options;
import com.google.gwt.visualization.client.visualizations.Table.ColumnType;

import java.util.ArrayList;

public class gwt_class_7 {
    public class GWTMemoryIssue implements EntryPoint {
        private static final boolean WITH_TABLE = false; 

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
                    GWTMemoryIssue.this.table = new Table(createTableData(), createTableOptions());
                    GWTMemoryIssue.this.table.setSize("100%", "100%");
                    GWTMemoryIssue.this.panel.add(GWTMemoryIssue.this.table);
                    GWTMemoryIssue.this.startUpdateTask();
                }
            };

            com.google.gwt.visualization.client.visualizations.Table.PACKAGE.onModuleLoad();
        }

        private Options createTableOptions() {
            Options options = Table.Options.create();

            return options;
        }

        private DataTable createTableData() {
            DataTable data = DataTable.create();

            data.addColumn(ColumnType.STRING, "Name");
            data.addColumn(ColumnType.NUMBER, "Intval 1");
            data.addColumn(ColumnType.NUMBER, "Intval 2");
            data.addColumn(ColumnType.NUMBER, "Intval 3");

            return data;
        }
    }
}