package com.example.darianvereen.myapplication2018;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.Random;
import com.example.darianvereen.myapplication2018.R;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.ButterKnife;

public class Animate {


    Animation alphaAnimation;
    Animation rotateAnimation;
    Animation scaleAnimation;
    Animation setAnimation;
    Animation transposeAnimation;

    View view;
    Random rand = new Random();

    public Animate(View view) {
        this.view = view;
        ButterKnife.bind(this.view);
        initialAnimation();
    }


    private void initialAnimation() {

        alphaAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.anim_alpha);
        rotateAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.anim_rotate);
        scaleAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.anim_scale);
        setAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.anim_set);
        transposeAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.anim_trans);

    }

    //public void goAnimate()


}
