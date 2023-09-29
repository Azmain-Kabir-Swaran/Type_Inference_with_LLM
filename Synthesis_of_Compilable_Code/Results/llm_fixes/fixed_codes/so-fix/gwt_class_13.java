import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

@SuppressWarnings("deprecation")
public class gwt_class_13 {
	public class ERD1 implements EntryPoint {
		public void onModuleLoad() {
			AbsolutePanel boundaryPanel = new AbsolutePanel();
			boundaryPanel.setPixelSize(1000, 1000);
			Button b = new Button();
			b.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
				}
			});
			boundaryPanel.add(b, 10, 40);
			RootPanel.get().add(boundaryPanel);
		}
	}
}