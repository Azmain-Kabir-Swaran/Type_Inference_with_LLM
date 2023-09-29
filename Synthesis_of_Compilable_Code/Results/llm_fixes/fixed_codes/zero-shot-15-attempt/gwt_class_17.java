package gwt;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ImageBundle;

public class gwt_class_17 extends Composite {

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
        SandpitImageBundle sib = (SandpitImageBundle) GWT.create(SandpitImageBundle.class);  
        AbstractImagePrototype aip = sib.ajaxLoader();  
        sib.applyTo(this.picSquare);  
    }  

    private void initLogoImage() {  
        SandpitImageBundle sib = (SandpitImageBundle) GWT.create(SandpitImageBundle.class);  
        AbstractImagePrototype aip = sib.logo();  
        aip.applyTo(this.logo);  
    }  

    public interface SandpitImageBundle extends ImageBundle {  
        public AbstractImagePrototype logo();  
        public void applyTo(Image picSquare);
        public AbstractImagePrototype ajaxLoader();  
    }
}