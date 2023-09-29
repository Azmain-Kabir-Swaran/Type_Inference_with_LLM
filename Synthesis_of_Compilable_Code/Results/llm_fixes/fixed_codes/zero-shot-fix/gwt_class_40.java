package gwt;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;

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

    private SimpleContainer getSomeGXT() {
        SimpleContainer pointsLogoPanel = new VerticalLayoutContainer();
        pointsLogoPanel.setLayoutOnChange(true);
        for (int i=0; i<350; i++) {
            SimpleContainer innerContainer = new SimpleContainer();
            pointsLogoPanel.add(innerContainer);
        }
        return pointsLogoPanel;
    }
}