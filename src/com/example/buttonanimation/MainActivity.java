package com.example.buttonanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Animation flowAnim;
	TextView text01;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		flowAnim = AnimationUtils.loadAnimation(this, R.layout.flow);
		
		text01 = (TextView)findViewById(R.id.textView1);
		
		Button startBtn = (Button)findViewById(R.id.button1);
		startBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				flowAnim.setAnimationListener(new FlowAnimationListener());
				text01.startAnimation(flowAnim);
			}
		});
	}
	
	private final class FlowAnimationListener implements Animation.AnimationListener {
		public void onAnimationEnd(Animation animation) {
			Toast.makeText(getApplicationContext(), "애니메이션 종료됨", 1000).show();
		}
		
		public void onAnimationRepeat(Animation animation) {
			
		}
		public void onAnimationStart(Animation animation) {
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

