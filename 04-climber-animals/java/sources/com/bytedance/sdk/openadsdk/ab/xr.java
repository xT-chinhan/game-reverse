package com.bytedance.sdk.openadsdk.ab;

import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.TTC;
import com.bytedance.sdk.openadsdk.TTM;
import com.bytedance.sdk.openadsdk.api.TTILog;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static void ms(Object obj) {
        try {
            ah(obj);
        } catch (Throwable th) {
            sl.xr("HookObject", "register object  " + obj + " failed for: " + th.getMessage());
        }
    }

    private static void ah(Object obj) {
        if (obj == null) {
            return;
        }
        String strC = c(obj);
        strC.hashCode();
        if (strC.equals("log")) {
            d(obj);
        } else if (strC.equals(TKDownloadReason.KSAD_TK_NET)) {
            ka(obj);
        }
        sl.xr("HookObject", "register object  " + obj + " successed~ ");
    }

    private static void d(Object obj) {
        if (obj instanceof TTILog) {
            LogAdapter.ms((TTILog) obj, true);
        }
    }

    private static void ka(Object obj) {
        if (sl.ah()) {
            d dVar = new d();
            d.f1644ms = dVar;
            for (Method method : obj.getClass().getDeclaredMethods()) {
                TTM ttm = (TTM) method.getAnnotation(TTM.class);
                if (ttm != null) {
                    method.setAccessible(true);
                    dVar.ms(ttm.value(), method);
                }
            }
            dVar.ms(obj);
        }
    }

    private static String c(Object obj) {
        TTC ttc;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Class) {
            ttc = (TTC) ((Class) obj).getAnnotation(TTC.class);
        } else {
            ttc = (TTC) obj.getClass().getAnnotation(TTC.class);
        }
        return ttc == null ? "" : ttc.value();
    }

    public static void xr(Object obj) {
        ms(c(obj));
    }

    public static void ms(String str) {
        str.hashCode();
        if (str.equals(TKDownloadReason.KSAD_TK_NET)) {
            d.f1644ms = null;
        }
    }

    public static ah xr(String str) {
        str.hashCode();
        if (str.equals(TKDownloadReason.KSAD_TK_NET)) {
            return d.f1644ms;
        }
        return null;
    }
}
