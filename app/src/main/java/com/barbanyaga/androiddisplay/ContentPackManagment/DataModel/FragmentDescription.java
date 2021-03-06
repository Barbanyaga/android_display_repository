package com.barbanyaga.androiddisplay.ContentPackManagment.DataModel;

import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.Enums.FragmentType;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

/**
 * Created by barbanyaga on 15.03.2015.
 */
public class FragmentDescription {
    @Attribute
    private FragmentType fragmentType;
    @Attribute
    private int left;
    @Attribute
    private int top;
    @Attribute
    private int width;
    @Attribute
    private int height;
    @Element
    private Playlist playlist;

    public FragmentType getFragmentType() {
        return fragmentType;
    }

    public void setFragmentType(FragmentType fragmentType) {
        this.fragmentType = fragmentType;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
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
