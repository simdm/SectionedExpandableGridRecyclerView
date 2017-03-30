package com.fivido.sectionedexpandablegridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.fivido.sectionedexpandablegridlayout.adapters.ItemClickListener;
import com.fivido.sectionedexpandablegridlayout.album.AlbumHelper;
import com.fivido.sectionedexpandablegridlayout.album.ImageFolder;
import com.fivido.sectionedexpandablegridlayout.album.LoadLocalPhoto;
import com.fivido.sectionedexpandablegridlayout.models.Section;
import com.fivido.sectionedexpandablegridlayout.adapters.SectionedExpandableLayoutHelper;
import com.fivido.sectionedexpandablegridlayout.models.Item;
import com.fivido.sectionedexpandablegridlayout.models.SubSection;
import com.fivido.sectionedexpandablegridlayout.models.SubSectionHeader;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements ItemClickListener {

    RecyclerView mRecyclerView;
    SectionedExpandableLayoutHelper sectionedExpandableLayoutHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting the recycler view
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        sectionedExpandableLayoutHelper = new SectionedExpandableLayoutHelper(this,
                mRecyclerView, this, 4);

        new LoadLocalPhoto(this).setLoadFinishCallback(new LoadLocalPhoto.LoadFinishCallback() {
            @Override
            public void finish(List<ImageFolder> folderList) {

//                ArrayList<SubSection> subSectionList1 = new ArrayList<SubSection>();
//
//                //Poi1
//                SubSection subSection = new SubSection();
//                subSection.setSubSectionHeader(new SubSectionHeader("Poi1"));
//                List<Item> itemList = new ArrayList<>();
//
//                for (ImageFolder imageFolder : folderList) {
//                    Log.e("aaa", "name:" + imageFolder.name);
//                    Log.e("aaa", "path:" + imageFolder.path);
//                    for (String image : imageFolder.images) {
//                        Log.e("aaa", "image:" + image);
//
//                        itemList.add(new Item(image, "0", false));
//
//                        AlbumHelper.getPhotoLocation(image);
//
//                    }
//                }
//
//                subSection.setItemList(itemList);
//                subSectionList1.add(subSection);
//
//                sectionedExpandableLayoutHelper.addSection("Apple Products", subSectionList1);
//
//                sectionedExpandableLayoutHelper.notifyDataSetChanged();

            }
        });


        //random data1
        ArrayList<SubSection> subSectionList1 = new ArrayList<SubSection>();

        //Poi1
        SubSection subSection = new SubSection();
        subSection.setSubSectionHeader(new SubSectionHeader("Poi1"));
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("iPhone", "0", false));
        itemList.add(new Item("iPad", "1", false));
        itemList.add(new Item("iPod", "2", false));
        itemList.add(new Item("iMac", "3", false));
        subSection.setItemList(itemList);
        subSectionList1.add(subSection);

        //Poi2
        SubSection subSection2 = new SubSection();
        subSection2.setSubSectionHeader(new SubSectionHeader("Poi2"));
        List<Item> itemList2 = new ArrayList<>();
        itemList2.add(new Item("iPhone", "7", false));
        itemList2.add(new Item("iPad", "8", false));
        itemList2.add(new Item("iPod", "9", false));
        itemList2.add(new Item("iMac", "10", false));
        itemList2.add(new Item("iMac", "11", false));
        subSection2.setItemList(itemList2);
        subSectionList1.add(subSection2);

        //Poi3
        SubSection subSection3 = new SubSection();
        subSection3.setSubSectionHeader(new SubSectionHeader("Poi3"));
        List<Item> itemList3 = new ArrayList<>();
        itemList3.add(new Item("iPhone", "12", false));
        itemList3.add(new Item("iPad", "13", false));
        itemList3.add(new Item("iPod", "14", false));
        itemList3.add(new Item("iMac", "15", false));
        subSection3.setItemList(itemList3);
        subSectionList1.add(subSection3);

        sectionedExpandableLayoutHelper.addSection("Apple Products", subSectionList1);


        //random data2
        ArrayList<SubSection> subSectionList2 = new ArrayList<SubSection>();

        //Poi4
        SubSection subSection4 = new SubSection();
        subSection4.setSubSectionHeader(new SubSectionHeader("Poi4"));
        List<Item> itemList4 = new ArrayList<>();
        itemList4.add(new Item("iPhone", "16", false));
        itemList4.add(new Item("iPad", "17", false));
        itemList4.add(new Item("iPad1", "18", false));
        itemList4.add(new Item("iPad2", "19", false));
        itemList4.add(new Item("iPad3", "20", false));
        itemList4.add(new Item("iPad4", "21", false));
        itemList4.add(new Item("iPad5", "22", false));
        itemList4.add(new Item("iPad6", "23", false));
        itemList4.add(new Item("iPad7", "24", false));
        itemList4.add(new Item("iPad8", "25", false));
        itemList4.add(new Item("iPad9", "26", false));
        itemList4.add(new Item("iPad10", "27", false));
        itemList4.add(new Item("iPad11", "28", false));
        subSection4.setItemList(itemList4);
        subSectionList2.add(subSection4);

        //Poi5
        SubSection subSection5 = new SubSection();
        subSection5.setSubSectionHeader(new SubSectionHeader("Poi5"));
        List<Item> itemList5 = new ArrayList<>();
        itemList5.add(new Item("iPod", "29", false));
        itemList5.add(new Item("iMac", "30", false));
        subSection5.setItemList(itemList5);
        subSectionList2.add(subSection5);

        //Poi6
        SubSection subSection6 = new SubSection();
        subSection6.setSubSectionHeader(new SubSectionHeader("Poi6"));
        List<Item> itemList6 = new ArrayList<>();
        itemList6.add(new Item("iPhone", "31", false));
        itemList6.add(new Item("iPad", "32", false));
        itemList6.add(new Item("iPod", "33", false));
        itemList6.add(new Item("iMac1", "34", false));
        itemList6.add(new Item("iMac2", "35", false));
        itemList6.add(new Item("iMac3", "36", false));
        itemList6.add(new Item("iMac4", "37", false));
        subSection6.setItemList(itemList6);
        subSectionList2.add(subSection6);

        sectionedExpandableLayoutHelper.addSection("dm Products", subSectionList2);


        sectionedExpandableLayoutHelper.notifyDataSetChanged();

//        //checking if adding single item works
//        sectionedExpandableLayoutHelper.addItem("Ice cream", "Poi2", new Item("555555",5));
//        sectionedExpandableLayoutHelper.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void itemClicked(Item item) {
        Toast.makeText(this, "Item: " + item.getName() + " clicked", Toast.LENGTH_SHORT).show();

//        //checking if adding single item works
//        sectionedExpandableLayoutHelper.addItem("Apple Products", "Poi2", new Item("555555", "38", true));
//        sectionedExpandableLayoutHelper.notifyDataSetChanged();

    }

    @Override
    public void itemClicked(Section section) {
        Toast.makeText(this, "Section: " + section.getName() + " clicked", Toast.LENGTH_SHORT).show();
    }
}
