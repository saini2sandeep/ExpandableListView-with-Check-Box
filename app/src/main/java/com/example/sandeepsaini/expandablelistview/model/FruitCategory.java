package com.example.sandeepsaini.expandablelistview.model;

import java.util.List;

/**
 * Created by Sandeep Saini on 9/15/2018
 */
public class FruitCategory {
    public FruitCategory() {
    }

    private String categoryID;
    private String categoryName;
    private String isChecked = "NO";
    private List<FruitNames> fruitsNameList;

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(String isChecked) {
        this.isChecked = isChecked;
    }

    public List<FruitNames> getFruitsNameList() {
        return fruitsNameList;
    }

    public void setFruitsNameList(List<FruitNames> fruitsNameList) {
        this.fruitsNameList = fruitsNameList;
    }
}
