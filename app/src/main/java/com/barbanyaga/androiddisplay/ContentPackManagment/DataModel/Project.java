package com.barbanyaga.androiddisplay.ContentPackManagment.DataModel;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * Created by barbanyaga on 15.03.2015.
 */
public class Project {
    @Element
    public FrequencyConfig frequencyConfig;
    @ElementList
    public List<FragmentDescription> fragmentDescriptions;
}
