package com.reactnative.horsepush;

import com.skywds.android.bsdiffpatch.JniApi;

import java.io.File;

/**
 * 类说明： 	APK Patch工具类
 * 68xg.com
 */
public class HorsePushPatch {


//	static {
//		System.loadLibrary("bsdiff");
//	}
////
//	public static native int bspatch(String oldFilePath, String newFilePath, String patchPath);

	/**
	 * native方法 使用路径为oldApkPath的apk与路径为patchPath的补丁包，合成新的apk，并存储于newApkPath
	 *
	 * 返回：0，说明操作成功
	 *
	 * @param oldFilePath 示例:/sdcard/old.apk
	 * @param newFilePath 示例:/sdcard/new.apk
	 * @param patchPath  示例:/sdcard/xx.patch
	 * @return
	 */
	public static int horsePushPatch(String oldFilePath, String newFilePath, String patchPath){
		if(!(new File(oldFilePath).exists() && new File(patchPath).exists()))
			return -1;
//		return bspatch(oldFilePath,newFilePath,patchPath);
		return JniApi.bspatch(oldFilePath,newFilePath,patchPath);
	}


}