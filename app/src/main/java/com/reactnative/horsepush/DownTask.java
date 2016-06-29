package com.reactnative.horsepush;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.speech.tts.Voice;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Administrator on 2016/6/29.
 */
public class DownTask extends AsyncTask<Void,Integer,Boolean>{
    public interface DownTaskCallBack{
            void onSucc();
            void onFailure();
            void onProgerss(Integer progress);
    }
    private String downUrl;
    private String path;
    private DownTaskCallBack callBack;
    private HashMap<String,Object> requsetPropertys;
    public DownTask(String downUrl,String path,HashMap<String,Object> requsetPropertys,DownTaskCallBack callBack){
        this.downUrl = downUrl;
        this.path = path;
        this.requsetPropertys = requsetPropertys;
        this.callBack = callBack;
    }
    @Override
    protected Boolean doInBackground(Void... params) {
            HttpURLConnection conn = null;

            try {
                URL url=new URL(downUrl);
                conn= (HttpURLConnection) url.openConnection();
                if(requsetPropertys!=null) {
                    Iterator itrator = requsetPropertys.keySet().iterator();
                    while (itrator.hasNext()) {
                        String key = String.valueOf(itrator.next());
                        Object value = requsetPropertys.get(key);
                        conn.setRequestProperty(key, String.valueOf(value));
                    }
                }
                conn.setRequestProperty("Accept-Language", "zh-CN");
                conn.setRequestProperty("Charset", "UTF-8");
                conn.setRequestProperty("Connection", "Keep-Alive");

                File file = new File(path);
                File parent = file.getParentFile();
                if(!parent.exists()){
                    parent.mkdirs();
                }
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file);

                InputStream in= new BufferedInputStream(conn.getInputStream());


                //获取文件流大小，用于更新进度
                int length=conn.getContentLength();
                int len=0,total_length=0,value=0;
                byte[] data=new byte[1024];

                while((len = in.read(data)) != -1){
                    fileOutputStream.write(data,0,len);
                    total_length += len;
                    value = (int)((total_length/(float)length)*100);
                    //调用update函数，更新进度
                    publishProgress(value);
                }

                in.close();
                fileOutputStream.flush();
                fileOutputStream.close();

                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (conn!=null)
                    conn.disconnect();
            }
        return false;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        if(callBack!=null){
            callBack.onProgerss(values[0]);
        }
    }

    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        if(result){
            if(callBack!=null){
                callBack.onSucc();
            }
        }else{
            if(callBack!=null){
                callBack.onFailure();
            }
        }
    }
}
