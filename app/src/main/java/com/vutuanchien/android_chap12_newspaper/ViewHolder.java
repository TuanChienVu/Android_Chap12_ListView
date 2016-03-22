package com.vutuanchien.android_chap12_newspaper;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by MY PC on 22/03/2016.
 */
public class ViewHolder {
    //lop quan ly cac member view trong convertview
    TextView tieude;
    TextView ngayviet;
    ImageView hinhdaidien;

    ViewHolder(View rootView) {
        tieude = (TextView) rootView.findViewById(R.id.tv_Tieude);
        ngayviet = (TextView) rootView.findViewById(R.id.tv_ngayviet);
        hinhdaidien = (ImageView) rootView.findViewById(R.id.hinhdaidien);
    }
}