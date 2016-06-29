package com.skywds.android.bsdiffpatch;

public class JniApi {
	
	public static native int bspatch( String oldPath, String newPath, String patchPath );

	static
	{
		System.loadLibrary( "bsdiff" );
	}
	
}
