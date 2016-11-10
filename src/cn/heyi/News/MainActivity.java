package cn.heyi.News;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	initView();
	initData();
}

private void initView() {
    setContentView(R.layout.activity_main);
    
}

private void initData() {
	
}
}
