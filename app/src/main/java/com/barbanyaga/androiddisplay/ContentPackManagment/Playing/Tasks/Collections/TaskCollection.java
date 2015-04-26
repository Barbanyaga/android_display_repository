package com.barbanyaga.androiddisplay.ContentPackManagment.Playing.Tasks.Collections;

import com.barbanyaga.androiddisplay.ContentPackManagment.Playing.Tasks.Task;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by barbanyaga on 26.04.2015.
 */
public class TaskCollection {
    List<Task> tasks = new ArrayList<Task>();

    public TaskCollection(List<Task> tasks) {
        this.tasks = tasks;
        sortByDateAsc(tasks);
    }

    /**
     * Сортировка по дате
     */
    private void sortByDateAsc(List<Task> unsortedTasks) {
        Collections.sort(unsortedTasks, new TaskComparator());
    }

    /**
     * Возвращает последнюю задачу с датой меньше переданной TODO
     *
     * @param date
     * @return
     */
    public Task popTaskByDate(DateTime date) {

        Task resultTask = null;

        for (Task task : tasks) {
            if (task.getDateShow().isBefore(date) ||
                    task.getDateShow().isEqual(date)) {
                resultTask = task;
                tasks.remove(task);
            }
        }

        return resultTask;
    }
}
