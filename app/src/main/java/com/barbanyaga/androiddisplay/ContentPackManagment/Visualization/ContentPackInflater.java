package com.barbanyaga.androiddisplay.ContentPackManagment.Visualization;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.barbanyaga.androiddisplay.ContentPackManagment.Visualization.ContentPackPrimitives.BasePrimitiveElement;
import com.barbanyaga.androiddisplay.ContentPackManagment.Visualization.ContentPackPrimitives.IDisplayable;
import com.barbanyaga.androiddisplay.ContentPackManagment.Visualization.ContentPackPrimitives.VideoElement;
import com.barbanyaga.androiddisplay.Views.CreepingTextFragment;
import com.barbanyaga.androiddisplay.Views.HtmlTextFragment;
import com.barbanyaga.androiddisplay.Views.VideoFragment;

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
        for (BasePrimitiveElement ct : contentPack.displayElements) {
            addDisplayFragment(ct);
        }

        fragmentTransaction
                .commit();

//        RelativeLayout.LayoutParams creepingLayoutsParams = new RelativeLayout.LayoutParams(1290, 70);
//        creepingLayoutsParams.setMargins(20, 1080, 0, 0);
    }

    /**
     * Add creeping text fragment on layout
     *
     * @param element
     * @return
     */
    private ContentPackInflater addDisplayFragment(BasePrimitiveElement element) {

        int newId = View.generateViewId();
        addFrameLayout(newId, element);

        Fragment fragment = null;

        switch (element.getElementType()) {
            case CreepingText:
                fragment = new CreepingTextFragment();
                break;
            case HtmlText:
                fragment = new HtmlTextFragment();
                break;
            case Video:
                VideoElement videoElement = (VideoElement) element;
                VideoFragment newVideoFragment = new VideoFragment();
                newVideoFragment.setPathToFile(videoElement.getPathToFile());
                fragment = newVideoFragment;
                break;
        }

        if (fragment != null) {
            fragmentTransaction.add(newId, fragment);
        }

        return this;
    }

    /**
     * Add frame with specific Id
     *
     * @param id
     */
    private void addFrameLayout(@IdRes int id, IDisplayable element) {
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setId(id);
        frameLayout.setVisibility(element.getVisible() ? View.VISIBLE : View.GONE);
        RelativeLayout.LayoutParams creepingLayoutsParams = new RelativeLayout.LayoutParams(element.getWidth(), element.getHeight());
        creepingLayoutsParams.leftMargin = element.getMarginLeft();
        creepingLayoutsParams.topMargin = element.getMarginTop();
        mainRelativeLayout.addView(frameLayout, creepingLayoutsParams);
    }
}
