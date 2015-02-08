package com.barbanyaga.androiddisplay.Views;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.barbanyaga.androiddisplay.R;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment implements SurfaceHolder.Callback {

    private MediaPlayer mediaPlayer = null;
    private SurfaceView surfaceView = null;
    private SurfaceHolder holder = null;
    private Button button_play_video;

    public VideoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        mediaPlayer = new MediaPlayer();
        surfaceView = (SurfaceView) view.findViewById(R.id.video_surface_view);
        button_play_video = (Button) view.findViewById(R.id.button_play_video);
        button_play_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Clicked!", Toast.LENGTH_LONG);
            }
        });

        holder = surfaceView.getHolder();
        holder.addCallback(this);

        return inflater.inflate(R.layout.fragment_video, container, false);
    }


    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            mediaPlayer.setDataSource("/sdcard/someVideo.mp4");

            mediaPlayer.prepare();

            //Get the dimensions of the video
            int videoWidth = mediaPlayer.getVideoWidth();
            int videoHeight = mediaPlayer.getVideoHeight();

            //Get the width of the screen
            int screenWidth = getActivity().getWindowManager().getDefaultDisplay().getWidth();

            //Get the SurfaceView layout parameters
            android.view.ViewGroup.LayoutParams lp = surfaceView.getLayoutParams();

            //Set the width of the SurfaceView to the width of the screen
            lp.width = screenWidth;

            //Set the height of the SurfaceView to match the aspect ratio of the video
            //be sure to cast these as floats otherwise the calculation will likely be 0
            lp.height = (int) (((float) videoHeight / (float) videoWidth) * (float) screenWidth);

            //Commit the layout parameters
            surfaceView.setLayoutParams(lp);

            //Start video
            mediaPlayer.start();
        } catch (IOException e) {
            Toast.makeText(getActivity(), R.string.error_play, Toast.LENGTH_LONG);
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
