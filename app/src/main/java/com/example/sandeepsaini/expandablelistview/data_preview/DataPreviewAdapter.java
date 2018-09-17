package com.example.sandeepsaini.expandablelistview.data_preview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sandeepsaini.expandablelistview.R;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sandeep Saini on 9/12/2018
 */
public class DataPreviewAdapter extends RecyclerView.Adapter<DataPreviewAdapter.DataPreviewViewHolder> {

    private Context context;
    private HashMap<String, ArrayList<String>> selectedDataHM = new HashMap<String, ArrayList<String>>();


    public DataPreviewAdapter(Context context, HashMap<String, ArrayList<String>> selectedDataHM) {
        this.context = context;
        this.selectedDataHM = selectedDataHM;
    }

    @NonNull
    @Override
    public DataPreviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataPreviewViewHolder(LayoutInflater.from(context).inflate(R.layout.item_data_preview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataPreviewViewHolder holder, int position) {
        holder.setViewData(holder.getAdapterPosition());
    }

    @Override
    public int getItemCount() {
        return selectedDataHM == null ? 0 : selectedDataHM.size();
    }

    public class DataPreviewViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.category_tv)
        TextView categoryTV;
        @BindView(R.id.fruit_tv)
        TextView fruitTV;

        public DataPreviewViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setViewData(int position) {

            String fruitName = "Fruits Name : ";
            Object key = selectedDataHM.keySet().toArray()[position];
            ArrayList<String> fruitList = selectedDataHM.get(key);
            String fruitCategory = "Fruit Category : " + key.toString();
            categoryTV.setText(fruitCategory);
            for (int i = 0; i < fruitList.size(); i++) {
                if (i == 0) {
                    fruitName = fruitName + fruitList.get(i);
                } else {
                    fruitName = fruitName + ", " + fruitList.get(i);
                }
            }
            fruitTV.setText(fruitName);
        }
    }
}
