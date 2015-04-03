package com.barbanyaga.androiddisplay.ContentPackManagment.DataModel;

import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.Enums.FrequencyType;

import org.joda.time.DateTime;
import org.simpleframework.xml.Element;

/**
 * Created by barbanyaga on 15.03.2015.
 * Задает частоту запуска
 */
public class FrequencyConfig {
    /**
     * Точная дата/время старта воспроизвдения
     */
    @Element(required = false)
    private DateTime dateStart;

    @Element
    private FrequencyType frequencyType;

    @Element(required = false)
    private int frequencyN;

    /**
     * Дата/время начала показа
     *
     * @return
     */
    public DateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(DateTime dateStart) {
        this.dateStart = dateStart;
    }

    public FrequencyType getFrequencyType() {
        return frequencyType;
    }

    public void setFrequencyType(FrequencyType frequencyType) {
        this.frequencyType = frequencyType;
    }

    public int getFrequencyN() {
        return frequencyN;
    }

    public void setFrequencyN(int frequencyN) {
        this.frequencyN = frequencyN;
    }
}
