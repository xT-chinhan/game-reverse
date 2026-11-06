package com.bytedance.sdk.openadsdk.core.jw;

import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes2.dex */
public class x {
    public static boolean ms() {
        try {
            if (com.bytedance.sdk.openadsdk.core.ch.ub().xn()) {
                return true;
            }
            Context context = com.bytedance.sdk.openadsdk.core.re.getContext();
            if (context.getApplicationInfo() != null && (context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void ms(com.bytedance.sdk.openadsdk.core.f.ms msVar) {
        try {
            if (!msVar.ny() || com.bytedance.sdk.component.utils.sl.ms()) {
                return;
            }
            System.currentTimeMillis();
            if (Boolean.parseBoolean(new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop debug.ttcsj.debugmode").getInputStream())).readLine())) {
                com.bytedance.sdk.component.utils.sl.xr();
                com.bykv.vk.openvk.component.video.api.c.ah.ms();
                com.bytedance.sdk.component.ny.ms.ms();
                com.bytedance.sdk.openadsdk.tools.xr.xr();
                com.bytedance.sdk.component.sl.xr.ms.ms(true);
            }
        } catch (Exception unused) {
        }
    }
}
