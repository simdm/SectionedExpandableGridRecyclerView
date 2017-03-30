package com.fivido.sectionedexpandablegridlayout.adapters;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fivido.sectionedexpandablegridlayout.models.Item;
import com.fivido.sectionedexpandablegridlayout.models.SubSection;
import com.fivido.sectionedexpandablegridlayout.models.Section;
import com.fivido.sectionedexpandablegridlayout.models.SubSectionHeader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by demeng on 3/27/17.
 */
public class SectionedExpandableLayoutHelper implements SectionStateChangeListener {

    //data list
    private LinkedHashMap<Section, ArrayList<SubSection>> mSectionDataMap = new LinkedHashMap<Section, ArrayList<SubSection>>();
    private ArrayList<Object> mDataArrayList = new ArrayList<Object>();

    //section map
    //TODO : look for a way to avoid this
    private HashMap<String, Section> mSectionMap = new HashMap<String, Section>();

    //adapter
    private SectionedExpandableGridAdapter mSectionedExpandableGridAdapter;

    private Section sectionSelect;

    //recycler view
    RecyclerView mRecyclerView;

    public SectionedExpandableLayoutHelper(Context context, RecyclerView recyclerView, ItemClickListener itemClickListener,
                                           int gridSpanCount) {

        //setting the recycler view
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, gridSpanCount);
        recyclerView.setLayoutManager(gridLayoutManager);
        mSectionedExpandableGridAdapter = new SectionedExpandableGridAdapter(context, mDataArrayList,
                gridLayoutManager, itemClickListener, this);
        recyclerView.setAdapter(mSectionedExpandableGridAdapter);

        mRecyclerView = recyclerView;
    }

    public void notifyDataSetChanged() {
        //TODO : handle this condition such that these functions won't be called if the recycler view is on scroll
        generateDataList();
        mSectionedExpandableGridAdapter.notifyDataSetChanged();
    }

    public void addSection(String section, ArrayList<SubSection> subSectionList) {
        Section newSection;
        mSectionMap.put(section, (newSection = new Section(section)));
        mSectionDataMap.put(newSection, subSectionList);
    }

    public void addItem(String section, String subSectionheader, Item item) {
        ArrayList<SubSection> subSectionList = mSectionDataMap.get(mSectionMap.get(section));

        if (subSectionList == null) {
            return;
        }

        for (SubSection subSection:subSectionList) {
            if (subSection.getSubSectionHeader().getName().equalsIgnoreCase(subSectionheader)) {
                subSection.getItemList().add(item);
            }
        }
    }

//
//    public void removeItem(String section, Item item) {
//        mSectionDataMap.get(mSectionMap.get(section)).remove(item);
//    }
//
//    public void removeSection(String section) {
//        mSectionDataMap.remove(mSectionMap.get(section));
//        mSectionMap.remove(section);
//    }

    private void generateDataList () {

        mDataArrayList.clear();

        for (Map.Entry<Section, ArrayList<SubSection>> entry : mSectionDataMap.entrySet()) {
            Section key;
            mDataArrayList.add((key = entry.getKey()));

//            if (sectionSelect != null && !key.getName().equalsIgnoreCase(sectionSelect.getName())) {
//                key.isExpanded = false;
//            }

            if (key.isExpanded) {
                ArrayList<SubSection> subSectionList = entry.getValue();
                for (SubSection subSection : subSectionList) {
                    mDataArrayList.add(subSection.getSubSectionHeader());
                    mDataArrayList.addAll(subSection.getItemList());
                }
            }
        }
    }

    @Override
    public void onSectionStateChanged(Section section, boolean isOpen) {
        if (!mRecyclerView.isComputingLayout()) {
            section.isExpanded = isOpen;

//            sectionSelect = section;

            notifyDataSetChanged();

//            mRecyclerView.scrollToPosition(0);
        }
    }
}
