import android.media.MediaRecorder;
import java.io.File;
import java.io.IOException;

public class Android35 {
    private void recordVideoStart(){
        MediaRecorder recorder = new MediaRecorder();
        if(recorder != null)
        {
            recorder.stop();
            recorder.release();
        }
        File file = new File("/sdcard/videoTest.3gpp");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        recorder = new MediaRecorder();
        recorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setOutputFile(file.getAbsolutePath());
        recorder.setVideoSize(176, 144);
        recorder.setVideoFrameRate(15);
        recorder.setVideoEncoder(MediaRecorder.VideoEncoder.DEFAULT);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            recorder.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        recorder.start();
    }
}