package com.barbanyaga.androiddisplay.ContentPackManagment.Playing.Visualization;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.FragmentDescription;
import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.Project;
import com.barbanyaga.androiddisplay.Views.CreepingTextFragment;
import com.barbanyaga.androiddisplay.Views.HtmlTextFragment;
import com.barbanyaga.androiddisplay.Views.VideoFragment;

/**
 * Created by barbanyaga on 18.02.2015.
 * Project render inflate main relative layouts with project information
 */
public class ProjectRender {

    private final FragmentTransaction fragmentTransaction;
    private Activity activity;
    private Project project;
    private RelativeLayout mainRelativeLayout;

    public ProjectRender(Activity activity, RelativeLayout mainDisplayLayout, Project project) {
        this.mainRelativeLayout = mainDisplayLayout;
        this.project = project;
        this.activity = activity;
        this.fragmentTransaction = activity.getFragmentManager().beginTransaction();
    }

    public void inflate() {

        // add creeping text
        for (FragmentDescription fragmentDescription : project.fragmentDescriptions) {
            addDisplayFragment(fragmentDescription);
        }

        fragmentTransaction
                .commit();

//        RelativeLayout.LayoutParams creepingLayoutsParams = new RelativeLayout.LayoutParams(1290, 70);
//        creepingLayoutsParams.setMargins(20, 1080, 0, 0);
    }

    /**
     * Add creeping text fragment on layout
     *
     * @param fragmentDescription
     * @return
     */
    private ProjectRender addDisplayFragment(FragmentDescription fragmentDescription) {

        int newId = View.generateViewId();
        addFrameLayout(newId, fragmentDescription);

        Fragment fragment = null;

        switch (fragmentDescription.getFragmentType()) {
            case CreepingText:
                fragment = new CreepingTextFragment();
                break;
            case Html:
                fragment = new HtmlTextFragment();
                break;
            case Video:
                VideoFragment newVideoFragment = new VideoFragment();
                newVideoFragment.setPlaylist(fragmentDescription.getPlaylist());
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
     * @param element
     */
    private void addFrameLayout(@IdRes int id, FragmentDescription element) {
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setId(id);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(element.getWidth(), element.getHeight());
        layoutParams.leftMargin = element.getLeft();
        layoutParams.topMargin = element.getTop();
        mainRelativeLayout.addView(frameLayout, layoutParams);
    }
}
