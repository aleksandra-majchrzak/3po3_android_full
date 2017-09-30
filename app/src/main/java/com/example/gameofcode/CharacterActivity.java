package com.example.gameofcode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class CharacterActivity extends AppCompatActivity {

    ImageView photoImageView;
    TextView nameTextView;
    TextView genderTextView;
    TextView houseTextView;
    SwitchCompat aliveSwitch;
    Button saveButton;

    Character character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        character = Character.findById(Character.class, getIntent().getLongExtra("character_id", 0));

        photoImageView = (ImageView) findViewById(R.id.photo_imageView);
        nameTextView = (TextView) findViewById(R.id.name_textView);
        genderTextView = (TextView) findViewById(R.id.gender_textView);
        houseTextView = (TextView) findViewById(R.id.house_textView);
        aliveSwitch = (SwitchCompat) findViewById(R.id.alive_switch);
        saveButton = (Button) findViewById(R.id.save_button);

        InputStream ioStream = null;
        try {
            ioStream = this.getAssets().open("photos/" + character.photoPath + ".jpg");
            Bitmap bitmap = BitmapFactory.decodeStream(ioStream);
            character.photo = bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }


        photoImageView.setImageBitmap(character.photo);
        nameTextView.setText(character.name);
        genderTextView.setText(character.gender);
        houseTextView.setText(character.house);
        aliveSwitch.setChecked(character.isAive);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character.isAive = aliveSwitch.isChecked();
                character.save();
                CharacterActivity.this.finish();
            }
        });
    }
}
