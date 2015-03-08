package com.barbanyaga.androiddisplay.ContentPackManagment.Visualization.ContentPackPrimitives;

import com.barbanyaga.androiddisplay.ContentPackManagment.Visualization.FragmentType;

/**
 * Created by barbanyaga on 18.02.2015.
 */
public interface IDisplayable {
    public int getMarginTop();

    public void setMarginTop(int marginTop);

    public int getMarginLeft();

    public int getWidth();

    public void setMarginLeft(int marginLeft) ;

    public void setWidth(int width);

    public int getHeight();

    public void setHeight(int height);

    public int getZIndex() ;

    public void setZIndex(int ZIndex) ;

    public Boolean getVisible();

    public void setVisible(Boolean visible);
}
