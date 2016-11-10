package cn.heyi.News;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

public class SplashActivity extends Activity {
   private RelativeLayout rl_splash;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		initView();
		initData();
	}

	private void initView() {
		setContentView(R.layout.activity_splash);
		rl_splash=(RelativeLayout) findViewById(R.id.rl_splash);
		startAnimation(rl_splash);
	}

	private void startAnimation(View view) {
		// TODO Auto-generated method stub
		AnimationSet as=new AnimationSet(false);//≤Â≤π∆˜£¨≤ª…Ë÷√
		RotateAnimation ra=new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		ra.setDuration(2000);
		ra.setFillAfter(true);
		ScaleAnimation  sa=new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		sa.setDuration(2000);
		sa.setFillAfter(true);
		AlphaAnimation  aa=new AlphaAnimation(0, 1);
		aa.setDuration(2000);
		as.addAnimation(aa);
		as.addAnimation(sa);
		as.addAnimation(ra);
		view.startAnimation(as);
		
		
	}

	private void initData() {
		final boolean inGuide=getSharedPreferences("config", MODE_PRIVATE).getBoolean("InGuide", true);
		Timer timer=new Timer();
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				if(inGuide){
				startActivity(new Intent(getApplicationContext(),GuideActivity.class));	
				finish();
				}else{
					startActivity(new Intent(getApplicationContext(),GuideActivity.class));	
				//startActivity(new Intent(getApplicationContext(),MainActivity.class));	
				finish();
				}
			}
			
		}, 2000);
	}
	
}
