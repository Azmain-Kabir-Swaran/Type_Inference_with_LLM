import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Android22 extends ListActivity {

    private SimpleCursorAdapter mAdapter;
    public String pbContact;
    public static final int ACTIVITY_EDIT = 1;
    private static final int ACTIVITY_CREATE = 0;

    // Called when the activity is first created. 
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        Cursor C = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        startManagingCursor(C);

        String[] columns = new String[] { ContactsContract.Contacts.DISPLAY_NAME };
        int[] names = new int[] { android.R.id.text1 };

        mAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, C, columns, names);
        setListAdapter(mAdapter);
    } // end onCreate()

    // Called when contact is pressed
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Cursor C = (Cursor) mAdapter.getItem(position);
        pbContact = C.getString(C.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

        Intent i = new Intent(this, NoteActivity.class);
        startActivityForResult(i, ACTIVITY_CREATE);
    }
}

class NoteActivity {
    // Implementation of the NoteActivity class
    // ...
}