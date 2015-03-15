package com.barbanyaga.androiddisplay.ContentPackManagment.DataModel;

import org.joda.time.DateTime;

/**
 * Created by barbanyaga on 15.03.2015.
 * Задает частоту запуска
 */
public class FrecuencyConfig {
    private DateTime dateStart;

    /***
     * Дата/время начала показа
     * @return
     */
    public DateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(DateTime dateStart) {
        this.dateStart = dateStart;
    }
}
