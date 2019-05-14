package com.example.darianvereen.myapplication2018.Adapater;

import android.app.Activity;
import android.content.ContentProvider;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.darianvereen.myapplication2018.DataItem;
import com.example.darianvereen.myapplication2018.R;

import java.util.List;

public class CustomListViewAdapter extends ArrayAdapter<DataItem>{
    //These local variable will be used in the constructor of our class
    //and take on whatever values are passed in upon initialization
    //the resourceId is the id of XML file that we want to be inflated..
    Context context;
    int layoutResourceId;
    List<DataItem> data = null;


    public CustomListViewAdapter(@NonNull Context context, int resource, @NonNull List<DataItem> objects) {
        super(context, resource, objects);

        this.layoutResourceId = resource;
        this.context = context;
        this.data = objects;


    }

    //This class will hold a reference for all the views which our list view will hold -- one for our pic of the clothes and the other for a short description
    static class DataHolder{
        ImageView clotheItem;
        TextView clotheDescript;

    }

    //This getView method will be called the number of times data or rows is bound to the view
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DataHolder holder = null;

        //The first call the if statement will be triggered..for all other calls rto this method the else
        //statement will be triggered
        //The inflater is used to convert the xml file to a programmable object from which views can be rendered
        //we are inflating whatever view gets passed in when this class is initialized elswhere
        if(convertView == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId,parent,false);

            holder = new DataHolder();

            //Now we are going to find views from a particular layout aka our custom layout file
            //provide viewas for our clothe picture and description
            ///Notice how we cast each view as the view defined in the XML file
            holder.clotheItem = (ImageView)convertView.findViewById(R.id.imageView_clothe);
            holder.clotheDescript = (TextView)convertView.findViewById(R.id.clothe_descript);

            //the holder class holds a references to two different views we want to pass this data from convertView with the set Tag function
            convertView.setTag(holder);
        }else{
            //here we are retrieving the data that applied to the convert view with the getTag call
            holder = (DataHolder)convertView.getTag();
        }
        //This postion defines where the data will be binding..i.e. what row item will get the particular data
        DataItem dataItem = data.get(position);
        holder.clotheItem.setImageResource(dataItem.resIdThumbnail);
        holder.clotheDescript.setText(dataItem.itemName);

        return convertView;

    }

}
