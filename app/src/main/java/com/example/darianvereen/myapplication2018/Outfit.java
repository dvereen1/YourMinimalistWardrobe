package com.example.darianvereen.myapplication2018;


import java.util.ArrayList;

public class Outfit {
    public static int resId1;
    public static int resId2;
    public static int resId3;
    public static String day;
    public static ArrayList<Outfit> arr;

    public int shirt, pants, shoes;
    public String dayss;

    public int getShirt() {
        return shirt;
    }

    public void setShirt(int shirt) {
        this.shirt = shirt;
    }

    public int getPants() {
        return pants;
    }

    public void setPants(int pants) {
        this.pants = pants;
    }

    public int getShoes() {
        return shoes;
    }

    public void setShoes(int shoes) {
        this.shoes = shoes;
    }

    public String getDayss() {
        return dayss;
    }

    public void setDayss(String dayss) {
        this.dayss = dayss;
    }

    public Outfit(){
        this.shirt = resId1;
        this.pants = resId2;
        this.shoes = resId3;
        this.dayss = day;
    }


}
