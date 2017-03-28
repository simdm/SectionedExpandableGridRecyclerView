package com.fivido.sectionedexpandablegridlayout.album;

import java.util.List;

/**
 * Created by demeng on 3/20/17.
 */

public class ImageFolder {

    public String name;
    public String path;
    public List<String> images;

    public ImageFolder() {
    }

    public ImageFolder(String name, String path, List<String> images) {
        this.name = name;
        this.path = path;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}