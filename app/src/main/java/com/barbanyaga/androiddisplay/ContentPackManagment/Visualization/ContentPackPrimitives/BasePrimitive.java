package com.barbanyaga.androiddisplay.ContentPackManagment.Visualization.ContentPackPrimitives;

import com.barbanyaga.androiddisplay.ContentPackManagment.Visualization.FragmentType;

/**
 * Created by barbanyaga on 21.02.2015.
 */
public class BasePrimitive implements IDisplayable {
    protected int MarginTop;
    protected int MarginLeft;
    protected int Width;
    protected int Height;
    protected int ZIndex;

    public int getMarginTop() {
        return MarginTop;
    }

    public void setMarginTop(int marginTop) {
        MarginTop = marginTop;
    }

    public int getMarginLeft() {
        return MarginLeft;
    }

    public void setMarginLeft(int marginLeft) {
        MarginLeft = marginLeft;
    }

    public int getWidth() {
        return Width;
    }

    public void setWidth(int width) {
        Width = width;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    public int getZIndex() {
        return ZIndex;
    }

    public void setZIndex(int ZIndex) {
        this.ZIndex = ZIndex;
    }
}
