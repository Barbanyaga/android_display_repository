package com.barbanyaga.androiddisplay.ContentPackManagment.DataModel;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * Created by barbanyaga on 15.03.2015.
 */
public class Project {
    @Element
    public FrequencyConfig frequencyConfig;

    @Attribute
    public int duration = 1;

    /**
     * Продолжительность проигрывания проекта
     *
     * @param value
     */
    public void setDuration(int value) {
        duration = value;
    }

    /**
     * Продолжительность проигрывания проекта
     */
    public int getDuration() {
        return duration;
    }

    @ElementList
    public List<FragmentDescription> fragmentDescriptions;
}
