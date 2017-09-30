package com.example.gameofcode;

import android.graphics.Bitmap;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

/**
 * Created by Mohru on 30.09.2017.
 */

public class Character extends SugarRecord {
    String name;
    String gender;
    String house;
    boolean isAive;
    String photoPath;
    @Ignore
    Bitmap photo;

    public Character() {
    }

    public Character(String name, String gender, String house, boolean isAive, String photoPath, Bitmap photo) {
        this.name = name;
        this.gender = gender;
        this.house = house;
        this.isAive = isAive;
        this.photoPath = photoPath;
        this.photo = photo;
    }
}
