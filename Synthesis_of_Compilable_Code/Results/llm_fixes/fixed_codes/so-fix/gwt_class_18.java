import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class gwt_class_18 extends Composite {

    @UiTemplate("gwt_class_18.ui.xml")
    interface StackNavigatorUiBinder extends UiBinder<Widget, gwt_class_18> {}

    private static StackNavigatorUiBinder uiBinder = GWT.create(StackNavigatorUiBinder.class);

    public gwt_class_18() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}