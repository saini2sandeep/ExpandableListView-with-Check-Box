package com.example.sandeepsaini.expandablelistview.model;

/**
 * Created by Sandeep Saini on 9/15/2018
 */
public class FruitNames {

    public FruitNames(){}

    private String categoryId;
    private String categoryName;
    private String fruitId;
    private String fruitName;
    private String isChecked;


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getFruitId() {
        return fruitId;
    }

    public void setFruitId(String fruitIs) {
        this.fruitId = fruitIs;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(String isChecked) {
        this.isChecked = isChecked;
    }
}
