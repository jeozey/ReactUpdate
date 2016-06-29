package com.skywds.android.bsdiffpatch;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.jeo.reactupdate.R;

/**
 * 类名称：MainActivity
 * 类描述：TODO(增量更新测试、例子)
 * 创建人：brok1n
 * 创建时间：2015年12月25日 下午10:06:03
 * 修改人：brok1n
 * 修改时间：2015年12月25日 下午10:06:03
 * 修改备注：
 * @version v1.0
*/
public class MainActivity extends Activity {

	private Button bsDiffBtn;
	private Button bsPatchBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_diffpatch);
		
		init();
		
	}
	
	/**
	 * @author brok1n
	 * 方法名称：init
	 * 描述：TODO(初始化)
	 * 创建时间：2015年12月25日 下午10:06:22
	 * void
	*/
	private void init()
	{
		this.bsDiffBtn = (Button) findViewById(R.id.bsdiff_btn);
		this.bsPatchBtn = (Button) findViewById(R.id.bspatch_btn);
		
		this.bsDiffBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					
					//int patch = JniApi.bspatch( "oldpath", "newpatch", "patchpath");
					//Toast.makeText( MainActivity.this, "patch:" + patch, Toast.LENGTH_SHORT).show();
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		
		this.bsPatchBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				try {
					
					//导出文件
					extrenOldFile();
					
					//int bsdiff = JniApi.bsdiff( "oldpath", "newpatch", "patchpath");
					//Toast.makeText( MainActivity.this, "bsdiff:" + bsdiff, Toast.LENGTH_SHORT).show();
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
		});
		
	}
	
	/**
	 * @author brok1n
	 * 方法名称：extrenOldFile
	 * 描述：TODO(增量更新部分逻辑操作)
	 * 创建时间：2015年12月25日 下午10:07:15
	 * void
	*/
	private void extrenOldFile()
	{
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				
				if( !Environment.MEDIA_MOUNTED.equals( Environment.getExternalStorageState() ))
				{
					toast("未检测到外部存储设备，无法导出文件");
					return ;
				}
				
				//先找到当前项目的旧版本的APK文件
				File file = new File( "/data/app/com.skywds.android.bsdiffpatch-1.apk" );
				if( !file.exists() )
				{
					file = new File( "/data/app/com.skywds.android.bsdiffpatch-2.apk" );
				}
				
				if( file.exists() && file.canRead() )
				{
					toast("文件可以读取");
				}
				else
				{
					toast("文件无法读取");
					return;
				}
				
				
				//处理要用到的 旧版本apk文件、新版本apk文件路径、增量更新补丁包文件路径
				//旧版本apk文件存放位置
				String oldFile = file.getAbsolutePath();
				//要生成的新版本apk文件存放位置
				String newFile = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "bsdiff" + File.separator + "upnew.apk";
				//增量更新补丁包存放的位置
				String updateFile = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "bsdiff" + File.separator + "update.patch";
				
				File upFile  = new File(updateFile);
				if( !upFile.exists() )
				{
					toast("补丁文件不存在");
					//return;
				}
				
				File nFile = new File( newFile);
				nFile.delete();
				
				//增量更新客户端关键步骤。调用这个native方法。
				//将patch补丁文件和旧版本APK文件生成新版本apk文件
				int status = JniApi.bspatch(oldFile, newFile, updateFile);
				
				//返回为0 代表处理成功。返回不为0 代表失败。
				//返回不为0的数字。可以查看 com_skywds_android_bsdiffpatch_JniApi.c 
				//里面return的数字对应的错误
				
				
				toast("增量更新文件处理完成:" + status);
				
				//安装
				File newAPKFile = new File( newFile);
				if( newAPKFile.exists() )
				{
					toast("新版本文件存在");
					installNewApk(newFile);
				}
			}
		});
		
		thread.start();
		
	}
	
	public void installNewApk( String filePath )
	{
		// 核心是下面几句代码  
        Intent intent = new Intent(Intent.ACTION_VIEW);  
        intent.setDataAndType(Uri.fromFile(new File(filePath)),  
                "application/vnd.android.package-archive");  
        MainActivity.this.startActivity(intent); 
	}
	
	public void toast( String str )
	{
		Message msg = Message.obtain();
		msg.arg1 = 0x123;
		msg.obj = str;
		mHandler.sendMessage(msg);
	}
	
	Handler mHandler = new Handler()
	{
		@Override
		public void handleMessage(Message msg) {
			
				Toast.makeText(MainActivity.this, "" + msg.obj.toString(), Toast.LENGTH_SHORT).show();
			
		}
	};

}
