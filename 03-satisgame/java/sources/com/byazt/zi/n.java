package com.byazt.zi;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1948, 19})
public class n {
    public static Class n;
    public static Object qg;

    public static final Object n() {
        if (qg == null) {
            try {
                synchronized (n.class) {
                    if (qg == null) {
                        if (n == null) {
                            n = Class.forName("android.app.ActivityThread");
                        }
                        qg = MethodUtils.invokeStaticMethod(n, "currentActivityThread", new Object[0]);
                    }
                    if (qg == null && Looper.myLooper() != Looper.getMainLooper()) {
                        final Object obj = new Object();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.byazt.zi.n.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    try {
                                        Object unused = n.qg = MethodUtils.invokeStaticMethod(n.n, "currentActivityThread", new Object[0]);
                                        synchronized (obj) {
                                            obj.notify();
                                        }
                                    } catch (Exception e) {
                                        ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper main looper invoke currentActivityThread failed.", e);
                                        synchronized (obj) {
                                            obj.notify();
                                        }
                                    }
                                } catch (Throwable th) {
                                    synchronized (obj) {
                                        obj.notify();
                                        throw th;
                                    }
                                }
                            }
                        });
                        if (qg == null) {
                            synchronized (obj) {
                                try {
                                    obj.wait(5000L);
                                } catch (InterruptedException e) {
                                    ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread interruptedException failed.", e);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread failed.", e2);
            }
        }
        return qg;
    }
}
