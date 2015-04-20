package com.barbanyaga.androiddisplay.ContentPackManagment.DataModel;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by barbanyaga on 15.03.2015.
 */
public class Playlist {
    @ElementList
    public List<PlaylistFile> playlistFiles = new ArrayList<PlaylistFile>();

    /**
     * Возвращает следующий элемент плейлиста
     * @return
     */
    public PlaylistFile getNextFile() {
        if (playlistFiles.size() > 0) {
            PlaylistFile nextFile = playlistFiles.get(0);
            playlistFiles.remove(0);
            return nextFile;
        }

        return null;
    }
}
