package com.umeng.umzid;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class Spy {
    public static boolean initSuccess;

    static {
        try {
            System.loadLibrary("umeng-spy");
            initSuccess = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String getID() {
        if (initSuccess) {
            return getNativeID();
        }
        return null;
    }

    public static native String getNativeID();

    public static native String getNativeLibraryVersion();

    public static native String getNativeTag(boolean z, boolean z2);

    /* JADX WARN: Code duplicated, block: B:24:0x003e  */
    public static synchronized String getTag(Context context) {
        String host;
        int port;
        boolean z;
        try {
            if (context != null) {
                try {
                    if (Build.VERSION.SDK_INT >= 14) {
                        host = System.getProperty("http.proxyHost");
                        String property = System.getProperty("http.proxyPort");
                        if (property == null) {
                            property = "-1";
                        }
                        port = Integer.parseInt(property);
                    } else {
                        host = Proxy.getHost(context);
                        port = Proxy.getPort(context);
                    }
                    z = (TextUtils.isEmpty(host) || port == -1) ? false : true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return getNativeTag(z, context != null ? d.e(context) : false);
    }

    public static String getVersion() {
        if (initSuccess) {
            return getNativeLibraryVersion();
        }
        return null;
    }
}
