package com.example.androidweek13;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    // All the data could come from Firebase or something, does not have to be hard coded.

    String[] titel ={
            "Number 1","Number 2"
    };
    Integer[] images = {
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Make the custom adapter the adapter of our list, with the data we want
        // The data here is Titel and images
        MyListAdapter adapter = new MyListAdapter(this,titel,images);
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);


    }
}

// This could/should be its own Java file but for easy viewing i put it in Main
class MyListAdapter extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] titel;
    private final Integer[] images;

    public MyListAdapter(Activity context, String[] titel, Integer[] images) {
        super(context,R.layout.mylist,titel);

        this.context = context;
        this.titel = titel;
        this.images = images;
    }
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist,null,true);

        TextView titelText = rowView.findViewById(R.id.title);
        ImageView imageView = rowView.findViewById(R.id.image);

        titelText.setText(titel[position]);
        imageView.setImageResource(images[position]);

        return rowView;
    }
}
