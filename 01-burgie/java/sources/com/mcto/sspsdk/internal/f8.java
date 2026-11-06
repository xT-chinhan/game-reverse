package com.mcto.sspsdk.internal;

import android.content.Context;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f8 {
    public static final AtomicBoolean a = new AtomicBoolean(false);
    public static final fb b;

    static {
        Looper looper;
        e8 e8Var = new e8();
        synchronized (s9.class) {
            if (s9.c == null) {
                HandlerThread handlerThread = new HandlerThread("ssp_temp");
                s9.c = handlerThread;
                handlerThread.start();
            }
            looper = s9.c.getLooper();
        }
        b = new fb(looper, e8Var);
    }

    public static void a() {
        if (!jd.a().endsWith("qysdk_simd") && a.compareAndSet(false, true)) {
            try {
                System.setProperty("java.net.preferIPv6Addresses", "true");
            } catch (Exception e) {
                r9.a("ssp_sdk", "preferIPv6Addresses", e);
            }
            if (Build.VERSION.SDK_INT >= 28) {
                String strB = jd.b();
                String strA = jd.a();
                if (!(("".equals(strB) || "".equals(strA)) ? true : strB.equals(strA))) {
                    try {
                        String strA2 = jd.a();
                        if (TextUtils.isEmpty(strA2)) {
                            strA2 = jd.a.getPackageName();
                        }
                        WebView.setDataDirectorySuffix(strA2);
                    } catch (Throwable th) {
                        r9.a("ssp_server", "WebKit init occured exception, WebKit has initlized", th);
                    }
                }
            }
            fb fbVar = b;
            fbVar.sendEmptyMessage(1);
            Context context = jd.a;
            fbVar.sendEmptyMessage(2);
        }
    }
}
