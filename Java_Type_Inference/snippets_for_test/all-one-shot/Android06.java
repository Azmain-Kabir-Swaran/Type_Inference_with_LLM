package androidExamples;
import android.widget.LinearLayout;
import android.view.View;
import android.view.ViewGroup;
import android.view.Gravity;


//ID = 263507
public class Android06 {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		
		LinearLayout zoomView = null;

		zoomView.setLayoutParams(new ViewGroup.LayoutParams
		  (ViewGroup.LayoutParams.WRAP_CONTENT,
		   ViewGroup.LayoutParams.WRAP_CONTENT)); 

		zoomView.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
	}

}