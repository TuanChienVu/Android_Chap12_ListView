package com.vutuanchien.android_chap12_listviewdemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<Model> adapter = new ListViewAdapter(this, getModel());
        setListAdapter(adapter);
    }
    private List<Model> getModel() {
        List<Model> list = new ArrayList<Model>();
        list.add(get("Kiếm Hiệp"));
        list.add(get("Tiên Hiệp"));
        list.add(get("Ngôn Tình"));
        list.add(get("Trinh Thám"));
        list.add(get("Cổ Tích"));
        list.add(get("Hài Hước"));
        list.add(get("Tự Do"));
        list.add(get("Truyện Ma"));
        list.add(get("Huyền Huyễn"));
        list.add(get("Quân Sự"));
        list.add(get("Đô Thị"));
        list.add(get("Lịch Sử"));
        list.add(get("Dị Giới"));
        list.add(get("Truyện Teen"));
        list.add(get("Xuyên Không"));
        list.add(get("Võng Du"));
        list.add(get("Kiếm Hiệp"));
        list.add(get("Tiên Hiệp"));
        list.add(get("Ngôn Tình"));
        list.add(get("Trinh Thám"));
        list.add(get("Cổ Tích"));
        list.add(get("Hài Hước"));
        list.add(get("Tự Do"));
        list.add(get("Truyện Ma"));
        list.add(get("Huyền Huyễn"));
        list.add(get("Quân Sự"));
        list.add(get("Đô Thị"));
        list.add(get("Lịch Sử"));
        list.add(get("Dị Giới"));
        list.add(get("Truyện Teen"));
        list.add(get("Xuyên Không"));
        list.add(get("Võng Du"));
        // Initially select one of the items
        list.get(1).setSelected(true);
        return list;
    }

    private Model get(String s) {
        return new Model(s);
    }

}
