package com.example.sandeepsaini.expandablelistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sandeepsaini.expandablelistview.simple_el.ExpandableListActivity;
import com.example.sandeepsaini.expandablelistview.with_header_cb.CheckBoxExpandableListActivity;
import com.example.sandeepsaini.expandablelistview.without_header_cb.ExpandableListWithChildCBSelection;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.toolbar_back_button_iv)
    ImageView toolbarBackButtonIV;
    @BindView(R.id.toolbar_title_tv)
    TextView toolbarTitleTV;
    @BindView(R.id.with_header_check_box_tv)
    TextView withHeaderCheckBoxTV;
    @BindView(R.id.with_child_check_box_tv)
    TextView withChildCheckBoxTV;
    @BindView(R.id.simple_el_tv)
    TextView simpleElTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbarBackButtonIV.setVisibility(View.GONE);

        toolbarTitleTV.setText(getResources().getString(R.string.expandable_list_view_project));
    }

    @OnClick(R.id.with_header_check_box_tv)
    void onWithHeaderCheckBoxClick(View view) {
        withHeaderCheckBoxTV.setTextColor(getResources().getColor(R.color.colorPrimary));
        Intent intent = new Intent(this, CheckBoxExpandableListActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.with_child_check_box_tv)
    void onWithChildCheckBoxClick(View view) {
        withChildCheckBoxTV.setTextColor(getResources().getColor(R.color.colorPrimary));
        Intent intent = new Intent(this, ExpandableListWithChildCBSelection.class);
        startActivity(intent);
    }

    @OnClick(R.id.simple_el_tv)
    void simpleEListClick(View view) {
        simpleElTV.setTextColor(getResources().getColor(R.color.colorPrimary));
        Intent intent = new Intent(this, ExpandableListActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        simpleElTV.setTextColor(getResources().getColor(R.color.textColorPrimary));
        withHeaderCheckBoxTV.setTextColor(getResources().getColor(R.color.textColorPrimary));
        withChildCheckBoxTV.setTextColor(getResources().getColor(R.color.textColorPrimary));

    }
}
