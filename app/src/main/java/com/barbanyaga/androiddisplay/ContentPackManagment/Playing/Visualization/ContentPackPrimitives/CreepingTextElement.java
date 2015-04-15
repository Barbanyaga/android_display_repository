package com.barbanyaga.androiddisplay.ContentPackManagment.Playing.Visualization.ContentPackPrimitives;

import com.barbanyaga.androiddisplay.ContentPackManagment.Playing.Visualization.ContentPackPrimitives.Base.BasePrimitiveElement;
import com.barbanyaga.androiddisplay.ContentPackManagment.Playing.Visualization.ContentPackPrimitives.Base.DisplayElementType;

/**
 * Created by barbanyaga on 21.02.2015.
 */
public class CreepingTextElement
        extends BasePrimitiveElement
{
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CreepingTextElement(String text, int marginLeft, int marginTop, int width, int height, int ZIndex) {
        this.text = text;
        MarginTop = marginTop;
        MarginLeft = marginLeft;
        Width = width;
        Height = height;
        this.ZIndex = ZIndex;
        elementType = DisplayElementType.CreepingText;
    }
}
