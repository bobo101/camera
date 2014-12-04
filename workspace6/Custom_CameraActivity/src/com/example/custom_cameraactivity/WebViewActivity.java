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
		getWindow().requestFeature(Window.FEATURE_PROGRESS);  // �b���D��[�W�i�ץ\��
		setContentView(R.layout.activity_web);
		
		wv = (WebView) findViewById(R.id.wv);          
		wv.getSettings().setJavaScriptEnabled(true);	// �ҥ� JavaScript	
		wv.getSettings().setBuiltInZoomControls(true);	// �ҥ��Y��\��
		wv.invokeZoomPicker();	// �Y���Y��p�u��
		wv.setWebViewClient(new WebViewClient());		// �إߤΨϥ� WebViewClient ����
	    wv.setWebChromeClient(new WebChromeClient() {
	    	public void onProgressChanged(WebView view, int progress) 	{
	    		setProgress(progress*100);	// ��ܶi��, ���D��i�׽d��O  0 �� 10000
	    	}
	    });
		
		wv.loadUrl("http://www.hicat.com.tw/daily");   // �s��X�к���
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK &&  // �Y���U���O��^��, �B
				wv.canGoBack()){              // WebView ���W�@��  
			wv.goBack();	// �^�W�@��
			return true;	// �Ǧ^ true, ��ܫ���ƥ�w�B�z
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
