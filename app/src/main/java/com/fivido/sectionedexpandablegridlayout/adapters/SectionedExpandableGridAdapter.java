package com.fivido.sectionedexpandablegridlayout.adapters;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.fivido.sectionedexpandablegridlayout.R;
import com.fivido.sectionedexpandablegridlayout.models.Item;
import com.fivido.sectionedexpandablegridlayout.models.Section;
import com.fivido.sectionedexpandablegridlayout.models.SubSectionHeader;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by demeng on 3/27/17.
 */
public class SectionedExpandableGridAdapter extends RecyclerView.Adapter<SectionedExpandableGridAdapter.ViewHolder> {

    //data array
    private ArrayList<Object> mDataArrayList;

    //context
    private final Context mContext;

    //listeners
    private final ItemClickListener mItemClickListener;
    private final SectionStateChangeListener mSectionStateChangeListener;

    //view type
    private static final int VIEW_TYPE_SECTION = R.layout.layout_section;
    private static final int VIEW_TYPE_POI_SECTION = R.layout.layout_sub_section;
    private static final int VIEW_TYPE_ITEM = R.layout.layout_item; //TODO : change this

    public SectionedExpandableGridAdapter(Context context, ArrayList<Object> dataArrayList,
                                          final GridLayoutManager gridLayoutManager, ItemClickListener itemClickListener,
                                          SectionStateChangeListener sectionStateChangeListener) {
        mContext = context;
        mItemClickListener = itemClickListener;
        mSectionStateChangeListener = sectionStateChangeListener;
        mDataArrayList = dataArrayList;

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

                if (isSection(position)) {
                    return gridLayoutManager.getSpanCount();
                } else if (isPoiSectionHeader(position)) {
                    return gridLayoutManager.getSpanCount();
                } else {
                    return 1;
                }
            }
        });
    }

    private boolean isSection(int position) {
        return mDataArrayList.get(position) instanceof Section;
    }
    private boolean isPoiSectionHeader(int position) {
        return mDataArrayList.get(position) instanceof SubSectionHeader;
    }

    private void setCheckImageView(ViewHolder holder, Item item) {
        if (item.isChecked()) {
            holder.checkImageView.setImageResource(R.drawable.ic_keyboard_arrow_down_black_18dp);
        } else {
            holder.checkImageView.setImageResource(R.drawable.ic_keyboard_arrow_up_black_18dp);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(viewType, parent, false), viewType);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        switch (holder.viewType) {
            case VIEW_TYPE_ITEM :
                final Item item = (Item) mDataArrayList.get(position);

                File imageFile = new File(item.getName());
                if (imageFile.exists()) {
                    Picasso.with(mContext)
                            .load(imageFile)
                            .placeholder(R.drawable.default_icon)
                            .resize(100, 100)
                            .centerCrop()
                            .into(holder.itemImageView);
                }
                else {
                    holder.itemImageView.setImageResource(R.drawable.default_icon);
                }


                setCheckImageView(holder, item);

                holder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        item.setChecked(!item.isChecked());
                        setCheckImageView(holder, item);
                        mItemClickListener.itemClicked(item);
                    }
                });
                break;
            case VIEW_TYPE_POI_SECTION :
                final SubSectionHeader subSectionHeader = (SubSectionHeader) mDataArrayList.get(position);
                holder.poiSectionTextView.setText(subSectionHeader.getName());
                break;
            case VIEW_TYPE_SECTION :
                final Section section = (Section) mDataArrayList.get(position);
                holder.sectionTextView.setText(section.getName());
                holder.sectionTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mItemClickListener.itemClicked(section);
                    }
                });

                holder.sectionToggleButton.setChecked(section.isExpanded);

                holder.sectionToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        mSectionStateChangeListener.onSectionStateChanged(section, isChecked);
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mDataArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (isSection(position)) {
            return VIEW_TYPE_SECTION;
        } else if (isPoiSectionHeader(position)) {
            return VIEW_TYPE_POI_SECTION;
        } else {
            return VIEW_TYPE_ITEM;
        }
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        //common
        View view;
        int viewType;

        //for section
        TextView sectionTextView;
        ToggleButton sectionToggleButton;

        //for item
        ImageView itemImageView;
        ImageView checkImageView;

        //for Poi section
        TextView poiSectionTextView;

        public ViewHolder(View view, int viewType) {
            super(view);
            this.viewType = viewType;
            this.view = view;
            if (viewType == VIEW_TYPE_ITEM) {
                itemImageView = (ImageView) view.findViewById(R.id.image_item);
                checkImageView = (ImageView) view.findViewById(R.id.image_check);
            } else if (viewType == VIEW_TYPE_POI_SECTION) {
                poiSectionTextView = (TextView) view.findViewById(R.id.sub_section_name);
            } else {
                sectionTextView = (TextView) view.findViewById(R.id.text_section);
                sectionToggleButton = (ToggleButton) view.findViewById(R.id.toggle_button_section);
            }
        }
    }
}
