package com.barbanyaga.androiddisplay.ContentPackManagment.DataModel;

import org.simpleframework.xml.Attribute;

/**
 * Created by barbanyaga on 23.03.2015.
 */
public class PlaylistFile {
    @Attribute
    String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public PlaylistFile(String filePath) {
        this.filePath = filePath;
    }
}
