/**
 * 
 */
package com.example.custom_cameraactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * @author Peter
 *
 */
public class WebViewActivity extends Activity {
	WebView wv;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_PROGRESS);  // 在標題欄加上進度功能
		setContentView(R.layout.activity_web);
		
		wv = (WebView) findViewById(R.id.wv);          
		wv.getSettings().setJavaScriptEnabled(true);	// 啟用 JavaScript	
		wv.getSettings().setBuiltInZoomControls(true);	// 啟用縮放功能
		wv.invokeZoomPicker();	// 縮示縮放小工具
		wv.setWebViewClient(new WebViewClient());		// 建立及使用 WebViewClient 物件
	    wv.setWebChromeClient(new WebChromeClient() {
	    	public void onProgressChanged(WebView view, int progress) 	{
	    		setProgress(progress*100);	// 顯示進度, 標題欄進度範圍是  0 到 10000
	    	}
	    });
		
		wv.loadUrl("http://www.hicat.com.tw/daily");   // 連到旗標網站
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK &&  // 若按下的是返回鍵, 且
				wv.canGoBack()){              // WebView 有上一頁  
			wv.goBack();	// 回上一頁
			return true;	// 傳回 true, 表示按鍵事件已處理
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
