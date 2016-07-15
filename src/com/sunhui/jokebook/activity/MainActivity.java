package com.sunhui.jokebook.activity;

import com.sunhui.jokebook.R;
import com.sunhui.jokebook.R.layout;
import com.sunhui.jokebook.R.menu;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;

public class MainActivity extends Activity {
	private boolean looper = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {

			@Override
			public void run() {
				if (looper) {
					intentAvtivity();

				}
			}

		}, 5000);

	}

	@Override
	protected void onRestart() {
		
		intentAvtivity();
		super.onRestart();
	}

	private void intentAvtivity() {
		startActivity(new Intent(MainActivity.this, FragnentActivity.class));
		finish();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// is back button
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			looper = false;

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("警告");
			builder.setMessage("您确定要退出吗");
			builder.setPositiveButton("确定",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							finish();
						}
					});
			builder.setNegativeButton("返回",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							intentAvtivity();
						}
					});
			builder.setNeutralButton("主界面",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							Intent intent = new Intent();
							intent.setAction(Intent.ACTION_MAIN);
							intent.addCategory(Intent.CATEGORY_HOME);
							startActivity(intent);
						}
					});
			// set other layout cannot use
			builder.setCancelable(false);
			AlertDialog dialog = builder.create();
			dialog.show();
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}

}
