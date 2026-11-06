package com.byazt.mk;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1141, 19})
public class n {
    public static final Map<String, InterfaceC0247n> n = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: com.byazt.mk.n$n, reason: collision with other inner class name */
    public interface InterfaceC0247n {
    }

    public static void n(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        qg(str);
    }

    public static void n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        qg(str);
    }

    private static InterfaceC0247n qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return n.remove(str);
    }
}
