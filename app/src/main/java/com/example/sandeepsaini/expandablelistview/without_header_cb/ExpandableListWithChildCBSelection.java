package com.example.sandeepsaini.expandablelistview.without_header_cb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sandeepsaini.expandablelistview.ConstantManager;
import com.example.sandeepsaini.expandablelistview.R;
import com.example.sandeepsaini.expandablelistview.data_preview.SelectedDataPreviewActivity;
import com.example.sandeepsaini.expandablelistview.model.FruitCategory;
import com.example.sandeepsaini.expandablelistview.model.FruitNames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExpandableListWithChildCBSelection extends AppCompatActivity {


    @BindView(R.id.toolbar_back_button_iv)
    ImageView toolbarBackButtonIV;
    @BindView(R.id.toolbar_title_tv)
    TextView toolbarTitleTV;

    @BindView(R.id.expandable_list_view)
    ExpandableListView expandableListView;
    @BindView(R.id.preview_tv)
    TextView previewTV;
    @BindView(R.id.done_tv)
    TextView doneTV;

    private HashMap<String, ArrayList<String>> selectedDataHM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_with_child_cbselection);
        ButterKnife.bind(this);

        toolbarTitleTV.setText(getResources().getString(R.string.check_box_el));
        setupReferences();
    }

    private void setupReferences() {

        ArrayList<FruitCategory> fruitCategoryArrayList = new ArrayList<>();
        ArrayList<FruitNames> fruitNamesArrayList = new ArrayList<>();

        ArrayList<HashMap<String, String>> parentItems = new ArrayList<>();
        ArrayList<ArrayList<HashMap<String, String>>> childItems = new ArrayList<>();

        int count = 0;

        String[] categoryString = getResources().getStringArray(R.array.fruit_category);
        ArrayList<String> categoryArrayList = new ArrayList<>(Arrays.asList(categoryString));
        String[] berriesString = getResources().getStringArray(R.array.berries);
        String[] citrusFruitString = getResources().getStringArray(R.array.citrus_fruit);
        String[] melonsString = getResources().getStringArray(R.array.melons);
        String[] tropicalFruitString = getResources().getStringArray(R.array.tropical_fruits);
        String[] coreString = getResources().getStringArray(R.array.core);

        // adding berries fruit list
        FruitCategory fruitCategory = new FruitCategory();
        fruitCategory.setCategoryID("0");
        fruitCategory.setCategoryName(categoryString[0]);

        fruitNamesArrayList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            FruitNames fruitNames = new FruitNames();
            fruitNames.setCategoryId(String.valueOf(i));
            fruitNames.setCategoryName(categoryString[0]);
            fruitNames.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_FALSE);
            fruitNames.setFruitName(berriesString[i]);
            fruitNamesArrayList.add(fruitNames);
        }
        fruitCategory.setFruitsNameList(fruitNamesArrayList);
        fruitCategoryArrayList.add(fruitCategory);

        // adding citrus fruit list
        fruitCategory = new FruitCategory();
        fruitCategory.setCategoryID("1");
        fruitCategory.setCategoryName(categoryString[1]);

        fruitNamesArrayList = new ArrayList<>();
        count = 0;
        for (int i = 6; i < 11; i++) {
            FruitNames fruitNames = new FruitNames();
            fruitNames.setCategoryId(String.valueOf(i));
            fruitNames.setCategoryName(categoryString[1]);
            fruitNames.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_FALSE);
            fruitNames.setFruitName(citrusFruitString[count]);
            fruitNamesArrayList.add(fruitNames);
            count++;
        }
        fruitCategory.setFruitsNameList(fruitNamesArrayList);
        fruitCategoryArrayList.add(fruitCategory);

        // adding melons fruit list
        fruitCategory = new FruitCategory();
        fruitCategory.setCategoryID("2");
        fruitCategory.setCategoryName(categoryString[2]);

        fruitNamesArrayList = new ArrayList<>();
        count = 0;
        for (int i = 11; i < 15; i++) {
            FruitNames fruitNames = new FruitNames();
            fruitNames.setCategoryId(String.valueOf(i));
            fruitNames.setCategoryName(categoryString[2]);
            fruitNames.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_FALSE);
            fruitNames.setFruitName(melonsString[count]);
            fruitNamesArrayList.add(fruitNames);
            count++;
        }
        fruitCategory.setFruitsNameList(fruitNamesArrayList);
        fruitCategoryArrayList.add(fruitCategory);

        // adding tropical fruit list
        fruitCategory = new FruitCategory();
        fruitCategory.setCategoryID("3");
        fruitCategory.setCategoryName(categoryString[3]);

        fruitNamesArrayList = new ArrayList<>();
        count = 0;
        for (int i = 15; i < 26; i++) {
            FruitNames fruitNames = new FruitNames();
            fruitNames.setCategoryId(String.valueOf(i));
            fruitNames.setCategoryName(categoryString[3]);
            fruitNames.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_FALSE);
            fruitNames.setFruitName(tropicalFruitString[count]);
            fruitNamesArrayList.add(fruitNames);
            count++;
        }
        fruitCategory.setFruitsNameList(fruitNamesArrayList);
        fruitCategoryArrayList.add(fruitCategory);

        // adding core fruit list
        fruitCategory = new FruitCategory();
        fruitCategory.setCategoryID("4");
        fruitCategory.setCategoryName(categoryString[4]);

        fruitNamesArrayList = new ArrayList<>();
        count = 0;
        for (int i = 26; i < 28; i++) {
            FruitNames fruitNames = new FruitNames();
            fruitNames.setCategoryId(String.valueOf(i));
            fruitNames.setCategoryName(categoryString[4]);
            fruitNames.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_FALSE);
            fruitNames.setFruitName(coreString[count]);
            fruitNamesArrayList.add(fruitNames);
            count++;
        }
        fruitCategory.setFruitsNameList(fruitNamesArrayList);
        fruitCategoryArrayList.add(fruitCategory);

        // Preparing main data list
        for (FruitCategory category : fruitCategoryArrayList) {
            ArrayList<HashMap<String, String>> childItemsArrayList = new ArrayList<HashMap<String, String>>();
//            HashMap<String, String> mapParent = new HashMap<String, String>(); // it has header name and it's id
//            mapParent.put(ConstantManager.Parameter.CATEGORY_ID, category.getCategoryID()); // setting header id
//            mapParent.put(ConstantManager.Parameter.CATEGORY_NAME, category.getCategoryName()); // setting header name
//            int countIsChecked = 0;
            for (FruitNames names : category.getFruitsNameList()) {
                HashMap<String, String> mapChild = new HashMap<String, String>();
                mapChild.put(ConstantManager.Parameter.SUB_ID, names.getFruitId());  // setting the child id
                mapChild.put(ConstantManager.Parameter.SUB_CATEGORY_NAME, names.getFruitName()); // child name
                mapChild.put(ConstantManager.Parameter.CATEGORY_NAME, names.getCategoryName()); // setting header name
                mapChild.put(ConstantManager.Parameter.CATEGORY_ID, names.getCategoryId());// header id
                mapChild.put(ConstantManager.Parameter.IS_CHECKED, names.getIsChecked()); // check box state
//                if (names.getIsChecked().equalsIgnoreCase(ConstantManager.CHECK_BOX_CHECKED_TRUE)) {
//                    countIsChecked++;
//                }
                childItemsArrayList.add(mapChild);
            }
//            // setting header check box state
//            if (countIsChecked == category.getFruitsNameList().size()) {
//                category.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_TRUE);
//            } else {
//                category.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_FALSE);
//            }
            childItems.add(childItemsArrayList);
        }
        ConstantManager.parentItems = parentItems;
        ConstantManager.childItems = childItems;


        ExpandableListChildCBAdapter expandableListChildCBAdapter = new ExpandableListChildCBAdapter(this, categoryArrayList, childItems);
        expandableListView.setAdapter(expandableListChildCBAdapter);

    }

    private void getSelectedData() {
        ArrayList<ArrayList<HashMap<String, String>>> fruitsHM = new ArrayList<>();
        ArrayList<HashMap<String, String>> fruitCategoryHM = new ArrayList<>();

        fruitsHM = ConstantManager.childItems;
        selectedDataHM = new HashMap<String, ArrayList<String>>();

        //getting selected data from populated data
        for (int i = 0; i < fruitsHM.size(); i++) {
            for (int j = 0; j < fruitsHM.get(i).size(); j++) {
                for (int k = 0; k < fruitsHM.get(i).get(j).size(); k++) {
                    Object key = fruitsHM.get(i).get(j).keySet().toArray()[k];
                    if (fruitsHM.get(i).get(j).get(key) != null && fruitsHM.get(i).get(j).get(key).equalsIgnoreCase("YES")) {
                        String categoryName = fruitsHM.get(i).get(j).get(ConstantManager.Parameter.CATEGORY_NAME);
                        if (selectedDataHM.containsKey(categoryName)) {
                            ArrayList<String> arrayList = selectedDataHM.get(categoryName);
                            arrayList.add(fruitsHM.get(i).get(j).get(ConstantManager.Parameter.SUB_CATEGORY_NAME));
                            selectedDataHM.put(categoryName, arrayList);
                        } else {
                            selectedDataHM.put(categoryName, new ArrayList<String>());
                            ArrayList<String> arrayList = selectedDataHM.get(categoryName);
                            arrayList.add(fruitsHM.get(i).get(j).get(ConstantManager.Parameter.SUB_CATEGORY_NAME));
                            selectedDataHM.put(categoryName, arrayList);
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        doneTV.setVisibility(View.VISIBLE);
        previewTV.setVisibility(View.INVISIBLE);
    }

    @OnClick(R.id.done_tv)
    void onDoneTvClick(View view) {
        getSelectedData();
        doneTV.setVisibility(View.INVISIBLE);
        previewTV.setVisibility(View.VISIBLE);
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
