package com.vutuanchien.android_chap12_multichoicelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//      Receive results is sent by Mainactivity
        Bundle bundle = getIntent().getExtras();
        String[] resultArr = bundle.getStringArray("selectedItems");
        ListView listView = (ListView) findViewById(R.id.outputList);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, resultArr);
        listView.setAdapter(adapter);
    }
}
