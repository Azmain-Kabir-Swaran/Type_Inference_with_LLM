import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.widget.core.client.container.FlowLayoutContainer;
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
        LayoutContainer pointsLogoPanel = new LayoutContainer();
        pointsLogoPanel.setLayoutOnChange(true);
        for (int i=0; i<350; i++) {
            LayoutContainer innerContainer = new LayoutContainer();
            pointsLogoPanel.add(innerContainer);
        }
        return pointsLogoPanel;
    }

    private FlowLayoutContainer getSomeGXTWithFlowLayout() {
        FlowLayoutContainer pointsLogoPanel = new FlowLayoutContainer();
        pointsLogoPanel.setLayoutOnChange(true);
        for (int i=0; i<350; i++) {
            FlowLayoutContainer innerContainer = new FlowLayoutContainer();
            pointsLogoPanel.add(innerContainer);
        }
        return pointsLogoPanel;
    }
}