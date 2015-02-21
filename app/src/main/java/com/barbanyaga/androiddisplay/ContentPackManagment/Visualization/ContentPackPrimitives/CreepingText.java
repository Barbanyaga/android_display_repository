package com.barbanyaga.androiddisplay.ContentPackManagment.Visualization.ContentPackPrimitives;

/**
 * Created by barbanyaga on 21.02.2015.
 */
public class CreepingText extends BasePrimitive
{
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CreepingText(String text, int marginLeft, int marginTop,  int width, int height, int ZIndex) {
        this.text = text;
        MarginTop = marginTop;
        MarginLeft = marginLeft;
        Width = width;
        Height = height;
        this.ZIndex = ZIndex;
    }
}
