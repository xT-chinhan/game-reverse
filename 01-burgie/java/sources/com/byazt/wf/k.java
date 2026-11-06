package com.byazt.wf;

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
@com.byazt.vzx.pr(pr = {0, 1, 201, 250})
public class k {
    public static String pr;

    public static String pr(Context context) {
        if (!TextUtils.isEmpty(pr)) {
            return pr;
        }
        String strPr = pr();
        pr = strPr;
        if (!TextUtils.isEmpty(strPr)) {
            return pr;
        }
        String strHw = hw();
        pr = strHw;
        if (!TextUtils.isEmpty(strHw)) {
            return pr;
        }
        String strHn = hn();
        pr = strHn;
        return strHn;
    }

    private static String pr() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                return Application.getProcessName();
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    private static String hw() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (!(objInvoke instanceof String)) {
                return null;
            }
            return (String) objInvoke;
        } catch (Throwable th) {
            return null;
        }
    }

    private static String hn() {
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
                } catch (IOException e) {
                }
                return string;
            } catch (Throwable th) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                    }
                }
                return null;
            }
        } catch (Throwable th2) {
            bufferedReader = null;
        }
    }
}
