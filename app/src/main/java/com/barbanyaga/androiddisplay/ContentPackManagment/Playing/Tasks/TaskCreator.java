package com.barbanyaga.androiddisplay.ContentPackManagment.Playing.Tasks;

import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.MasterProject;

import java.util.List;

/**
 * Created by barbanyaga on 05.04.2015.
 * Создаёт на основе мастер проекта список задач для выполнения
 * Учитывает периодичность запуска проекта
 */
public class TaskCreator {
    public TaskCreator() {
    }

    /**
     * Создаёт задачи на Мастер-проекта
     * @param masterProject
     * @return
     */
    public List<Task> createTasks(MasterProject masterProject) {
        List<Task> tasks = null;
        return tasks;
    }
}
