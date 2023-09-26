package gwt;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.core.client.util.Margins;

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

    private VerticalLayoutContainer getSomeGXT() {
        VerticalLayoutContainer pointsLogoPanel = new VerticalLayoutContainer();
        pointsLogoPanel.setLayoutOnChange(true);
        for (int i=0; i<350; i++) {
            VerticalLayoutContainer innerContainer = new VerticalLayoutContainer();
            pointsLogoPanel.add(innerContainer, new VerticalLayoutData(1, -1, new Margins(5)));
        }
        return pointsLogoPanel;
    }
}