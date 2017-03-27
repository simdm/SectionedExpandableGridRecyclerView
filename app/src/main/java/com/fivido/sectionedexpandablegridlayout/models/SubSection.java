package com.fivido.sectionedexpandablegridlayout.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by demeng on 3/24/17.
 */

public class SubSection {

    private SubSectionHeader subSectionHeader;
    private List<Item> itemList = new ArrayList<Item>();

    public SubSectionHeader getSubSectionHeader() {
        return subSectionHeader;
    }

    public void setSubSectionHeader(SubSectionHeader subSectionHeader) {
        this.subSectionHeader = subSectionHeader;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
