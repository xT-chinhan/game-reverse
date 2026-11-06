package com.bytedance.sdk.openadsdk.op;

import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.g;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class hi {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Map<String, Field> f4076ms = new HashMap();

    public static void ms(String str) {
        try {
            if (g.xr < 5500) {
                ka(str);
                return;
            }
            Bridge bridgeC = com.bytedance.sdk.openadsdk.core.ch.ub().c(4);
            if (bridgeC != null) {
                bridgeC.call(100, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, str).xr(), null);
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
    }

    private static void ka(String str) {
        try {
            Class.forName("com.bytedance.pangle.Zeus").getDeclaredMethod("unInstallPlugin", String.class).invoke(null, str);
        } catch (Throwable unused) {
        }
    }

    public static int xr(String str) {
        if (TextUtils.equals("com.byted.pangle", str)) {
            return g.xr;
        }
        return ms(str, 101);
    }

    public static int ah(String str) {
        if (TextUtils.equals("com.byted.pangle", str)) {
            return 6923;
        }
        return ms(str, 103);
    }

    public static int d(String str) {
        if (TextUtils.equals("com.byted.pangle", str)) {
            return g.xr;
        }
        return ms(str, 102);
    }

    private static int ms(String str, int i) {
        Integer num;
        try {
            Bridge bridgeC = com.bytedance.sdk.openadsdk.core.ch.ub().c(4);
            if (bridgeC != null && (num = (Integer) bridgeC.call(i, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, str).xr(), Integer.class)) != null) {
                return num.intValue();
            }
        } catch (Throwable th) {
            sl.xr("ZeusUtil", th);
        }
        return 0;
    }
}
