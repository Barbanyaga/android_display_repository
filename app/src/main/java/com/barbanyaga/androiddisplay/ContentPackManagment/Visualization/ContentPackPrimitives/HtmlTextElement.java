package com.barbanyaga.androiddisplay.ContentPackManagment.Visualization.ContentPackPrimitives;

/**
 * Created by barbanyaga on 23.02.2015.
 */
public class HtmlTextElement extends BasePrimitiveElement {
    public HtmlTextElement(int marginLeft, int marginTop, int width, int height, int ZIndex) {
        MarginTop = marginTop;
        MarginLeft = marginLeft;
        Width = width;
        Height = height;
        this.ZIndex = ZIndex;
        elementType = DisplayElementType.HtmlText;
        visible = true;
    }
}
