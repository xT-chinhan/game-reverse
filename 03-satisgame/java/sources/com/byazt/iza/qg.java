package com.byazt.iza;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.tbt.d;
import com.byazt.tk.w;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 761, 26})
public class qg {
    public static d l = null;
    public static boolean n = false;
    public static boolean q = false;
    public static Context qg = null;
    public static String s = null;
    public static int w = 1;

    public static Context getContext() {
        return qg;
    }

    public static String n() {
        if (TextUtils.isEmpty(s)) {
            try {
                File file = new File(w.n(getContext(), false, null), "ttad_dir");
                if (!file.exists()) {
                    file.mkdirs();
                }
                s = file.getAbsolutePath();
            } catch (Throwable unused) {
            }
        }
        return s;
    }

    public static void n(Context context, String str) {
        qg = context.getApplicationContext();
        s = str;
    }

    public static boolean qg() {
        return q;
    }

    public static void n(boolean z) {
        q = z;
    }

    public static d s() {
        if (l == null) {
            l = new d.n("v_config").n(10000L, TimeUnit.MILLISECONDS).qg(10000L, TimeUnit.MILLISECONDS).s(10000L, TimeUnit.MILLISECONDS).n();
        }
        return l;
    }

    public static void n(d dVar) {
        l = dVar;
    }

    public static boolean q() {
        return n;
    }

    public static int l() {
        return w;
    }
}
