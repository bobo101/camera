/**
 * 
 */
package com.example.custom_cameraactivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * @author Peter
 *
 */
public class ImgShowActivity extends Activity {
	private ImageView imageView;
	private DisplayMetrics dm;
	private Bitmap bitmap;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imgshow);
		dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
				
		imageView = (ImageView)findViewById(R.id.image_view);
		//取得intent裡的bundle
        Bundle bundle = getIntent().getExtras();
		
		Log.i("ImgPath", bundle.getString("ImgPath"));
		bitmap = getBitmapFromSDCard(bundle.getString("ImgPath"));
		Matrix m=new Matrix();
        //取得圖片的寬度
               int width=bitmap.getWidth();
               //取得圖片的長度
               int height=bitmap.getHeight();
               //順時針旋轉90度
               m.postRotate(90); 
               //產生新的旋轉後Bitmap檔
               Bitmap b=Bitmap.createBitmap(bitmap, 0, 0, width, height, m, true);
		imageView.setImageBitmap(b);
		new ImageViewHelper(dm,imageView,b);
		
	}
	
	 private static Bitmap getBitmapFromSDCard(String file) 
	 {
	      try  
	      {
	         String Env = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
	         Bitmap bitmap = BitmapFactory.decodeFile(Env + "/" + file);
	         Log.i("img1", Env + "/" + file);
	         Log.i("bitmap", bitmap.toString());
	         return bitmap;
	      }  
	      catch (Exception e)  
	      {  
	         e.printStackTrace();  
	         return null;  
	      }  
	 }
	 @Override
	 protected void onPause()   //按下退出鍵 系統預設呼叫 onPause
	 {
		 finish();
	     super.onDestroy(); //這行以防系統以為我亂呼叫
	 }


	    @Override
	    protected void onStop()
	    {
	     super.onStop();
	     super.onDestroy();
	     finish();
	    }


	    @Override
	    protected void onDestroy(){ //真正作用區
	        super.onDestroy();
	        //Kill myself
	        bitmap.recycle();
	        bitmap = null;
	    }

}
