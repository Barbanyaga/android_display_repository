package com.barbanyaga.androiddisplay.Views;


import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.Playlist;
import com.barbanyaga.androiddisplay.R;
import com.barbanyaga.androiddisplay.Views.Base.BaseFragment;

import java.io.File;
import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends BaseFragment implements SurfaceHolder.Callback {

    private MediaPlayer mediaPlayer = null;
    private SurfaceView surfaceView = null;
    private SurfaceHolder holder = null;
    private View view;

    public VideoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_video, container, false);

        surfaceView = (SurfaceView) view.findViewById(R.id.video_surface_view);

        holder = surfaceView.getHolder();
        holder.addCallback(this);

        mediaPlayer = new MediaPlayer();
        return view;
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            File file = new File(playlist.playlistFiles.get(0).getFilePath()); // TODO проигрывание плейлистов
            if (!file.exists()) {
                throw new Resources.NotFoundException("Файл не найден!");
            }

            mediaPlayer.setDataSource(file.getPath());
            mediaPlayer.setDisplay(holder);

            mediaPlayer.prepare();
            mediaPlayer.seekTo(1 * 60 * 1000);
/*
 // Играемся с размером видео

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
*/

            //Start video
            mediaPlayer.start();
        } catch (IOException e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        mediaPlayer.stop();
    }

    @Override
    public void stop() {
        mediaPlayer.stop();
    }
}
