package androidExamples;
import android.graphics.drawable.Drawable;
import android.widget.TabHost;
import android.widget.TabSpec;
//ID = 36881

public class Android05 {

	public static void main(String[] args) {
		TabHost mTabs = null;
		TabSpec ts = mTabs.newTabSpec("tab");
		Drawable iconResource = null;
		ts.setIndicator("TabTitle", iconResource);

		mTabs.addTab(ts);
		mTabs.getTabWidget().removeAllViews();
		mTabs.clearAllTabs();

		// TODO Auto-generated method stub

	}

}