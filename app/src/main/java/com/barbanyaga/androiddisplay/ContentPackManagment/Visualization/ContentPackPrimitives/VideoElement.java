package com.barbanyaga.androiddisplay.ContentPackManagment.Visualization.ContentPackPrimitives;

/**
 * Created by barbanyaga on 23.02.2015.
 */
public class VideoElement extends BasePrimitiveElement {
    private String pathToFile;


    public VideoElement(String pathToFile, int marginLeft, int marginTop, int width, int height, int ZIndex) {
        this.pathToFile = pathToFile;
        MarginTop = marginTop;
        MarginLeft = marginLeft;
        Width = width;
        Height = height;
        this.ZIndex = ZIndex;
        elementType = DisplayElementType.Video;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }
}
