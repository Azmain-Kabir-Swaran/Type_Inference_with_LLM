package gwt;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;

//ID = 2868845

public class gwt_class_40 {
    private HorizontalPanel getSomeGWT() {
        HorizontalPanel pointsLogoPanel = new HorizontalPanel();
        for (int i = 0; i < 350; i++) {
            HorizontalPanel innerContainer = new HorizontalPanel();
            innerContainer.add(new Label("some GWT text"));
            pointsLogoPanel.add(innerContainer);
        }
        return pointsLogoPanel;
    }

    private LayoutPanel getSomeGXT() {
        final LayoutPanel pointsLogoPanel = new LayoutPanel();
        for (int i = 0; i < 350; i++) {
            LayoutPanel innerContainer = new LayoutPanel();
            pointsLogoPanel.add(innerContainer);
        }
        return pointsLogoPanel;
    }
}