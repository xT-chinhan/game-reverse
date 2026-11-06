package com.byazt.tk;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, 793})
public final class hu {
    public static Method n(String str, String str2, Class<?>... clsArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Class<?> clsN = n(str);
            if (clsN != null) {
                return clsN.getMethod(str2, clsArr);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<?> n(String str) {
        try {
            try {
                try {
                    return Class.forName(str, true, n());
                } catch (ClassNotFoundException unused) {
                    return Class.forName(str);
                }
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        } catch (ClassNotFoundException unused3) {
            return Class.forName(str, true, hu.class.getClassLoader());
        }
    }

    private static ClassLoader n() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader == null ? hu.class.getClassLoader() : contextClassLoader;
    }
}
