package com.mcto.sspsdk.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class jd {
    public static Context a;
    public static String b;
    public static String c;
    public static final CopyOnWriteArraySet d = new CopyOnWriteArraySet();
    public static boolean e = true;
    public static final HashSet f = new HashSet();
    public static WeakReference g;

    public static void a(Context context, String str) {
        if (context instanceof Application) {
            a = context;
        } else {
            a = context.getApplicationContext();
        }
        b = str;
        ((Application) a).registerActivityLifecycleCallbacks(new id());
        f.size();
        a();
        b();
    }

    public static String b() {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        try {
            b = a.getPackageManager().getApplicationInfo(a.getPackageName(), 0).processName;
        } catch (Exception e2) {
            b = null;
            e2.toString();
        }
        String str = b;
        return str == null ? "" : str;
    }

    public static String a() {
        String processName;
        String str = "";
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                processName = Application.getProcessName();
            } else {
                processName = (String) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]).invoke(null, new Object[0]);
            }
        } catch (Exception e2) {
            e2.toString();
            processName = "";
        }
        if (processName != null) {
            str = processName;
        }
        c = str;
        return str;
    }
}
