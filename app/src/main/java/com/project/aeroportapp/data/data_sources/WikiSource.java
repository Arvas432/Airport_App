package com.project.aeroportapp.data.data_sources;

import com.project.aeroportapp.data.model.Destination;
import com.project.aeroportapp.data.model.WikiItem;

import java.util.ArrayList;

public class WikiSource {
    public static ArrayList<WikiItem> wikis = new ArrayList<WikiItem>() {
        {

        }
    };
    public static ArrayList<WikiItem> get()
    {
        return new ArrayList<WikiItem>(wikis);
    }
    public static WikiItem add(WikiItem input)
    {
        wikis.add(input);
        return input;
    }
}
