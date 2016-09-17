package com.uet.trungthao.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by JiH on 14/09/2016.
 */
public class GridViewAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<ItemView> itemArr;
    LayoutInflater lf;

    public GridViewAdapter(Context mContext, ArrayList<ItemView> itemArr) {
        this.mContext = mContext;
        this.itemArr = itemArr;
        lf = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return itemArr.size();
    }

    @Override
    public Object getItem(int position) {
        return itemArr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = lf.inflate(R.layout.item_gridview, null);
        }

        ImageView image = (ImageView) convertView.findViewById(R.id.img_image);
        image.setImageResource(itemArr.get(position).getImgId());
        return convertView;
    }

    public ArrayList<ItemView> getItemArr() {
        return itemArr;
    }
}
