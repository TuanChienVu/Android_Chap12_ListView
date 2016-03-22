package com.vutuanchien.android_chap12_singlelistview;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    String[] newspaperList = {
            "Dân Trí", "Tuổi Trẻ", "Thanh Niên", "Phụ Nữ",
            "Lao Động", "VnExpress", "Bóng Đá", "Tiền Phong",
            "CAND", "Tia Sáng", "Kiến Thức Ngày Nay"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Create Adapter to contain newspaperList
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, newspaperList);
        setListAdapter(adapter);
        ListView listView = getListView();
//        Choose single choice for items
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }
}
