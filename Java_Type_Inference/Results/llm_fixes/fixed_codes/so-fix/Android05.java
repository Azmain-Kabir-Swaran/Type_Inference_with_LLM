import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Android05 {

	public static void main(String[] args) {
		Context context = null; // Replace null with your actual context variable
		TabHost mTabs = new TabHost(context);
		TabSpec ts = mTabs.newTabSpec("tab");
		Drawable iconResource = null; // Replace null with your actual drawable resource
		ts.setIndicator("TabTitle", iconResource);

		mTabs.addTab(ts);
		mTabs.getTabWidget().removeAllViews();
		mTabs.clearAllTabs();

		// TODO Auto-generated method stub

	}
}