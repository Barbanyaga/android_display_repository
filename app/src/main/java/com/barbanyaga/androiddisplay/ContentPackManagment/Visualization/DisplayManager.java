package com.barbanyaga.androiddisplay.ContentPackManagment.Visualization;

import android.app.Activity;
import android.widget.RelativeLayout;

import com.barbanyaga.androiddisplay.ContentPackManagment.Visualization.ContentPack;
import com.barbanyaga.androiddisplay.ContentPackManagment.Visualization.ContentPackInflater;

/**
 * Created by barbanyaga on 08.03.2015.
 * Display content managment
 */
public class DisplayManager {
    Activity mMainActivity;
    RelativeLayout mMainDisplayLayout;

    /**
     * Create mamanger
     * @param activity Activity to display content pack
     * @param mainDisplayLayout Main layout to display content pack
     */
    public DisplayManager(Activity activity, RelativeLayout mainDisplayLayout) {
        this.mMainActivity = activity;
        this.mMainDisplayLayout = mainDisplayLayout;
    }

    public void showContentPack(ContentPack contentPack){
        ContentPackInflater contentPackInflater = new ContentPackInflater(mMainActivity, mMainDisplayLayout, contentPack);
        contentPackInflater.inflate();
    }

}
