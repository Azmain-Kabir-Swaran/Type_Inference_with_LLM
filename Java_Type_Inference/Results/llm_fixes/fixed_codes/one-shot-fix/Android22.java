package androidExamples;

import android.app.ListActivity;
import android.widget.SimpleCursorAdapter;
import android.provider.ContactsContract;
import android.database.Cursor;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.ListView;
import android.view.View;
import android.content.Intent;

public class Android22 extends ListActivity {

    private SimpleCursorAdapter mAdapter;
    public TextView pbContact;
    public static String PBCONTACT;
    public static final int ACTIVITY_EDIT = 1;
    private static final int ACTIVITY_CREATE = 0;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        Cursor C = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        startManagingCursor(C);

        String[] columns = new String[]{ContactsContract.Contacts.DISPLAY_NAME};
        int[] names = new int[]{android.R.id.text1};

        mAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, C, columns, names);
        setListAdapter(mAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Cursor C = (Cursor) mAdapter.getItem(position);
        PBCONTACT = C.getString(C.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

        Intent i = new Intent(this, Note.class);
        startActivityForResult(i, ACTIVITY_CREATE);
    }

    //dummy Note class to fix the compilation issue
    private class Note {

    }
}