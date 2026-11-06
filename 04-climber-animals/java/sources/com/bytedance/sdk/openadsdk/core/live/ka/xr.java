package com.bytedance.sdk.openadsdk.core.live.ka;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.jw.g;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static com.bytedance.sdk.component.d.ms.xr f2833ms;

    private static void xr() {
        if (f2833ms == null) {
            f2833ms = g.ms("csj_live");
        }
    }

    public static void ms(String str) {
        xr();
        try {
            com.bytedance.sdk.component.d.ms.xr xrVar = f2833ms;
            if (xrVar != null) {
                f2833ms.ms("live_init_".concat(String.valueOf(str)), xrVar.xr("live_init_".concat(String.valueOf(str)), 0) + 1);
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
    }

    public static void xr(String str) {
        xr();
        try {
            com.bytedance.sdk.component.d.ms.xr xrVar = f2833ms;
            if (xrVar != null) {
                xrVar.ms("live_init_".concat(String.valueOf(str)), 0);
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
    }

    public static boolean ah(String str) {
        xr();
        com.bytedance.sdk.component.d.ms.xr xrVar = f2833ms;
        return (xrVar != null ? xrVar.xr("live_init_".concat(String.valueOf(str)), 0) : 0) < 5;
    }

    public static void d(String str) {
        ms();
        xr(str);
    }

    public static void ms() {
        try {
            Bridge bridgeC = ch.ub().c(4);
            if (bridgeC != null) {
                bridgeC.call(100, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, "com.byted.live.lite").xr(), null);
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
    }
}
