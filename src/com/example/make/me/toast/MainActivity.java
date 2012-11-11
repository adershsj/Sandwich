package com.example.make.me.toast;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button testButton;
	private OnClickListener testButtonListener = new OnClickListener() {

		public void onClick(View v) {
			Intent i = new Intent(Intent.ACTION_VIEW);
			// Make me a sandwich Video
			i.setData(Uri.parse("http://www.youtube.com/watch?v=lQOkMz3kiS0"));
			PendingIntent sandwichIntent = PendingIntent.getActivity(
					MainActivity.this, 0, i, 0);

			i = new Intent(Intent.ACTION_VIEW);
			// Hangover Video
			i.setData(Uri.parse("https://www.youtube.com/watch?v=xlrqaAjBwS4"));
			PendingIntent hangoverIntent = PendingIntent.getActivity(
					MainActivity.this, 0, i, 0);

			// Benachrichtigungen werden wie immer aufgebaut, mit Titel, Text
			// und Icon
			Notification toast = new Notification.Builder(MainActivity.this)
					.setContentTitle("Good Morning")
					.setContentText("It's 6 o'clock!")
					.setSmallIcon(R.drawable.ic_launcher)
					// Weitere Aktionen hinzufügen (erst ab Jelly Bean)
					.addAction(R.drawable.ic_action_search, "Sandwich",
							sandwichIntent)
					.addAction(R.drawable.ic_action_search, "Hangover",
							hangoverIntent).build();

			// An NotificationManager übergeben und anzeigen
			NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
			mNotificationManager.notify(1, toast);
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		testButton = (Button) findViewById(R.id.test);
		testButton.setOnClickListener(testButtonListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
