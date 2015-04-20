package com.barbanyaga.androiddisplay.ContentPackManagment.Playing;

import android.widget.RelativeLayout;

import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.Project;
import com.barbanyaga.androiddisplay.ContentPackManagment.Playing.Visualization.ProjectRenderer;
import com.barbanyaga.androiddisplay.MainDisplayActivity;

/**
 * Created by barbanyaga on 14.04.2015.
 * Получает мастер проект и отображает на экране монитора с учётом расписания воспроизведения
 */
public class SmartPlayer {
    private final MainDisplayActivity mainDisplayActivity;
    private final RelativeLayout mainDisplayLayout;
    com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.MasterProject masterProject;

    /**
     * Умный проигрыватель
     *
     * @param mainDisplayActivity главная активность
     * @param mainDisplayLayout главная разметка активности
     * @param masterProject мастер-проект для отрисовки
     */
    public SmartPlayer(MainDisplayActivity mainDisplayActivity, RelativeLayout mainDisplayLayout, com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.MasterProject masterProject) {
        this.mainDisplayActivity = mainDisplayActivity;
        this.mainDisplayLayout = mainDisplayLayout;
        this.masterProject = masterProject;
    }

    public void Play() {
        for (Project project : masterProject.AdProjects) {
            ProjectRenderer projectRender = new ProjectRenderer(mainDisplayActivity, mainDisplayLayout, project);
            projectRender.inflate();
        }
    }
}
