package com.barbanyaga.androiddisplay.ContentPackManagment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.barbanyaga.androiddisplay.ContentPackManagment.Visualization.ContentPackPrimitives.CreepingText;
import com.barbanyaga.androiddisplay.R;
import com.barbanyaga.androiddisplay.Views.CreepingTextFragment;

/**
 * Created by barbanyaga on 18.02.2015.
 * Content pack inflater inflate main relative layouts with content pack information
 */
public class ContentPackInflater {

    private final FragmentTransaction fragmentTransaction;
    private Activity activity;
    private ContentPack contentPack;
    private RelativeLayout mainRelativeLayout;

    public ContentPackInflater(Activity activity, RelativeLayout mainDisplayLayout, ContentPack contentPack) {
        this.mainRelativeLayout = mainDisplayLayout;
        this.contentPack = contentPack;
        this.activity = activity;
        this.fragmentTransaction = activity.getFragmentManager().beginTransaction();
    }

    public void inflate() {

        // add creeping text
        for (CreepingText ct : contentPack.creepingTextList) {
            addCreepingTextFragment(ct);
        }

        fragmentTransaction
                .commit();

//        RelativeLayout.LayoutParams creepingLayoutsParams = new RelativeLayout.LayoutParams(1290, 70);
//        creepingLayoutsParams.setMargins(20, 1080, 0, 0);
    }

    /**
     * Add creeping text fragment on layout
     *
     * @param creepingText
     * @return
     */
    private ContentPackInflater addCreepingTextFragment(CreepingText creepingText) {
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setId(R.id.CREEPING_TEXT_FRAGMENT);
        RelativeLayout.LayoutParams creepingLayoutsParams = new RelativeLayout.LayoutParams(creepingText.getWidth(), creepingText.getHeight());
        creepingLayoutsParams.leftMargin = creepingText.getMarginLeft();
        creepingLayoutsParams.topMargin = creepingText.getMarginTop();
        mainRelativeLayout.addView(frameLayout, creepingLayoutsParams);

        CreepingTextFragment creepingTextFragment = new CreepingTextFragment();

        fragmentTransaction.add(R.id.CREEPING_TEXT_FRAGMENT, creepingTextFragment);
        return this;
    }
}
