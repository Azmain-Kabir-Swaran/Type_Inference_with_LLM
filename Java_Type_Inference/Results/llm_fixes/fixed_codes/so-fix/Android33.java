package androidExamples;

import android.content.Context;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.view.SurfaceHolder;
import java.io.IOException;

public class Android33 {
    private void init(Context context) {
        boolean mRecording = false;

        int frameCount = 0;
        Camera mCamera = null;
        if (mCamera == null) {
            mCamera = Camera.open();
        }
        Parameters parameters = mCamera.getParameters();
        parameters.setPictureFormat(PixelFormat.JPEG);
        mCamera.setParameters(parameters);
        try {
            SurfaceHolder surfaceHolder = null;
            mCamera.setPreviewDisplay(surfaceHolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mCamera.startPreview();
    }
}