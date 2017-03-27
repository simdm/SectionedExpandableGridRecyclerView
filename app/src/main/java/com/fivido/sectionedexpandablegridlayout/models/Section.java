package com.fivido.sectionedexpandablegridlayout.models;

/**
 * Created by demeng on 3/27/17.
 */
public class Section {

    private final String name;

    public boolean isExpanded;

    public Section(String name) {
        this.name = name;
        isExpanded = false;
    }

    public String getName() {
        return name;
    }

}
