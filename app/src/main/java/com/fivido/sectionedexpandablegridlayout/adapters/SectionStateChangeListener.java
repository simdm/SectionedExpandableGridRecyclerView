package com.fivido.sectionedexpandablegridlayout.adapters;

/**
 * Created by demeng on 3/27/17.
 */

import com.fivido.sectionedexpandablegridlayout.models.Section;

/**
 * interface to listen changes in state of sections
 */
public interface SectionStateChangeListener {
    void onSectionStateChanged(Section section, boolean isOpen);
}