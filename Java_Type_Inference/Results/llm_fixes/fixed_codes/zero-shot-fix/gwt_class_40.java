package gwt;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
// ID = 2868845
// You need to import the correct LayoutContainer class from the correct package
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FlowPanel;

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

    private Widget getSomeGXT() {
        FlowPanel pointsLogoPanel = new FlowPanel();
        for (int i = 0; i < 350; i++) {
            FlowPanel innerContainer = new FlowPanel();
            pointsLogoPanel.add(innerContainer);
        }
        return pointsLogoPanel;
    }
}