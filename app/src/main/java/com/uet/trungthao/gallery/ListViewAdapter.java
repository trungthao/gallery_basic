package com.uet.trungthao.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JiH on 14/09/2016.
 */
public class ListViewAdapter extends BaseAdapter{
    private Context mContext;
    private ArrayList<ItemView> itemArr;
    LayoutInflater lf;

    public ListViewAdapter(Context mContext, ArrayList<ItemView> itemArr) {
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
            convertView = lf.inflate(R.layout.item_listview, null);
        }

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
        ImageView img = (ImageView) convertView.findViewById(R.id.img_image);

        img.setImageResource(itemArr.get(position).getImgId());
        tvTitle.setText(itemArr.get(position).getTitle());

        return convertView;
    }

    public ArrayList<ItemView> getItemArr() {
        return itemArr;
    }
}
