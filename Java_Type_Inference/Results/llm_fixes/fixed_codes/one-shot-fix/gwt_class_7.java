package gwt;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.Selection;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.visualizations.Table;
import com.google.gwt.visualization.client.visualizations.Table.Options;
import java.util.ArrayList;

public class gwt_class_7 {
    public static class GWTMemoryIssue implements EntryPoint {
        //Run with or without table
        private static final boolean WITH_TABLE = false;

        // private final TestServiceAsync rpcService = GWT.create(TestService.class);

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
    }
}