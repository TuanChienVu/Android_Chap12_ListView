package com.vutuanchien.android_chap12_listviewdemo;

/**
 * Created by MY PC on 17/03/2016.
 */
public class Model {
    String name;
    boolean selected;

    public Model(String name) {
        this.name = name;
        selected = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
