package com.barbanyaga.androiddisplay.ContentPackManagment.DataModel;

import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import java.util.List;

/**
 * Created by barbanyaga on 15.03.2015.
 */
@Root
public class MasterProject {
    @ElementList
    public List<Project> Projects;
}
