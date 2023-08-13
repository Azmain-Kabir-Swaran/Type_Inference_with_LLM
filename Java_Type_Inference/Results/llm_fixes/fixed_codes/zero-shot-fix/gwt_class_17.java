package gwt;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.ImageBundle;
import com.google.gwt.user.client.ui.Image;

public class gwt_class_17 extends Composite implements EntryPoint {

    // Data
    private String firstName = null;
    private String lastName = null;
    private String picSquareUrl = null;

    // Elements
    private Image picSquare = new Image();
    private Image logo = new Image();
    private Button logoutButton = new Button("Logout");
    private DockPanel panel = new DockPanel();
    private HTML html = new HTML("Welcome to Sandpit.");

    public gwt_class_17() {

        // Initialize the profile and logo images
        initProfileImage();
        initLogoImage();

        panel.add(picSquare, DockPanel.WEST);
        panel.add(html, DockPanel.CENTER);

        VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.add(logo);
        verticalPanel.add(logoutButton);

        panel.add(verticalPanel, DockPanel.EAST);

        initWidget(panel);
    }

    private void initProfileImage() {
        // Display ajaxLoader.gif
        SandpitImageBundle sib = (SandpitImageBundle) com.google.gwt.core.client.GWT.create(SandpitImageBundle.class);
        AbstractImagePrototype aip = sib.ajaxLoader();
        aip.applyTo(this.picSquare);
    }

    private void initLogoImage() {
        // Display logo.jpg
        SandpitImageBundle sib = (SandpitImageBundle) com.google.gwt.core.client.GWT.create(SandpitImageBundle.class);
        AbstractImagePrototype aip = sib.logo();
        aip.applyTo(this.logo);
    }

    public interface SandpitImageBundle extends ImageBundle {

        // Would match the file 'logo.jpg', 'logo.gif', or 'logo.png' located in the same package as this type.
        AbstractImagePrototype logo();

        // Would match the file 'ajaxLoader.jpg', 'ajaxLoader.gif', or 'ajaxLoader.png' located in the same package as this type.
        AbstractImagePrototype ajaxLoader();
    }

    @Override
    public void onModuleLoad() {
        RootPanel.get().add(new gwt_class_17());
    }
}