import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class gwt_class_43 {
	public class GroupLbl extends Composite implements ClickHandler, MouseOutHandler {
		private Label lbl;
		private HorizontalPanel hp;

		public void onClick(ClickEvent event) {
			hp.setStyleName("background-GroupLbl");

			Object folder = null;
			if (event.getSource().equals(folder) || event.getSource().equals(lbl)) {

			}
		}

		public Widget getWidget() {
			return hp;
		}

		public void onMouseOut(MouseOutEvent event) {
			hp.removeStyleName("background-GroupLbl");
		}
	}
}