import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

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

    private HorizontalPanel getSomeGXT() {
        HorizontalPanel pointsLogoPanel = new HorizontalPanel();
        for (int i=0; i<350; i++) {
            HorizontalPanel innerContainer = new HorizontalPanel();
            pointsLogoPanel.add(innerContainer);
        }
        return pointsLogoPanel;
    }
}