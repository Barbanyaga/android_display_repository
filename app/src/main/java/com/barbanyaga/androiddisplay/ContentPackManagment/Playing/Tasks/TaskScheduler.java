package com.barbanyaga.androiddisplay.ContentPackManagment.Playing.Tasks;

import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.Project;
import com.barbanyaga.androiddisplay.ContentPackManagment.Playing.Tasks.Collections.TaskCollection;
import com.barbanyaga.androiddisplay.util.helpers.TimerHelpers.SystemTimerAndroid;
import com.barbanyaga.androiddisplay.util.helpers.TimerHelpers.SystemTimerTask;

import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by barbanyaga on 25.04.2015.
 * Менеджер задач (проектов)
 * Получает список проектов, которые необходимо проигрывать.
 * Строит план проигрывания.
 * Генерирует событие "необходимо проиграть проект" с объектом проект.
 */
public class TaskScheduler {

    private List<Project> projects;
    private ITaskScheduleListener taskScheduleListener;
    private TaskCollection taskCollection;


    public TaskScheduler(List<Project> projects, ITaskScheduleListener taskScheduleListener) {
        this.projects = projects;
        this.taskScheduleListener = taskScheduleListener;
    }

    /**
     * Старт менеджера
     */
    public void start() {
        TaskCreator taskCreator = new TaskCreator();
        taskCollection = taskCreator.createTasks(projects);

        SystemTimerTask showProjectTask = new CheckProjectTask();
        SystemTimerAndroid systemTimerAndroid = new SystemTimerAndroid();
        systemTimerAndroid.addListener(showProjectTask);
    }

    /**
     * Проверяет наличие задачи на выполнение
     */
    class CheckProjectTask extends SystemTimerTask {
        public void run() {

            Task task = taskCollection.popTaskByDate(DateTime.now());

            if (task != null) {
                taskScheduleListener.needToPlay(task.getProject());
            }
        }
    }
}
