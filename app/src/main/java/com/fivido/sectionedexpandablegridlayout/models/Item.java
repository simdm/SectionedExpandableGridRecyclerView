package com.fivido.sectionedexpandablegridlayout.models;

/**
 * Created by demeng on 3/27/17.
 */
public class Item {

    private final String name;
    private final int id;

    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
