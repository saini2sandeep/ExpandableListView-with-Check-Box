package com.example.sandeepsaini.expandablelistview.simple_el;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.sandeepsaini.expandablelistview.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sandeep Saini on 9/12/2018
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<String> fruitCategoryList = new ArrayList<String>();
    private HashMap<String, ArrayList<String>> fruitNameList = new HashMap<String, ArrayList<String>>();


    public ExpandableListAdapter(Context context, ArrayList<String> fruitCategoryList,
                                 HashMap<String, ArrayList<String>> fruitNameList) {
        this.context = context;
        this.fruitCategoryList = fruitCategoryList;
        this.fruitNameList = fruitNameList;
    }


    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this.fruitNameList.get(this.fruitCategoryList.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    TextView fruitNameTV;

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.child_layout_simple_el, null);
        }

        fruitNameTV = (TextView) convertView.findViewById(R.id.child_name_tv);
        fruitNameTV.setText(childText);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.fruitNameList.get(this.fruitCategoryList.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.fruitCategoryList.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.fruitCategoryList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.header_layout_simple_el, null);
        }

        TextView fruitCategoryNameTV = (TextView) convertView.findViewById(R.id.header_name_tv);
        fruitCategoryNameTV.setTypeface(null, Typeface.BOLD);
        fruitCategoryNameTV.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
