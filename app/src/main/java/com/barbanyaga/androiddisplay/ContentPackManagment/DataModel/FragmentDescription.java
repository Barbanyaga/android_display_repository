package com.barbanyaga.androiddisplay.ContentPackManagment.DataModel;

import org.simpleframework.xml.Attribute;

/**
 * Created by barbanyaga on 15.03.2015.
 */
public class FragmentDescription {
    private FragmentType fragmentType;
    @Attribute
    private int x;
    @Attribute
    private int y;
    @Attribute
    private int width;
    private int height;
    private Playlist playlist;

    public FragmentType getFragmentType() {
        return fragmentType;
    }

    public void setFragmentType(FragmentType fragmentType) {
        this.fragmentType = fragmentType;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
}
