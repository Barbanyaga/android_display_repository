package com.barbanyaga.androiddisplay.ContentPackManagment.Playing.Tasks.Collections;

import com.barbanyaga.androiddisplay.ContentPackManagment.Playing.Tasks.Task;

import org.joda.time.DateTime;

/**
 * Created by barbanyaga on 26.04.2015.
 */
public class TaskComparator implements java.util.Comparator<Task> {
    @Override
    public int compare(Task task, Task task2) {
        int compareResult = task.getDateShow().compareTo(task2.getDateShow());
        return compareResult;
    }
}
