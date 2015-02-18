package com.barbanyaga.androiddisplay.ContentPackManagment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.barbanyaga.androiddisplay.R;
import com.barbanyaga.androiddisplay.Views.CreepingTextFragment;

/**
 * Created by barbanyaga on 18.02.2015.
 * Content pack inflater inflate main relative layouts with content pack information
 */
public class ContentPackInflater {

    private Activity activity;
    private ContentPack contentPack;
    private RelativeLayout mainRelativeLayout;

    public static ContentPackInflater getInstance(Activity activity, RelativeLayout mainDisplayLayout, ContentPack contentPack) {
        ContentPackInflater inflater = new ContentPackInflater();
        inflater.setMainRelativeLayout(mainDisplayLayout);
        inflater.setContentPack(contentPack);
        inflater.setActivity(activity);
        return inflater;
    }

    public void setContentPack(ContentPack contentPack) {
        this.contentPack = contentPack;
    }

    public ContentPack getContentPack() {
        return contentPack;
    }

    public void setMainRelativeLayout(RelativeLayout mainRelativeLayout) {
        this.mainRelativeLayout = mainRelativeLayout;
    }

    public RelativeLayout getMainRelativeLayout() {
        return mainRelativeLayout;
    }

    public void inflate() {

        // Create creeping text
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setId(R.id.CREEPING_TEXT_FRAGMENT);
        RelativeLayout.LayoutParams creepingLayoutsParams = new RelativeLayout.LayoutParams(1290, 70);
        creepingLayoutsParams.leftMargin = 20;
        creepingLayoutsParams.topMargin = 1080;
        mainRelativeLayout.addView(frameLayout, creepingLayoutsParams);

        CreepingTextFragment creepingTextFragment = new CreepingTextFragment();

        FragmentTransaction fragmentTransaction = activity.getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.CREEPING_TEXT_FRAGMENT, creepingTextFragment)
                .commit();

//        RelativeLayout.LayoutParams creepingLayoutsParams = new RelativeLayout.LayoutParams(1290, 70);
//        creepingLayoutsParams.setMargins(20, 1080, 0, 0);
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Activity getActivity() {
        return activity;
    }
}
