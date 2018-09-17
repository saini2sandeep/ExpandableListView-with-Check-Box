package com.example.sandeepsaini.expandablelistview.without_header_cb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.sandeepsaini.expandablelistview.ConstantManager;
import com.example.sandeepsaini.expandablelistview.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sandeep Saini on 9/16/2018
 */
public class ExpandableListChildCBAdapter extends BaseExpandableListAdapter {
    private final ArrayList<ArrayList<HashMap<String, String>>> childDataList;
    private LayoutInflater inflater;
    private Context context;
    private HashMap<String, String> child;
    private ArrayList<String> headerDataList;

    public ExpandableListChildCBAdapter(Context context, ArrayList<String> categoryArrayList,
                                        ArrayList<ArrayList<HashMap<String, String>>> childItems) {
        this.headerDataList = categoryArrayList;
        this.childDataList = childItems;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        return headerDataList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return (childDataList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, final boolean b, View convertView, ViewGroup viewGroup) {
        final ExpandableListChildCBAdapter.ViewHolderParent viewHolderParent;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_group_layout, null);
            viewHolderParent = new ExpandableListChildCBAdapter.ViewHolderParent();
            viewHolderParent.tvMainCategoryName = convertView.findViewById(R.id.tvMainCategoryName);
            convertView.setTag(viewHolderParent);
        } else {
            viewHolderParent = (ExpandableListChildCBAdapter.ViewHolderParent) convertView.getTag();
        }

        ConstantManager.childItems = childDataList;
        viewHolderParent.tvMainCategoryName.setText(headerDataList.get(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, final boolean b, View convertView, ViewGroup viewGroup) {

        final ExpandableListChildCBAdapter.ViewHolderChild viewHolderChild;
        child = childDataList.get(groupPosition).get(childPosition);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_child_with_cb, null);
            viewHolderChild = new ExpandableListChildCBAdapter.ViewHolderChild();

            viewHolderChild.tvSubCategoryName = convertView.findViewById(R.id.section_name);
            viewHolderChild.cbSubCategory = convertView.findViewById(R.id.section_check);
            convertView.setTag(viewHolderChild);
        } else {
            viewHolderChild = (ExpandableListChildCBAdapter.ViewHolderChild) convertView.getTag();
        }

        if (childDataList.get(groupPosition).get(childPosition).get(ConstantManager.Parameter.IS_CHECKED).equalsIgnoreCase(ConstantManager.CHECK_BOX_CHECKED_TRUE)) {
            viewHolderChild.cbSubCategory.setChecked(true);
            viewHolderChild.tvSubCategoryName.setTextColor(context.getResources().getColor(R.color.colorAccent));
            notifyDataSetChanged();
        } else {
            viewHolderChild.cbSubCategory.setChecked(false);
            viewHolderChild.tvSubCategoryName.setTextColor(context.getResources().getColor(R.color.textColorGray));
            notifyDataSetChanged();
        }

        String sectionName = child.get(ConstantManager.Parameter.SUB_CATEGORY_NAME);
        viewHolderChild.tvSubCategoryName.setText(sectionName);
        viewHolderChild.cbSubCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewHolderChild.cbSubCategory.isChecked()) {
                    childDataList.get(groupPosition).get(childPosition).put(ConstantManager.Parameter.IS_CHECKED, ConstantManager.CHECK_BOX_CHECKED_TRUE);
                    notifyDataSetChanged();
                } else {
                    childDataList.get(groupPosition).get(childPosition).put(ConstantManager.Parameter.IS_CHECKED, ConstantManager.CHECK_BOX_CHECKED_FALSE);
                    notifyDataSetChanged();
                }

                ConstantManager.childItems = childDataList;
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    private class ViewHolderParent {
        TextView tvMainCategoryName;
        CheckBox cbMainCategory;
    }

    private class ViewHolderChild {
        TextView tvSubCategoryName;
        CheckBox cbSubCategory;
    }
}
