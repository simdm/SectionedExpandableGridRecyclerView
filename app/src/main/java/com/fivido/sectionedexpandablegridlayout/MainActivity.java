package com.fivido.sectionedexpandablegridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.fivido.sectionedexpandablegridlayout.adapters.ItemClickListener;
import com.fivido.sectionedexpandablegridlayout.adapters.Section;
import com.fivido.sectionedexpandablegridlayout.adapters.SectionedExpandableLayoutHelper;
import com.fivido.sectionedexpandablegridlayout.models.Item;
import com.fivido.sectionedexpandablegridlayout.models.PoiSection;
import com.fivido.sectionedexpandablegridlayout.models.PoiSectionHeader;

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

        //random data1
        ArrayList<PoiSection> poiSectionList1 = new ArrayList<PoiSection>();

        //Poi1
        PoiSection poiSection = new PoiSection();
        poiSection.setPoiSectionHeader(new PoiSectionHeader("Poi1"));
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("iPhone", 0));
        itemList.add(new Item("iPad", 1));
        itemList.add(new Item("iPod", 2));
        itemList.add(new Item("iMac", 3));
        poiSection.setItemList(itemList);
        poiSectionList1.add(poiSection);

        //Poi2
        PoiSection poiSection2 = new PoiSection();
        poiSection2.setPoiSectionHeader(new PoiSectionHeader("Poi2"));
        List<Item> itemList2 = new ArrayList<>();
        itemList2.add(new Item("iPhone", 0));
        itemList2.add(new Item("iPad", 1));
        itemList2.add(new Item("iPod", 2));
        itemList2.add(new Item("iMac", 3));
        itemList2.add(new Item("iMac", 4));
        poiSection2.setItemList(itemList2);
        poiSectionList1.add(poiSection2);

        //Poi3
        PoiSection poiSection3 = new PoiSection();
        poiSection3.setPoiSectionHeader(new PoiSectionHeader("Poi3"));
        List<Item> itemList3 = new ArrayList<>();
        itemList3.add(new Item("iPhone", 0));
        itemList3.add(new Item("iPad", 1));
        itemList3.add(new Item("iPod", 2));
        itemList3.add(new Item("iMac", 3));
        poiSection3.setItemList(itemList3);
        poiSectionList1.add(poiSection3);

        sectionedExpandableLayoutHelper.addSection("Apple Products", poiSectionList1);


        //random data2
        ArrayList<PoiSection> poiSectionList2 = new ArrayList<PoiSection>();

        //Poi4
        PoiSection poiSection4 = new PoiSection();
        poiSection4.setPoiSectionHeader(new PoiSectionHeader("Poi4"));
        List<Item> itemList4 = new ArrayList<>();
        itemList4.add(new Item("iPhone", 0));
        itemList4.add(new Item("iPad", 1));
        itemList4.add(new Item("iPad1", 2));
        itemList4.add(new Item("iPad2", 3));
        itemList4.add(new Item("iPad3", 4));
        itemList4.add(new Item("iPad4", 5));
        itemList4.add(new Item("iPad5", 6));
        itemList4.add(new Item("iPad6", 7));
        itemList4.add(new Item("iPad7", 8));
        itemList4.add(new Item("iPad8", 9));
        itemList4.add(new Item("iPad9", 10));
        itemList4.add(new Item("iPad10", 11));
        itemList4.add(new Item("iPad11", 12));
        poiSection4.setItemList(itemList4);
        poiSectionList2.add(poiSection4);

        //Poi5
        PoiSection poiSection5 = new PoiSection();
        poiSection5.setPoiSectionHeader(new PoiSectionHeader("Poi5"));
        List<Item> itemList5 = new ArrayList<>();
        itemList5.add(new Item("iPod", 2));
        itemList5.add(new Item("iMac", 3));
        poiSection5.setItemList(itemList5);
        poiSectionList2.add(poiSection5);

        //Poi6
        PoiSection poiSection6 = new PoiSection();
        poiSection6.setPoiSectionHeader(new PoiSectionHeader("Poi6"));
        List<Item> itemList6 = new ArrayList<>();
        itemList6.add(new Item("iPhone", 0));
        itemList6.add(new Item("iPad", 1));
        itemList6.add(new Item("iPod", 2));
        itemList6.add(new Item("iMac1", 3));
        itemList6.add(new Item("iMac2", 4));
        itemList6.add(new Item("iMac3", 5));
        itemList6.add(new Item("iMac4", 6));
        poiSection6.setItemList(itemList6);
        poiSectionList2.add(poiSection6);

        sectionedExpandableLayoutHelper.addSection("dm Products", poiSectionList2);


        sectionedExpandableLayoutHelper.notifyDataSetChanged();

//        //21
//        ArrayList<Item> itemList21 = new ArrayList<>();
//        itemList21 = new ArrayList<>();
//        itemList21.add(new Item("LG", 0));
//        itemList21.add(new Item("Apple", 1));
//        itemList21.add(new Item("Samsung", 2));
//        itemList21.add(new Item("Motorola", 3));
//        itemList21.add(new Item("Sony", 4));
//        itemList21.add(new Item("Nokia", 5));
//        sectionedExpandableLayoutHelper.addSection("Companies", itemList21);
//
//        //31
//        ArrayList<Item> itemList31 = new ArrayList<>();
//        itemList31 = new ArrayList<>();
//        itemList31.add(new Item("Chocolate", 0));
//        itemList31.add(new Item("Strawberry", 1));
//        itemList31.add(new Item("Vanilla", 2));
//        itemList31.add(new Item("Butterscotch", 3));
//        itemList31.add(new Item("Grape", 4));
//        sectionedExpandableLayoutHelper.addSection("Ice cream", itemList31);



//        //checking if adding single item works
//        sectionedExpandableLayoutHelper.addItem("Ice cream", new Item("Tutti frutti",5));
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

    }

    @Override
    public void itemClicked(Section section) {
        Toast.makeText(this, "Section: " + section.getName() + " clicked", Toast.LENGTH_SHORT).show();
    }
}
