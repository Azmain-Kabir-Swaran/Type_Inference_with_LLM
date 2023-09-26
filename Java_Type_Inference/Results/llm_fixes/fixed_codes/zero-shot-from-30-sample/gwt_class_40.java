package gwt;

import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;

public class gwt_class_40 {
    private HorizontalLayoutContainer getSomeGWT() {
        HorizontalLayoutContainer pointsLogoPanel = new HorizontalLayoutContainer();
        for (int i=0; i<350; i++) {
            HorizontalLayoutContainer innerContainer = new HorizontalLayoutContainer();
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
            pointsLogoPanel.add(innerContainer);
        }
        return pointsLogoPanel;
    }
}