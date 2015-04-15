package com.barbanyaga.androiddisplay.ContentPackManagment.Playing;

import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.MasterProject;

/**
 * Created by barbanyaga on 14.04.2015.
 * Получает мастер проект и отображает на экране монитора с учётом расписания воспроизведения
 */
public class SmartPlayer {
    MasterProject masterProject;

    /**
     * Умный проигрыватель
     * @param masterProject
     */
    public SmartPlayer(MasterProject masterProject) {
        this.masterProject = masterProject;
    }
}
