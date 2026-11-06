package com.efs.sdk.memleaksdk.monitor.shark;

import android.os.Build;
import com.efs.sdk.memleaksdk.monitor.UMonitor;
import com.efs.sdk.memleaksdk.monitor.UMonitorJNI;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    private boolean a;

    /* synthetic */ k(byte b) {
        this();
    }

    public static class a {
        private static final k a = new k(0);
    }

    private k() {
    }

    private void a() {
        if (!this.a && UMonitorJNI.a) {
            this.a = true;
            UMonitorJNI.initStrip();
        }
    }

    public synchronized boolean a(String str, String str2) {
        g.b("UMonitor.Strip", "path: " + str + "\nstrip: " + str2);
        if (UMonitor.isNotSupport()) {
            throw new UnsupportedOperationException("not supported! android sdk version: " + Build.VERSION.SDK_INT);
        }
        a();
        boolean zA = false;
        if (!this.a) {
            g.d("UMonitor.Strip", "dump failed caused by so not loaded!");
            return false;
        }
        try {
            UMonitorJNI.initStripPath(str, str2);
            zA = j.a.a.a(str);
            g.b("UMonitor.Strip", "dump result " + zA);
        } catch (Exception e) {
            g.b("UMonitor.Strip", "dump failed caused by ", e);
        }
        return zA;
    }
}
