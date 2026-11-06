package com.byazt.zi;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.byazt.vx.w;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1948, 5})
public class q {
    public static String n;
    public static List<String> qg = new CopyOnWriteArrayList();

    private static String n() {
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
                if (ZeusLogger.isDebug()) {
                    ZeusLogger.d("Process", "get processName = " + sb.toString());
                }
                String string = sb.toString();
                try {
                    bufferedReader.close();
                } catch (Exception unused) {
                }
                return string;
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
    }

    public static String n(Context context) {
        if (!TextUtils.isEmpty(n)) {
            return n;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            String processName = Application.getProcessName();
            if (!TextUtils.isEmpty(processName)) {
                n = processName;
            }
            return n;
        }
        try {
            Object objInvokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.app.ActivityThread"), "currentProcessName", new Object[0]);
            if (!TextUtils.isEmpty((String) objInvokeStaticMethod)) {
                n = (String) objInvokeStaticMethod;
            }
            return n;
        } catch (Exception e) {
            w.n(e);
            String strN = n();
            n = strN;
            return strN;
        }
    }

    public static boolean qg(Context context) {
        String strN = n(context);
        return (strN == null || !strN.contains(":")) && strN != null && strN.equals(context.getPackageName());
    }

    public static String n(String str) {
        return (TextUtils.isEmpty(str) || !str.contains(":")) ? "main" : str.split(":")[1];
    }
}
