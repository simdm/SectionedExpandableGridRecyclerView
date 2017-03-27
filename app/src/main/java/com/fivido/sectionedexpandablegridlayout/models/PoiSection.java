package com.fivido.sectionedexpandablegridlayout.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by demeng on 3/24/17.
 */

public class PoiSection {

    private PoiSectionHeader poiSectionHeader;
    private List<Item> itemList = new ArrayList<Item>();

    public PoiSectionHeader getPoiSectionHeader() {
        return poiSectionHeader;
    }

    public void setPoiSectionHeader(PoiSectionHeader poiSectionHeader) {
        this.poiSectionHeader = poiSectionHeader;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
