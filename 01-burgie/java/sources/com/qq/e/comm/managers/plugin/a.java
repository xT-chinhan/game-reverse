package com.qq.e.comm.managers.plugin;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static Method a;
    private static boolean b;

    private static void a(Throwable th) throws Throwable {
        if (b) {
            return;
        }
        if (a == null) {
            Method declaredMethod = Class.forName("com.tencent.bugly.crashreport.CrashReport").getDeclaredMethod("postCatchedException", Throwable.class);
            a = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        a.invoke(null, th);
    }

    public static void a(Throwable th, String str) {
        try {
            a(new Exception("插件错误：" + str, th));
        } catch (Throwable th2) {
            b = true;
        }
    }
}
