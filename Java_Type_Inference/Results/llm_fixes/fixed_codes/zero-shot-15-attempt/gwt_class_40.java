import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.widget.core.client.container.FlowLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;

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

    private FlowLayoutContainer getSomeGXT() {
        FlowLayoutContainer pointsLogoPanel = new FlowLayoutContainer();
        pointsLogoPanel.setLayoutOnChange(true);
        for (int i = 0; i < 350; i++) {
            HorizontalLayoutContainer innerContainer = new HorizontalLayoutContainer();
            pointsLogoPanel.add(innerContainer);
        }
        return pointsLogoPanel;
    }
}