package com.example.darianvereen.myapplication2018.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.darianvereen.myapplication2018.R;

import butterknife.BindView;

public class ClosetFragment extends Fragment {


    @BindView(R.id.closet_frag123)
    View view;
    @Nullable
    @Override
    //Below returns the view which the view adapater will display..inflator creates the view from the layout passed in as a parameter
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.viewpager_fragment,container, false);
    }



}
