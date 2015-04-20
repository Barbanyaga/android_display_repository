package com.barbanyaga.androiddisplay.ContentPackManagment.DataModel;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by barbanyaga on 15.03.2015.
 */
@Root
public class MasterProject {
    /**
     * Главный проект (проигрывается как основной плейлист, может обрываться проектами)
     */
    @Element
    public Project MainProject;

    /**
     * Рекламные проекты, обрывающие проигрывание основного проекта
     */
    @ElementList
    public List<Project> AdProjects;
}
