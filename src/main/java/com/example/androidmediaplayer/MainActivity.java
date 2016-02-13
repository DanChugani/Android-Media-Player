package com.example.androidmediaplayer;

import java.io.IOException;



import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import android.widget.MediaController;
import android.widget.VideoView;
import android.app.Activity;

/**
 * Name: Dan Chugani
 * Date: 11/22/2015
 *
 * Description:
 *
 * This app plays a video through a predefined link, demonstrates the concepts behind
 * MediaPlayer, SurfaceHolder, SurfaceView and VideoView
 */


public class MainActivity extends Activity implements SurfaceHolder.Callback, OnPreparedListener{
	
	MediaPlayer mediaPlayer;
	SurfaceHolder surfaceHolder;
	SurfaceView playerSurfaceView;
	//String videoSrc = "rtsp://v6.cache1.c.youtube.com/CjYLENy73wIaLQkDsLHya4-Z9hMYDSANFEIJbXYtZ29vZ2xlSARSBXdhdGNoYKX4k4uBjbOiUQw=/0/0/0/video.3gp";
    String videoSrc = "http://d269mq2d9sw4la.cloudfront.net/eSchool-video/13Q1-DannySilk-CultureOfHonor/13Q1-DannySilk-CultureOfHonor01.mp4";
	VideoView videoView=null;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		videoView=(VideoView)findViewById(R.id.videoView);

		videoView.setVideoPath(videoSrc);
		videoView.setMediaController(new MediaController(this));
		videoView.requestFocus();
		videoView.start();
        
        
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {

        try {
        	mediaPlayer = new MediaPlayer();
            mediaPlayer.setDisplay(surfaceHolder);
			mediaPlayer.setDataSource(videoSrc);
			mediaPlayer.prepare();
			mediaPlayer.setOnPreparedListener(this);
			mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		mediaPlayer.start();
	}

}
