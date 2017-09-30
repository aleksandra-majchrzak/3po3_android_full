package com.example.gameofcode;

import com.orm.SugarApp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohru on 30.09.2017.
 */

public class MyApplication extends SugarApp {

    @Override
    public void onCreate() {
        super.onCreate();

        final List<Character> characters = new ArrayList<>();
        characters.add(new Character("Jon Snow", "mężczyzna", "? :)", true, "jon_snow", null));
        characters.add(new Character("Arya Stark", "kobieta", "Stark", true, "arya_stark", null));
        characters.add(new Character("Cersei Lannister", "kobieta", "Lannister", true, "cersei_lannister", null));
        characters.add(new Character("Daenerys Targaryen", "kobieta", "Targaryen", true, "daenerys_targaryen", null));
        characters.add(new Character("Joffrey Baratheon", "mężczyzna", "Baratheon", false, "joffrey_baratheon", null));
        characters.add(new Character("Margaery Tyrell", "kobieta", "Tyrell", false, "margaery_tyrell", null));
        characters.add(new Character("Tyrion Lannister", "mężczyzna", "Lannister", true, "tyrion_lannister", null));
        characters.add(new Character("Theon Greyjoy", "mężczyzna", "Greyjoy", true, "theon_greyjoy", null));

        if (Character.listAll(Character.class).isEmpty()) {
            Character.saveInTx(characters);
        }
    }
}
