LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := bsdiff

LOCAL_MODULE_FILENAME :=libbsdiff

LOCAL_LDLIBS :=-llog

LOCAL_SRC_FILES := com_skywds_android_bsdiffpatch_JniApi.c	\
				blocksort.c	\
				bzlib.c		\
				bzlib.h		\
				bzip2.c		\
				bzip2recover.c	\
				bzlib_private.h	\
				compress.c	\
				crctable.c	\
				decompress.c	\
				huffman.c	\
				mk251.c		\
				randtable.c	\
				spewG.c		\
				unzcrash.c	\
				
				
				
#LOCAL_STATIC_LIBRARIES := libbz

#include $(BUILD_SHARED_LIBRARY)

include $(BUILD_EXECUTABLE)