package com.barbanyaga.androiddisplay.ContentPackManagment.Playing.Visualization.ContentPackPrimitives.Base;

/**
 * Created by barbanyaga on 21.02.2015.
 */
public abstract class BasePrimitiveElement implements IDisplayable {

    protected int MarginTop;
    protected int MarginLeft;
    protected int Width;
    protected int Height;
    protected Boolean visible = true;
    protected int ZIndex;
    protected DisplayElementType elementType;

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

    public DisplayElementType getElementType() {
        return elementType;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public int getZIndex() {
        return ZIndex;
    }

    public void setZIndex(int ZIndex) {
        this.ZIndex = ZIndex;
    }


}
