import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ImageBundle;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GwtClass17 extends Composite {

    private String firstName = null;
    private String lastName = null;
    private String picSquareUrl = null;

    private Image picSquare = new Image();
    private Image logo = new Image();
    private Button logoutButton = new Button("Logout");
    private DockPanel panel = new DockPanel();
    private HTML html = new HTML("Welcome to Sandpit.");

    public GwtClass17() {
        this.initProfileImage();
        this.initLogoImage();

        panel.add(picSquare, DockPanel.WEST);
        panel.add(html, DockPanel.CENTER);

        VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.add(logo);
        verticalPanel.add(logoutButton);

        panel.add(verticalPanel, DockPanel.EAST);

        initWidget(panel);
    }

    private void initProfileImage() {
        SandpitImageBundle sib = GWT.create(SandpitImageBundle.class);
        ImageResource imageResource = sib.ajaxLoader();
        picSquare.setResource(imageResource);
    }

    private void initLogoImage() {
        SandpitImageBundle sib = GWT.create(SandpitImageBundle.class);
        ImageResource imageResource = sib.logo();
        logo.setResource(imageResource);
    }

    public interface SandpitImageBundle extends ImageBundle {
        @Resource("path/to/logo.png")
        ImageResource logo();

        @Resource("path/to/ajaxLoader.gif")
        ImageResource ajaxLoader();
    }
}