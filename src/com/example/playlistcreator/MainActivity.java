package com.example.playlistcreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	int totalTime; 		//Total playlist runtime (in seconds)
	int currentTime;
	int totalSongs;
	MediaPlayer mp;
	SongsManager songManager;
	Random rnumGenerator;
	private ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mp = new MediaPlayer();
		songManager = new SongsManager();
		songsList = songManager.getPlayList();
		totalSongs = songsList.size();
		rnumGenerator = new Random();
		currentTime = 0;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	public void createPlaylist(View v) {
		EditText eT = (EditText) findViewById(R.id.length);
		String slen = eT.getText().toString();
		totalTime = Integer.parseInt(slen)*60; //In seconds
		
	}
}
