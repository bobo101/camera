package com.example.custom_cameraactivity;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void gotoSecondActivity(View v){
    	Intent intent = new Intent(this,SecondActivity.class);
    	startActivity(intent);
    }
    public void gotoWebActivity(View v){
    	Intent intent = new Intent(this,WebViewActivity.class);
    	startActivity(intent);
    }
    public void gotoWeb2Activity(View v){
    	Intent intent = new Intent(this,WebView2Activity.class);
    	startActivity(intent);
    }
    public void gotoWeb3Activity(View v){
    	Intent intent = new Intent(this,WebView3Activity.class);
    	startActivity(intent);
    }
    public void gotoWeb4Activity(View v){
    	Intent intent = new Intent(this,WebView4Activity.class);
    	startActivity(intent);
    }
    public void gotoImgViewActivity(View v){
    	Intent intent = new Intent(this,ImgListActivity.class);
    	startActivity(intent);
    }

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
