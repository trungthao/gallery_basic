package com.uet.trungthao.gallery;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import java.io.Serializable;

/**
 * Created by JiH on 14/09/2016.
 */
public class ItemView
//        implements Parcelable
{
    private int imgId;
    private String title;

    public ItemView(int imgId, String title) {
        this.imgId = imgId;
        this.title = title;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
