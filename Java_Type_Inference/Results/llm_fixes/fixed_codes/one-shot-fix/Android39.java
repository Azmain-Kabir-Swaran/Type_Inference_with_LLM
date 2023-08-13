import android.os.Bundle;
import android.app.ListActivity;
import android.widget.ArrayAdapter;

public class Android39 extends ListActivity {

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);

        String[] items = {"item1", "item2", "item3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        setListAdapter(adapter);
    }
}