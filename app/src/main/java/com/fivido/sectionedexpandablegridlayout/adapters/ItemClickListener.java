package com.fivido.sectionedexpandablegridlayout.adapters;

import com.fivido.sectionedexpandablegridlayout.models.Item;
import com.fivido.sectionedexpandablegridlayout.models.Section;

/**
 * Created by demeng on 3/27/17.
 */
public interface ItemClickListener {
    void itemClicked(Item item);
    void itemClicked(Section section);
}
