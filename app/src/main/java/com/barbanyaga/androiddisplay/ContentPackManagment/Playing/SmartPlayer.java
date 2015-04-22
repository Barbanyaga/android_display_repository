package com.barbanyaga.androiddisplay.ContentPackManagment.Playing;

import android.view.View;
import android.widget.RelativeLayout;

import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.Project;
import com.barbanyaga.androiddisplay.ContentPackManagment.Playing.Visualization.ProjectRenderer;
import com.barbanyaga.androiddisplay.MainDisplayActivity;
import com.barbanyaga.androiddisplay.util.helpers.TimerHelpers.SystemTimerAndroid;
import com.barbanyaga.androiddisplay.util.helpers.TimerHelpers.SystemTimerTask;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by barbanyaga on 14.04.2015.
 * Получает мастер проект и отображает на экране монитора с учётом расписания воспроизведения
 */
public class SmartPlayer {
    private final MainDisplayActivity mainDisplayActivity;
    private final RelativeLayout mainDisplayLayout;
    private final ProjectRenderer projectRender;
    com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.MasterProject masterProject;

    /**
     * Умный проигрыватель
     *
     * @param mainDisplayActivity главная активность
     * @param mainDisplayLayout   главная разметка активности
     * @param masterProject       мастер-проект для отрисовки
     */
    public SmartPlayer(MainDisplayActivity mainDisplayActivity, RelativeLayout mainDisplayLayout, com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.MasterProject masterProject) {
        this.mainDisplayActivity = mainDisplayActivity;
        this.mainDisplayLayout = mainDisplayLayout;
        this.masterProject = masterProject;
        this.projectRender = new ProjectRenderer(mainDisplayActivity, mainDisplayLayout);
    }

    public void Play() {

        projectRender.inflate(masterProject.MainProject);

//        for (Project project : masterProject.AdProjects) {
//            ProjectRenderer projectRender = new ProjectRenderer(mainDisplayActivity, mainDisplayLayout, project);
//            projectRender.inflate();
//        }

        SystemTimerTask showProjectTask = new ShowProjectTask(masterProject.AdProjects.get(0));
        SystemTimerAndroid systemTimerAndroid = new SystemTimerAndroid();
        systemTimerAndroid.addListener(showProjectTask);
    }

    class ShowProjectTask extends SystemTimerTask {
        Project project;

        ShowProjectTask(Project project) {
            this.project = project;
        }

        public void run() {
            mainDisplayLayout.removeAllViews();

            projectRender.inflate(project);

            setCancel(true);
        }
    }
}
