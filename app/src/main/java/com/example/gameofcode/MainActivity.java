package com.example.gameofcode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView charactersListView;
    ArrayAdapter<Character> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<Character> characters = Character.listAll(Character.class);

        charactersListView = (ListView) findViewById(R.id.characters_listView);
        adapter = new ArrayAdapter<Character>(this, R.layout.character_row, characters) {
            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null)
                    convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.character_row, parent, false);

                ImageView photoImageView = (ImageView) convertView.findViewById(R.id.photo_imageView);
                TextView nameTextView = (TextView) convertView.findViewById(R.id.name_textView);

                InputStream ioStream = null;
                try {
                    ioStream = MainActivity.this.getAssets().open("photos/" + characters.get(position).photoPath + ".jpg");
                    Bitmap bitmap = BitmapFactory.decodeStream(ioStream);
                    photoImageView.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                nameTextView.setText(characters.get(position).name);

                return convertView;
            }
        };

        charactersListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        charactersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, CharacterActivity.class);
                intent.putExtra("character_id", characters.get(i).getId());
                startActivity(intent);
            }
        });
    }
}
