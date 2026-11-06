package com.bytedance.pangle.ka;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Class f644ms;
    private static Object xr;

    public static final Object ms() {
        if (xr == null) {
            try {
                synchronized (ms.class) {
                    if (xr == null) {
                        if (f644ms == null) {
                            f644ms = Class.forName("android.app.ActivityThread");
                        }
                        xr = MethodUtils.invokeStaticMethod(f644ms, "currentActivityThread", new Object[0]);
                    }
                    if (xr == null && Looper.myLooper() != Looper.getMainLooper()) {
                        final Object obj = new Object();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.pangle.ka.ms.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    try {
                                        Object unused = ms.xr = MethodUtils.invokeStaticMethod(ms.f644ms, "currentActivityThread", new Object[0]);
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
                        if (xr == null) {
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
        return xr;
    }
}
