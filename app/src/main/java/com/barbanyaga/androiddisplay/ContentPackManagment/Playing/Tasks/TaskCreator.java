package com.barbanyaga.androiddisplay.ContentPackManagment.Playing.Tasks;

import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.MasterProject;
import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.Project;
import com.barbanyaga.androiddisplay.ContentPackManagment.Playing.Tasks.Collections.TaskCollection;

import org.joda.time.DateTime;

import java.util.ArrayList;
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
     *
     * @param projects
     * @return
     */
    public TaskCollection createTasks(List<Project> projects) {
        List<Task> taskList = new ArrayList<Task>();

        DateTime dateNow = DateTime.now();
        final DateTime playDate = dateNow.plusSeconds(10);// TODO: Фейковая дата для проигрывания - заменить на реальную

        for (Project project : projects) {
            Task newTask = new Task();
            newTask.setProject(project);
            newTask.setDateShow(playDate); // TODO

            taskList.add(newTask);
        }

        TaskCollection taskCollection = new TaskCollection(taskList);
        return taskCollection;
    }
}
