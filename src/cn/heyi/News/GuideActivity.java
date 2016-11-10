package cn.heyi.News;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class GuideActivity extends Activity {
	private ViewPager view_pager;
	private int[] images={R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
	private Button btn;
	
     @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	initView();
    	initData();
    	
    }

	private void initView() {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_guide);
		view_pager=(ViewPager) findViewById(R.id.view_pager);
		btn=(Button) findViewById(R.id.btn_enter_main);
		view_pager.setAdapter(new PagerAdapter() {
			
			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0==arg1;
			}
			
			@Override
			public Object instantiateItem(ViewGroup container, int position) {
			View view=View.inflate(getApplicationContext(), R.layout.item_guide, null);
			ImageView iv=(ImageView) view.findViewById(R.id.iv_guide);
				iv.setBackgroundResource(images[position]);
				
				container.addView(view);
				return view;
			}
			@Override
			public int getCount() {
				return images.length;
			}
			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				container.removeView((View) object);
			}
		});
		
	}

	private void initData() {
		getSharedPreferences("config", MODE_PRIVATE).edit().putBoolean("InGuide", false).commit();
		view_pager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				if(view_pager.getCurrentItem()==2){
					btn.setVisibility(View.VISIBLE);
					btn.setClickable(true);
				}else{
					btn.setVisibility(View.INVISIBLE);
					btn.setClickable(false);
				}
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),MainActivity.class));
			}
		});
	}
}
