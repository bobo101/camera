/**
 * 
 */
package com.example.custom_cameraactivity;

import java.io.File;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.util.Log;
import android.view.View;
/**
 * @author Peter
 *
 */
public class ImgListActivity extends Activity {
	  private ImageView img;
	  ListView list;
	        
	  @Override
	  protected void onCreate(Bundle savedInstanceState) 
	  {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.activity_img);
		  final ArrayList<String> FilesInFolder = GetFiles(Environment.getExternalStoragePublicDirectory
				  (Environment.DIRECTORY_PICTURES).toString() +"/MyCameraApp");
		  list = (ListView)findViewById(R.id.listView1);
		  
		  list.setAdapter(new ArrayAdapter<String>(this,
			        android.R.layout.simple_list_item_1, FilesInFolder));
		  list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
			    		//建立一個Bundle
			        	Bundle bundle = new Bundle();
			        	//將EditText(ip)的值傳入Bundle裡並命名為ip
			        	bundle.putString("ImgPath","MyCameraApp/"+FilesInFolder.get(position));
			        	Intent intent = new Intent(ImgListActivity.this,ImgShowActivity.class);
			        	//將bundle傳入
			    	    intent.putExtras(bundle);
			    	    ImgListActivity.this.startActivity(intent);
			    		
			         }
			    });	  
		  
      }
	  
	   
	   public ArrayList<String> GetFiles(String DirectoryPath) {
		    ArrayList<String> MyFiles = new ArrayList<String>();
		    File f = new File(DirectoryPath);

		    f.mkdirs();
		    File[] files = f.listFiles();
		    if (files.length == 0)
		        return null;
		    else {
		        for (int i=0; i<files.length; i++) 
		            MyFiles.add(files[i].getName());
		    }

		    return MyFiles;
		}

}
