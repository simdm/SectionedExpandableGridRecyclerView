package com.fivido.sectionedexpandablegridlayout.models;

/**
 * Created by demeng on 3/27/17.
 */
public class Item {

    private final String name;
    private final String id;
    private boolean checked;

    public Item(String name, String id, boolean checked) {
        this.name = name;
        this.id = id;
        this.checked = checked;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
