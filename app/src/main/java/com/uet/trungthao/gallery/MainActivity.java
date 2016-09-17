package com.uet.trungthao.gallery;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnGrid, btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGrid = (Button) findViewById(R.id.btn_gridview);
        btnList = (Button) findViewById(R.id.btn_listview);

        ArrayList<ItemView> itemArr = new ArrayList<>();
        itemArr.add(new ItemView(R.mipmap.anh1, "Ảnh 1"));
        itemArr.add(new ItemView(R.mipmap.anh2, "Ảnh 2"));
        itemArr.add(new ItemView(R.mipmap.anh3, "Ảnh 3"));
        itemArr.add(new ItemView(R.mipmap.anh4, "Ảnh 4"));
        itemArr.add(new ItemView(R.mipmap.anh5, "Ảnh 5"));
        itemArr.add(new ItemView(R.mipmap.anh6, "Ảnh 6"));
        itemArr.add(new ItemView(R.mipmap.anh7, "Ảnh 7"));
        itemArr.add(new ItemView(R.mipmap.anh8, "Ảnh 8"));
        itemArr.add(new ItemView(R.mipmap.anh9, "Ảnh 9"));
        itemArr.add(new ItemView(R.mipmap.anh10, "Ảnh 10"));
        itemArr.add(new ItemView(R.mipmap.anh11, "Ảnh 11"));
        itemArr.add(new ItemView(R.mipmap.anh12, "Ảnh 12"));
        itemArr.add(new ItemView(R.mipmap.anh13, "Ảnh 13"));
        itemArr.add(new ItemView(R.mipmap.anh14, "Ảnh 14"));
        itemArr.add(new ItemView(R.mipmap.anh16, "Ảnh 15"));
        itemArr.add(new ItemView(R.mipmap.anh17, "Ảnh 16"));

        final ListViewAdapter mListAdaper = new ListViewAdapter(this, itemArr);
        final GridViewAdapter mGridAdapter = new GridViewAdapter(this, itemArr);

        final ListView lvGallery = (ListView) findViewById(R.id.lv_gallery);
        final GridView gvGallery = (GridView) findViewById(R.id.gv_gallery);

        lvGallery.setAdapter(mListAdaper);
        gvGallery.setAdapter(mGridAdapter);
        lvGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showImage(mListAdaper.getItemArr(), position);
            }
        });

        gvGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showImage(mListAdaper.getItemArr(), position);
            }
        });

        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvGallery.setVisibility(View.GONE);
//                lvGallery.setAdapter(new ListViewAdapter(MainActivity.this, new ArrayList<ItemView>()));
                gvGallery.setVisibility(View.VISIBLE);
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gvGallery.setVisibility(View.GONE);
//                gvGallery.setAdapter(new ListViewAdapter(MainActivity.this, new ArrayList<ItemView>()));
                lvGallery.setVisibility(View.VISIBLE);
            }
        });
    }

    private void showImage(final ArrayList<ItemView> itemArr, int position) {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this, R.style.DialogTheme);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog, null);
        dialog.setView(view);
        final ImageView imageView = (ImageView) view.findViewById(R.id.image_dialog);
        imageView.setImageResource(itemArr.get(position).getImgId());
        dialog.show();
        final int[] i = {position};
        Button btnNext = (Button) view.findViewById(R.id.btn_next);
        Button btnPrep = (Button) view.findViewById(R.id.btn_prep);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i[0] != itemArr.size() - 1) {
                    imageView.setImageResource(itemArr.get(++i[0]).getImgId());
                }
            }
        });

        btnPrep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i[0] != 0) {
                    imageView.setImageResource(itemArr.get(--i[0]).getImgId());
                }
            }
        });
    }
}
