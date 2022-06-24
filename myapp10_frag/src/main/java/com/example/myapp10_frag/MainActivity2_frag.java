package com.example.myapp10_frag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2_frag extends AppCompatActivity  implements View.OnClickListener {
    Button btnSong,btnArtist,btnAllbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_frag);

        btnSong = findViewById(R.id.btnSong);
        btnArtist = findViewById(R.id.btnArtist);
        btnAllbum = findViewById(R.id.btnAllbum);

        btnSong.setOnClickListener(this);
        btnArtist.setOnClickListener(this);
        btnAllbum.setOnClickListener(this);

        SongFragment songFragment = new SongFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container,songFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
    @Override
    public void onClick(View view){
        Fragment fr=null;
        switch (view.getId()){
            case R.id.btnSong:
                fr = new SongFragment();
                break;
            case R.id.btnArtist:
                fr = new ArtistFragment();
                break;
            case R.id.btnAllbum:
                fr = new AlbumFragment();
                break;
        }
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_container,fr);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fr).addToBackStack(null).commit();
    }

}