package com.barbanyaga.androiddisplay.ContentPackManagment.Playing.Tasks;

import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.Project;

import org.joda.time.DateTime;

/**
 * Created by barbanyaga on 05.04.2015.
 * Задача
 */
public class Task {
    /**
     * Дата выполнения задачи
     */
    DateTime dateShow;
    /**
     * Проект для отображения
     */
    Project project;


    public DateTime getDateShow() {
        return dateShow;
    }

    public void setDateShow(DateTime dateShow) {
        this.dateShow = dateShow;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}
