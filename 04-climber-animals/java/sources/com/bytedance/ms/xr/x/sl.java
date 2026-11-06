package com.bytedance.ms.xr.x;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class sl {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f594ms;

    public static String ms(Context context) {
        if (!TextUtils.isEmpty(f594ms)) {
            return f594ms;
        }
        String strMs = ms();
        f594ms = strMs;
        if (!TextUtils.isEmpty(strMs)) {
            return f594ms;
        }
        String strXr = xr();
        f594ms = strXr;
        if (!TextUtils.isEmpty(strXr)) {
            return f594ms;
        }
        String strAh = ah();
        f594ms = strAh;
        return strAh;
    }

    private static String ms() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            return Application.getProcessName();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
            return null;
        }
    }

    private static String xr() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
            return null;
        }
    }

    private static String ah() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i = bufferedReader.read();
                    if (i <= 0) {
                        break;
                    }
                    sb.append((char) i);
                }
                String string = sb.toString();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return string;
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
    }
}
