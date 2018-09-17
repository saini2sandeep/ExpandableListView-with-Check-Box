package com.example.sandeepsaini.expandablelistview.data_preview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sandeepsaini.expandablelistview.R;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectedDataPreviewActivity extends AppCompatActivity {


    @BindView(R.id.toolbar_back_button_iv)
    ImageView toolbarBackButtonIV;
    @BindView(R.id.toolbar_title_tv)
    TextView toolbarTitleTV;
    @BindView(R.id.data_preview_rv)
    RecyclerView dataPreviewRV;

    private HashMap<String, ArrayList<String>> selectedDataHM = new HashMap<String, ArrayList<String>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_data_preview);
        ButterKnife.bind(this);

        toolbarTitleTV.setText(getResources().getString(R.string.data_preview_activity));

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            selectedDataHM = (HashMap<String, ArrayList<String>>) bundle.getSerializable("DataList");
        }

        setDataPreviewAdapter();
    }

    private void setDataPreviewAdapter() {
        dataPreviewRV.setHasFixedSize(true);
        dataPreviewRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        dataPreviewRV.setAdapter(new DataPreviewAdapter(this, selectedDataHM));
    }

    @OnClick(R.id.toolbar_back_button_iv)
    void onToolbarBackButtonClick(View view) {
        finish();
    }
}
