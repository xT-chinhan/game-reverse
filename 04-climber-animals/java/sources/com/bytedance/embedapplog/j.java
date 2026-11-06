package com.bytedance.embedapplog;

import android.os.SystemProperties;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile Object f494ms;

    private Object ms() {
        if (f494ms == null) {
            synchronized (j.class) {
                if (f494ms == null) {
                    try {
                        f494ms = Class.forName("android.os.SystemProperties").newInstance();
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.sl.ms(th);
                    }
                }
            }
        }
        return f494ms;
    }

    public String ms(String str) {
        try {
            return SystemProperties.get(str);
        } catch (Throwable th) {
            oh.ms(th);
            try {
                Object objMs = ms();
                return (String) objMs.getClass().getMethod("get", String.class).invoke(objMs, str);
            } catch (Throwable th2) {
                oh.ms(th2);
                return "";
            }
        }
    }
}
