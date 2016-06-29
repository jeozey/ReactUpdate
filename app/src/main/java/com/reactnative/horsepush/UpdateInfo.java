package com.reactnative.horsepush;

/**
 * Created by Administrator on 2016/6/29.
 */
public class UpdateInfo {
    public UpdateInfo() {
    }
    /**
     * code : 200
     * msg : succ
     * data : {"javaVersionCode":2,"javaVersionInfo":"new apk version","javaForceUpdate":false,"javaPatchDownlink":"http://192.168.211.166:8889/update/test.patch","javaDownlink":"http://192.168.211.166:8889/update/new.apk","javaDownlinkMd5":"8342C0F085281769F36C50401636177C","jsVersionInfo":"click to the new version","jsForceUpdate":false,"jsPatchDownlink":"http://192.168.211.166:8889/update/js.patch","jsDownlink":"http://192.168.211.166:8889/update/new.js","jsDownlinkMd5":"5C1A4609425AC2D55B189C0B99967D5A","startpageimg":"http://192.168.211.166:8889/update/startpage.png"}
     */

    private int code;
    private String msg;
    /**
     * javaVersionCode : 2
     * javaVersionInfo : new apk version
     * javaForceUpdate : false
     * javaPatchDownlink : http://192.168.211.166:8889/update/test.patch
     * javaDownlink : http://192.168.211.166:8889/update/new.apk
     * javaDownlinkMd5 : 8342C0F085281769F36C50401636177C
     * jsVersionInfo : click to the new version
     * jsForceUpdate : false
     * jsPatchDownlink : http://192.168.211.166:8889/update/js.patch
     * jsDownlink : http://192.168.211.166:8889/update/new.js
     * jsDownlinkMd5 : 5C1A4609425AC2D55B189C0B99967D5A
     * startpageimg : http://192.168.211.166:8889/update/startpage.png
     */

    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int javaVersionCode;
        private String javaVersionInfo;
        private boolean javaForceUpdate;
        private String javaPatchDownlink;
        private String javaDownlink;
        private String javaDownlinkMd5;
        private String jsVersionInfo;
        private boolean jsForceUpdate;
        private String jsPatchDownlink;
        private String jsDownlink;
        private String jsDownlinkMd5;
        private String startpageimg;

        public int getJavaVersionCode() {
            return javaVersionCode;
        }

        public void setJavaVersionCode(int javaVersionCode) {
            this.javaVersionCode = javaVersionCode;
        }

        public String getJavaVersionInfo() {
            return javaVersionInfo;
        }

        public void setJavaVersionInfo(String javaVersionInfo) {
            this.javaVersionInfo = javaVersionInfo;
        }

        public boolean isJavaForceUpdate() {
            return javaForceUpdate;
        }

        public void setJavaForceUpdate(boolean javaForceUpdate) {
            this.javaForceUpdate = javaForceUpdate;
        }

        public String getJavaPatchDownlink() {
            return javaPatchDownlink;
        }

        public void setJavaPatchDownlink(String javaPatchDownlink) {
            this.javaPatchDownlink = javaPatchDownlink;
        }

        public String getJavaDownlink() {
            return javaDownlink;
        }

        public void setJavaDownlink(String javaDownlink) {
            this.javaDownlink = javaDownlink;
        }

        public String getJavaDownlinkMd5() {
            return javaDownlinkMd5;
        }

        public void setJavaDownlinkMd5(String javaDownlinkMd5) {
            this.javaDownlinkMd5 = javaDownlinkMd5;
        }

        public String getJsVersionInfo() {
            return jsVersionInfo;
        }

        public void setJsVersionInfo(String jsVersionInfo) {
            this.jsVersionInfo = jsVersionInfo;
        }

        public boolean isJsForceUpdate() {
            return jsForceUpdate;
        }

        public void setJsForceUpdate(boolean jsForceUpdate) {
            this.jsForceUpdate = jsForceUpdate;
        }

        public String getJsPatchDownlink() {
            return jsPatchDownlink;
        }

        public void setJsPatchDownlink(String jsPatchDownlink) {
            this.jsPatchDownlink = jsPatchDownlink;
        }

        public String getJsDownlink() {
            return jsDownlink;
        }

        public void setJsDownlink(String jsDownlink) {
            this.jsDownlink = jsDownlink;
        }

        public String getJsDownlinkMd5() {
            return jsDownlinkMd5;
        }

        public void setJsDownlinkMd5(String jsDownlinkMd5) {
            this.jsDownlinkMd5 = jsDownlinkMd5;
        }

        public String getStartpageimg() {
            return startpageimg;
        }

        public void setStartpageimg(String startpageimg) {
            this.startpageimg = startpageimg;
        }
    }
}
