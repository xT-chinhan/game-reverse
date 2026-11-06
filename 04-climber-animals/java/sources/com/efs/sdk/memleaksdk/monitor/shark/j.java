package com.efs.sdk.memleaksdk.monitor.shark;

import android.os.Build;
import android.os.Debug;
import com.efs.sdk.memleaksdk.monitor.UMonitor;
import com.efs.sdk.memleaksdk.monitor.UMonitorJNI;

/* JADX INFO: loaded from: classes2.dex */
class j {
    private boolean a;

    /* synthetic */ j(byte b) {
        this();
    }

    static class a {
        private static final j a = new j(0);
    }

    private j() {
    }

    private void a() {
        if (!this.a && UMonitorJNI.a) {
            this.a = true;
            UMonitorJNI.init();
        }
    }

    public synchronized boolean a(String str) {
        g.b("UMonitor.Dump", "dump " + str);
        if (UMonitor.isNotSupport()) {
            throw new UnsupportedOperationException("not supported! android sdk version: " + Build.VERSION.SDK_INT);
        }
        a();
        boolean zResumeVM = false;
        if (!this.a) {
            g.d("UMonitor.Dump", "failed, so not load.");
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            g.b("UMonitor.Dump", "before suspend.");
            int iSuspendVM = UMonitorJNI.suspendVM();
            if (iSuspendVM == 0) {
                Debug.dumpHprofData(str);
                UMonitorJNI.exit();
            } else if (iSuspendVM > 0) {
                zResumeVM = UMonitorJNI.resumeVM(iSuspendVM);
                g.b("UMonitor.Dump", "dump hprof result: " + zResumeVM + ", from pid:" + iSuspendVM + " cost:" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
            }
        } catch (Throwable th) {
            g.b("UMonitor.Dump", "dump hprof failed.", th);
        }
        return zResumeVM;
    }
}
