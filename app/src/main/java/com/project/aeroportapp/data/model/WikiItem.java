package com.project.aeroportapp.data.model;

public class WikiItem {
    private String name;
    private String text;
    public WikiItem(String name_, String text_){
        name = name_;
        text = text_;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}
