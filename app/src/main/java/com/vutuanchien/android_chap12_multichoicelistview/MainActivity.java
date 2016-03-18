package com.vutuanchien.android_chap12_multichoicelistview;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnShow;
    ListView listView;
    ArrayAdapter<String> adapter;

    String[] newspaperList = {
            "Dân Trí", "Tuổi Trẻ", "Thanh Niên", "Phụ Nữ",
            "Lao Động", "VnExpress", "Bóng Đá", "Tiền Phong",
            "CAND", "Tia Sáng", "Kiến Thức Ngày Nay"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        btnShow = (Button) findViewById(R.id.btnShow);

        //        Create Adapter to contain newspaperList
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, newspaperList);
        //        Choose single choice for items
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        btnShow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        SparseBooleanArray checked = listView.getCheckedItemPositions();
        ArrayList<String> selectedItems = new ArrayList<String>();
        for (int i = 0; i < checked.size(); i++) {
            // Item position in adapter
            int position = checked.keyAt(i);
            // Add sport if it is checked i.e.) == TRUE!
            if (checked.valueAt(i))
                selectedItems.add(adapter.getItem(position));
        }

        String[] outputStrArr = new String[selectedItems.size()];

        for (int i = 0; i < selectedItems.size(); i++) {
            outputStrArr[i] = selectedItems.get(i);
        }

        Intent intent = new Intent(getApplicationContext(),
                ResultActivity.class);

        // Create a bundle object
        Bundle b = new Bundle();
        b.putStringArray("selectedItems", outputStrArr);

        // Add the bundle to the intent.
        intent.putExtras(b);

        // start the ResultActivity
        startActivity(intent);

    }
}
