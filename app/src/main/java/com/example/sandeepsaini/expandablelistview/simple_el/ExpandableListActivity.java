package com.example.sandeepsaini.expandablelistview.simple_el;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sandeepsaini.expandablelistview.R;
import com.example.sandeepsaini.expandablelistview.data_preview.SelectedDataPreviewActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExpandableListActivity extends AppCompatActivity {


    @BindView(R.id.toolbar_back_button_iv)
    ImageView toolbarBackButtonIV;
    @BindView(R.id.toolbar_title_tv)
    TextView toolbarTitleTV;

    @BindView(R.id.expandable_list_view)
    ExpandableListView expandableListView;
    @BindView(R.id.preview_tv)
    TextView previewTV;

    private ArrayList<String> fruitCategoryList;
    private HashMap<String, ArrayList<String>> fruitNameList;

    private ArrayList<String> selectedFruitCategoryList;
    private ArrayList<String> selectedFruitNameList;

    private HashMap<String, ArrayList<String>> selectedDataHM = new HashMap<String, ArrayList<String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);
        ButterKnife.bind(this);

        toolbarTitleTV.setText(getResources().getString(R.string.expandable_list_activity));

        setUpDataReferences();

        ExpandableListAdapter expandableListAdapter = new ExpandableListAdapter(this, fruitCategoryList, fruitNameList);

        expandableListView.setAdapter(expandableListAdapter);

        setUpExpandableListClickListeners();
    }

    private void setUpExpandableListClickListeners() {

        selectedFruitCategoryList = new ArrayList<>();
        selectedFruitNameList = new ArrayList<>();

        // Listview Group click listener
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
//                 Toast.makeText(getApplicationContext(),
//                 "Group Clicked " + fruitCategoryList.get(groupPosition),
//                 Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        fruitCategoryList.get(groupPosition) + " Expanded",
//                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        fruitCategoryList.get(groupPosition) + " Collapsed",
//                        Toast.LENGTH_SHORT).show();

            }
        });


        // Listview on child click listener
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                String fruitCategory = fruitCategoryList.get(groupPosition);
                String fruitName = fruitNameList.get(fruitCategoryList.get(groupPosition)).get(childPosition);

                if (selectedDataHM.containsKey(fruitCategory)) {
                    ArrayList<String> arrayList = selectedDataHM.get(fruitCategory);
                    arrayList.add(fruitName);
                    selectedDataHM.put(fruitCategory, arrayList);
                } else {
                    selectedDataHM.put(fruitCategory, new ArrayList<String>());
                    ArrayList<String> arrayList = selectedDataHM.get(fruitCategory);
                    arrayList.add(fruitName);
                    selectedDataHM.put(fruitCategory, arrayList);
                }

                Toast.makeText(
                        getApplicationContext(),
                        fruitCategoryList.get(groupPosition)
                                + " : "
                                + fruitNameList.get(
                                fruitCategoryList.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    private void setUpDataReferences() {

        fruitCategoryList = new ArrayList<String>();
        fruitNameList = new HashMap<String, ArrayList<String>>();

        String[] categoryString = getResources().getStringArray(R.array.fruit_category);
        fruitCategoryList.addAll(Arrays.asList(categoryString));

        String[] berriesString = getResources().getStringArray(R.array.berries);
        ArrayList<String> berriesList = new ArrayList<>(Arrays.asList(berriesString));

        String[] citrusFruitString = getResources().getStringArray(R.array.citrus_fruit);
        ArrayList<String> citrusFruitList = new ArrayList<>(Arrays.asList(citrusFruitString));

        String[] melonsString = getResources().getStringArray(R.array.melons);
        ArrayList<String> melonsList = new ArrayList<>(Arrays.asList(melonsString));

        String[] tropicalFruitString = getResources().getStringArray(R.array.tropical_fruits);
        ArrayList<String> tropicalFruitList = new ArrayList<>(Arrays.asList(tropicalFruitString));

        String[] coreString = getResources().getStringArray(R.array.core);
        ArrayList<String> coreFruitList = new ArrayList<>(Arrays.asList(coreString));

        fruitNameList.put(fruitCategoryList.get(0), berriesList);
        fruitNameList.put(fruitCategoryList.get(1), citrusFruitList);
        fruitNameList.put(fruitCategoryList.get(2), melonsList);
        fruitNameList.put(fruitCategoryList.get(3), tropicalFruitList);
        fruitNameList.put(fruitCategoryList.get(4), coreFruitList);
    }

    @OnClick(R.id.toolbar_back_button_iv)
    void onToolbarBackButtonClick(View view) {
        finish();
    }

    @OnClick(R.id.preview_tv)
    void onPreviewTvClick(View view) {
        Intent intent = new Intent(this, SelectedDataPreviewActivity.class);
        intent.putExtra("DataList", selectedDataHM);
        startActivity(intent);
    }
}
