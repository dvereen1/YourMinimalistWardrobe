package com.example.darianvereen.myapplication2018.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.darianvereen.myapplication2018.Activity.PantsActivity;
import com.example.darianvereen.myapplication2018.Activity.ShoesActivity;
import com.example.darianvereen.myapplication2018.Adapater.CustomListViewAdapter;
import com.example.darianvereen.myapplication2018.DataItem;
import com.example.darianvereen.myapplication2018.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoesFragment extends Fragment {


    List<DataItem> listData;

    public ShoesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //TextView textView = new TextView(getActivity());
        //textView.setText(R.string.hello_blank_fragment);

        View view = inflater.inflate(R.layout.fragment_shoes,container,false);

        listData = new ArrayList<>();
        listData.add(new DataItem(R.drawable.shoes1,"This Will Match Everything"));
        listData.add(new DataItem(R.drawable.shoes2,"Cool Gray For A Cool Day"));
        listData.add(new DataItem(R.drawable.shoes3,"Damn Daniel!"));
        listData.add(new DataItem(R.drawable.shoes4,"Sam Smith's Will Always Work"));



        //The following 3 lines bind data on our list view
        ListView listView = view.findViewById(R.id.shoesListView);
        //First parameter in the current context or activity/fragment, second is the xml file that defines how each row looks --third is list of data items
        //We use getContext since this is a fragment
        CustomListViewAdapter adapter = new CustomListViewAdapter(getActivity(), R.layout.custom_item_row, listData );
        listView.setAdapter(adapter);

        ///TO HANDLE CLICK EVENTS ON OUR ITEMS EACH CLICK WILL OPEN A NEW ACTIVITY
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                //passes value from one activity to another so we are passing the itemName and the thumbnail of the picture of whatever postion we are on
                intent.putExtra("Item Name", listData.get(position).itemName);
                intent.putExtra("Picture", listData.get(position).resIdThumbnail);

                //Takes the context we are currently in and the activity we want to pass the data to
                intent.setClass(getActivity(), ShoesActivity.class);
                startActivity(intent);
            }
        });

        // return textView;
        return view;
    }
}
