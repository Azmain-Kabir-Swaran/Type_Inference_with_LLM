package androidExamples;
import java.io.IOException;
import android.view.SurfaceHolder;
import android.content.Context;
import android.hardware.Camera;
import android.graphics.PixelFormat;
import android.hardware.Camera.Parameters;
//ID = 1048739


public class Android33 {
	private void init(Context context)
	{
		boolean mRecording = false;

		int frameCount = 0;
		Camera mCamera = null;
		if(mCamera == null)
		{
			mCamera = Camera.open();
		}
		Parameters parameters = mCamera.getParameters();
		parameters.setPictureFormat(PixelFormat.JPEG);
		mCamera.setParameters(parameters);
		try {
			SurfaceHolder surfaceHolder = null;
			mCamera.setPreviewDisplay(surfaceHolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mCamera.startPreview();

	}
}