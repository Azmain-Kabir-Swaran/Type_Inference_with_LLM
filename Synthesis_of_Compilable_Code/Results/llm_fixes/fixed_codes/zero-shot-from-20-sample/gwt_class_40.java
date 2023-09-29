package gwt;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.LayoutContainer;

public class gwt_class_40 {
    private HorizontalPanel getSomeGWT() {
        HorizontalPanel pointsLogoPanel = new HorizontalPanel();
        for (int i=0; i<350; i++) {
            HorizontalPanel innerContainer = new HorizontalPanel();
            innerContainer.add(new Label("some GWT text"));
            pointsLogoPanel.add(innerContainer);
        }
        return pointsLogoPanel;
    }

    private LayoutContainer getSomeGXT() {
        LayoutContainer pointsLogoPanel = new HorizontalLayoutContainer();
        pointsLogoPanel.setLayoutOnChange(true);
        for (int i=0; i<350; i++) {
            LayoutContainer innerContainer = new HorizontalLayoutContainer();
            pointsLogoPanel.add(innerContainer);
        }
        return pointsLogoPanel;
    }
}