package com.barbanyaga.androiddisplay.Views;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.barbanyaga.androiddisplay.R;

import java.io.File;
import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment implements SurfaceHolder.Callback {

    private MediaPlayer mediaPlayer = null;
    private SurfaceView surfaceView = null;
    private SurfaceHolder holder = null;
    private Button button_play_video;
    private View view;
    private PopupWindow popupWindowBanner;
    private ImageView bannerImage;
    private String pathToFile = "/sdcard/Movies/Sample.mp4";

    public VideoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_video, container, false);

        surfaceView = (SurfaceView) view.findViewById(R.id.video_surface_view);
        surfaceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickSurface(view);
            }
        });
        holder = surfaceView.getHolder();
        holder.addCallback(this);

        mediaPlayer = new MediaPlayer();

// Баннер
        LayoutInflater inflater2 = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View bannerView = inflater.inflate(R.layout.piece_banner_sample, null, false);
        popupWindowBanner = new PopupWindow(inflater.inflate(R.layout.piece_banner_sample, null, false), 500, 500, true);

        bannerImage = (ImageView) bannerView.findViewById(R.id.banner_image);
        bannerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindowBanner.dismiss();
                bannerIsShowed = false;
            }
        });

        return view;
    }

    Boolean bannerIsShowed = false;

    private void clickSurface(View x) {
        if (!bannerIsShowed) {
            popupWindowBanner.showAtLocation(view, Gravity.LEFT, 0, 0);
            popupWindowBanner.setBackgroundDrawable(new ColorDrawable(Color.GREEN));
            popupWindowBanner.update(50, 50, 300, 80);
            bannerIsShowed = true;
        } else {
            popupWindowBanner.dismiss();
            bannerIsShowed = false;
        }
    }


    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            File file = new File(pathToFile);
            if (!file.exists()) {
                throw new Resources.NotFoundException("Файл не найден!");
            }

            mediaPlayer.setDataSource(pathToFile);
            mediaPlayer.setDisplay(holder);
            mediaPlayer.prepare();

            mediaPlayer.seekTo(8*60*1000);

/*

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

    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public String getPathToFile() {
        return pathToFile;
    }
}
