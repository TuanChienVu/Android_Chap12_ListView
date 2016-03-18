package com.vutuanchien.android_chap12_listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by MY PC on 17/03/2016.
 */
public class ListViewAdapter extends ArrayAdapter<Model> {
    final Context context;
    final List<Model> list;

    public ListViewAdapter(Context context, List<Model> list) {
        super(context, R.layout.itemlistview, list);
        this.context = context;
        this.list = list;
    }

//    Create viewholder to attach objects into View
    static class ViewHolder {
        TextView tvOSName;
        CheckBox chkSelected;
    }

//    Custom listview item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.itemlistview, null);
            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.tvOSName = (TextView) view.findViewById(R.id.tvOSName);
            viewHolder.chkSelected = (CheckBox) view.findViewById(R.id.chkSelected);
            viewHolder.chkSelected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Model element = (Model) viewHolder.chkSelected.getTag();
                    element.setSelected(buttonView.isChecked());
                }
            });

            view.setTag(viewHolder);
            viewHolder.chkSelected.setTag(list.get(position));

        } else {
            view = convertView;
            ((ViewHolder) view.getTag()).chkSelected.
                    setTag(list.get(position));
        }
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.tvOSName.setText(list.get(position).getName());
        holder.chkSelected.setChecked(list.get(position).isSelected());
        return view;
    }
}
