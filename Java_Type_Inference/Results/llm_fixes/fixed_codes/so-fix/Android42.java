package androidExamples;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;

public class Android42 extends Activity implements MediaPlayer.OnErrorListener,
        MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener,
        MediaPlayer.OnPreparedListener, SurfaceHolder.Callback {

    private static final String TAG = "MediaPreview";

    private MediaPlayer mp;
    private VideoView mPreview;
    private SurfaceHolder holder;
    private Button btnPlay;
    private Button btnPause;
    private Button btnReset;
    private Button btnStop;

    private String mPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_preview);

        mPreview = (VideoView)findViewById(R.id.myVideo);
        btnPlay = (Button)findViewById(R.id.btn_play);
        btnPause = (Button)findViewById(R.id.btn_pause);
        btnReset = (Button)findViewById(R.id.btn_reset);
        btnStop = (Button)findViewById(R.id.btn_stop);

        getPathFromParentDialog();

        btnPlay.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                playVideo();
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(mp != null && mp.isPlaying()){
                    mp.pause();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(mp != null){
                    mp.seekTo(0);
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(mp != null){
                    mp.stop();
                    mp.release();
                    mp = null;
                }
            }
        });

        getWindow().setFormat(PixelFormat.TRANSPARENT);
        holder = mPreview.getHolder();
        holder.addCallback(this);
        holder.setSizeFromLayout();
    }
    
    private void getPathFromParentDialog(){
        // your code here
    }

    @Override
    protected void onResume() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        super.onResume();
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        if(mp != null){
            mp.stop();
            mp.release();
            mp = null;
        }
        return false;
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {

    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){
        playVideo();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){

    }

    private void playVideo(){
        try{
            mp = new MediaPlayer();
            mp.setOnErrorListener(this);
            mp.setOnBufferingUpdateListener(this);
            mp.setOnCompletionListener(this);
            mp.setOnPreparedListener(this);

            mp.setDisplay(holder);

            mp.reset();
            mp.setDataSource(mPath);
            mp.prepareAsync();
        }
        catch(IOException e){
            // handle exception
        }
    }
}