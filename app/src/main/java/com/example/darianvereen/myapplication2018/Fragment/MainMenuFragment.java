package com.example.darianvereen.myapplication2018.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.darianvereen.myapplication2018.Activity.ClosetActivity;
import com.example.darianvereen.myapplication2018.Outfit;
import com.example.darianvereen.myapplication2018.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainMenuFragment extends Fragment {


    public MainMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);

        String[] menuItems = {"Start","Planning","Your","Next","Outfit","Right", "Now!"};

        ListView listView = (ListView) view.findViewById(R.id.mainMenu);
        // Inflate t[he layout for this fragment

        ArrayAdapter<String> listViewAdpater = new ArrayAdapter<String>(
                //current Activity
                getActivity(),
                //Layout that is used to create the list of views listView will display;
                android.R.layout.simple_expandable_list_item_1,
                menuItems
        );
        listView.setAdapter(listViewAdpater);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            //parent = listView ---- view = the item that we click on --- position = index of item clicked on

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id ) {
                switch(position){
                    //intent needs the current activity---The activity we want it to launch..aka its class

                    case 0:
                        Outfit.day = "Sunday";
                        Intent intent = new Intent(getActivity(), ClosetActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Outfit.day = "Monday";
                        Intent intent1 = new Intent(getActivity(), ClosetActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Outfit.day = "Tuesday";
                        Intent intent2 = new Intent(getActivity(), ClosetActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Outfit.day = "Wednesday";
                        Intent intent3 = new Intent(getActivity(), ClosetActivity.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Outfit.day = "Thursday";
                        Intent intent4 = new Intent(getActivity(), ClosetActivity.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Outfit.day = "Friday";
                        Intent intent5 = new Intent(getActivity(), ClosetActivity.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Outfit.day = "Saturday";
                        Intent intent6 = new Intent(getActivity(), ClosetActivity.class);
                        startActivity(intent6);
                        break;
                    default:
                        Toast.makeText(getActivity(),"Hello", Toast.LENGTH_SHORT).show();


                }
            }
        });
        return view;
    }

}
