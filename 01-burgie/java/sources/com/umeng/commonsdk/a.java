package com.umeng.commonsdk;

import android.content.Context;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: UMInnerManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static Class<?> a;
    private static Method b;

    static {
        a = null;
        b = null;
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.UMInnerImpl");
            if (cls != null) {
                a = cls;
                Method declaredMethod = a.getDeclaredMethod("initAndSendInternal", Context.class);
                if (declaredMethod != null) {
                    b = declaredMethod;
                }
            }
        } catch (Throwable th) {
        }
    }

    public static void a(Context context) {
        if (context != null && UMUtils.isMainProgress(context)) {
            if (SdkVersion.SDK_TYPE != 1) {
                if (a != null && b != null) {
                    try {
                        b.invoke(a, context);
                        return;
                    } catch (Throwable th) {
                        return;
                    }
                }
                return;
            }
            UMConfigureInternation.sendInternal(context);
        }
    }
}
