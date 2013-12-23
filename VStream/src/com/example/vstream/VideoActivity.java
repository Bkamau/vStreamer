package com.example.vstream;

import android.app.Activity;
import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends Activity {

    ProgressDialog pDialog;
    VideoView      videoview;
 
    String VideoURL = "http://livestre.am/1anjH";
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        videoview = (VideoView) findViewById(R.id.VideoView);
       
        BDialog();
 
        try {
           
            MediaController mediacontroller = new MediaController(
            		VideoActivity.this);
            mediacontroller.setAnchorView(videoview);
   
            Uri video = Uri.parse(VideoURL);
            videoview.setMediaController(mediacontroller);
            videoview.setVideoURI(video);
 
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
 
        videoview.requestFocus();
        videoview.setOnPreparedListener(new OnPreparedListener() {
            
            public void onPrepared(MediaPlayer mp) {
                pDialog.dismiss();
                videoview.start();
            }
        });
 
    }
    private void BDialog(){
    	
        pDialog = new ProgressDialog(VideoActivity.this);
        pDialog.setTitle("Android Video Streaming Tutorial");
        pDialog.setMessage("Buffering...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
    }



}
