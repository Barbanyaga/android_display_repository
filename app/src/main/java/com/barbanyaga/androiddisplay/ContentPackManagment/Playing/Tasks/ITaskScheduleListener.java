package com.barbanyaga.androiddisplay.ContentPackManagment.Playing.Tasks;

import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.Project;

/**
 * Created by barbanyaga on 25.04.2015.
 * Слушатель планировщика задач проигрывания проектов
 */
public interface ITaskScheduleListener {
    /**
     * Событие "пора проигрывать проект"
     * @param project
     */
    void needToPlay(Project project);
}
