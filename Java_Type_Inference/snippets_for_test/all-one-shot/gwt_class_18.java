package gwt;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.core.client.GWT;
//ID = 2013169

public class gwt_class_18 extends Composite {

    private static StackNavigatorUiBinder uiBinder = GWT.create(StackNavigatorUiBinder.class);

    interface StackNavigatorUiBinder extends UiBinder<Widget, gwt_class_18> {}

    public gwt_class_18() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}