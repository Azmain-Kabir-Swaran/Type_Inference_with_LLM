package gwt;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Label;
//ID = 1651138

public class gwt_class_11 implements EntryPoint {
    HorizontalPanel dictionaryPanel;
    Label wordLabel;

    public gwt_class_11(){
     dictionaryPanel = new HorizontalPanel();
     wordLabel = new Label("Word");
    }
    @Override
    public void onModuleLoad() {
     dictionaryPanel.add(wordLabel);
     RootPanel.get("dictionary").add(dictionaryPanel);
    } 
}