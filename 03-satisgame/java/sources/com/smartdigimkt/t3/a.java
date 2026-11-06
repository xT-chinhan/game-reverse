package com.smartdigimkt.t3;

import android.text.TextUtils;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.w2.b;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public boolean a = false;
    public final Object b = new Object();
    public b c;

    public static Object a(Class cls, String str) {
        char[] cArr = k.a;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Constructor declaredConstructor = Class.forName(str).asSubclass(cls).getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(null);
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }
}
