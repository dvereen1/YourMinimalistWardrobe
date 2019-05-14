package com.example.darianvereen.myapplication2018.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.darianvereen.myapplication2018.Activity.PantsActivity;
import com.example.darianvereen.myapplication2018.Activity.ShirtsActivity;
import com.example.darianvereen.myapplication2018.Adapater.CustomListViewAdapter;
import com.example.darianvereen.myapplication2018.DataItem;
import com.example.darianvereen.myapplication2018.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShirtsFragment extends Fragment implements View.OnTouchListener{

    private GestureDetector gestureDetector;
    private int sumX =0;
    private int sumY =0;
    List<DataItem> listData;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shirts, container, false);


        listData = new ArrayList<>();
        listData.add(new DataItem(R.drawable.shirt1, "The Essential Black Tee"));
        listData.add(new DataItem(R.drawable.shirt2, "Warm Olive"));
        listData.add(new DataItem(R.drawable.shirt3, "Relaxed Gray For Any Day"));
        listData.add(new DataItem(R.drawable.shirt4, "Darker Gray, Combine With Lights"));
        listData.add(new DataItem(R.drawable.shirt5, "Sky Blue!"));
        listData.add(new DataItem(R.drawable.shirt6, "Mysterious!"));
        listData.add(new DataItem(R.drawable.shirt7, "Can Pair With Anything"));
        listData.add(new DataItem(R.drawable.shirt8, "Another Shade Of Gray"));
        listData.add(new DataItem(R.drawable.shirt9, "When You're Feeling Spicy"));




        //The following 3 lines bind data on our list view
        ListView listView = view.findViewById(R.id.shirtsListView);
        //First parameter in the current context or activity/fragment, second is the xml file that defines how each row looks --third is list of data items
        //We use getContext since this is a fragment
        CustomListViewAdapter adapter = new CustomListViewAdapter(getActivity(), R.layout.custom_item_row, listData);
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
                intent.setClass(getActivity(), ShirtsActivity.class);
                startActivity(intent);
            }
        });

        // return textView;
        return view;


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }


    private class simpleGestureListener extends
            GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            //LogUtil.LogD("Gesture","oSingleTapUp");
            return super.onSingleTapUp(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            //LogUtil.LogD("Gesture","onLongPress");
            super.onLongPress(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
           /* LogUtil.LogD("Gesture","ononScroll");
            LogUtil.LogD("Gesture","distanceX: "+distanceX);
            LogUtil.LogD("Gesture","distanceY: "+distanceY);*/
            sumX+=distanceX;
            sumY+=distanceY;
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            //LogUtil.LogD("Gesture","onFling");
            if(sumX<0){
                if(Math.abs(sumX)>600) {

                    //howToast("You scroll from left to right");
                    sumX = 0;
                    sumY = 0;
                }
            }
            if(sumX>0){
                if(Math.abs(sumX)>600) {
                    //showToast("You scroll from  right to left");
                    sumY=0;
                    sumX = 0;
                }
            }

            if(sumY<0){
                if(Math.abs(sumY)>100) {
                    //showToast("You scroll from top to bottom");
                    sumX = 0;
                    sumY = 0;
                }
            }
            if(sumY>0){
                if(Math.abs(sumY)>100) {
                    //showToast("You scroll from  bottom to top");
                    sumX = 0;
                    sumY = 0;
                }
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public void onShowPress(MotionEvent e) {
         //   LogUtil.LogD("Gesture","onShowPress");
            super.onShowPress(e);
        }

        @Override
        public boolean onDown(MotionEvent e) {
            //LogUtil.LogD("Gesture","onDown");
            return super.onDown(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            //LogUtil.LogD("Gesture","onDoubleTap");
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            //LogUtil.LogD("Gesture","onDoubleTapEvent");
            return super.onDoubleTapEvent(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            //LogUtil.LogD("Gesture","onSingleTapConfirmed");
            return super.onSingleTapConfirmed(e);
        }

    }



}
