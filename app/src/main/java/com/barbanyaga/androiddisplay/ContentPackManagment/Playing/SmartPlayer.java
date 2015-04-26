package com.barbanyaga.androiddisplay.ContentPackManagment.Playing;

import android.view.View;
import android.widget.RelativeLayout;

import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.Project;
import com.barbanyaga.androiddisplay.ContentPackManagment.Playing.Tasks.ITaskScheduleListener;
import com.barbanyaga.androiddisplay.ContentPackManagment.Playing.Tasks.TaskScheduler;
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
public class SmartPlayer implements ITaskScheduleListener {
    private final MainDisplayActivity mainDisplayActivity;
    private final RelativeLayout mainDisplayLayout;
    private final ProjectRenderer projectRender;
    com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.MasterProject masterProject;
    private TaskScheduler taskScheduler;

    /**
     * Умный проигрыватель
     *
     * @param mainDisplayActivity главная активность
     * @param mainDisplayLayout   разметка активности для отрисовки мастер-проекта
     * @param masterProject       мастер-проект для отрисовки
     */
    public SmartPlayer(MainDisplayActivity mainDisplayActivity, RelativeLayout mainDisplayLayout, com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.MasterProject masterProject) {
        this.mainDisplayActivity = mainDisplayActivity;
        this.mainDisplayLayout = mainDisplayLayout;
        this.masterProject = masterProject;
        this.projectRender = new ProjectRenderer(mainDisplayActivity, mainDisplayLayout);
    }

    public void play() {

        taskScheduler = new TaskScheduler(masterProject.AdProjects, this);
        taskScheduler.start();

        projectRender.inflate(masterProject.MainProject);
    }

    @Override
    public void needToPlay(Project project) {
        mainDisplayLayout.removeAllViews();
        projectRender.inflate(project);
    }

}
