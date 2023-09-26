package androidExamples;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class Android22 extends ListActivity {

    private SimpleCursorAdapter mAdapter;
    public TextView pbContact;
    public static String PBCONTACT;
    public static final int ACTIVITY_EDIT = 1;
    private static final int ACTIVITY_CREATE = 0;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        Cursor C = getContentResolver().query(Contacts.CONTENT_URI, null, null, null, null);
        startManagingCursor(C);

        String[] columns = new String[]{Contacts.DISPLAY_NAME};
        int[] names = new int[]{androidExamples.R.id.lay};

        mAdapter = new SimpleCursorAdapter(this, androidExamples.R.layout.mycontacts, C, columns, names);
        setListAdapter(mAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Cursor C = (Cursor) mAdapter.getItem(position);
        PBCONTACT = C.getString(C.getColumnIndex(Contacts.DISPLAY_NAME));

        Intent i = new Intent(this, androidExamples.Note.class);
        startActivityForResult(i, ACTIVITY_CREATE);
    }
}