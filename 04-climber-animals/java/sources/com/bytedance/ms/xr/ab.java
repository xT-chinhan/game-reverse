package com.bytedance.ms.xr;

import android.app.Application;
import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ab {
    private static boolean ah = false;
    private static boolean d = false;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static boolean f546ms = false;
    private static boolean xr = false;

    public static synchronized void ms(Context context, ka kaVar, boolean z, boolean z2) {
        ms(context, kaVar, z, false, z2);
    }

    public static synchronized void ms(Context context, ka kaVar, boolean z, boolean z2, boolean z3) {
        ms(context, kaVar, z, z, z2, z3);
    }

    public static synchronized void ms(final Context context, ka kaVar, boolean z, boolean z2, boolean z3, final boolean z4) {
        if (f546ms) {
            return;
        }
        if (context == null) {
            throw new IllegalArgumentException("context must be not null.");
        }
        if (kaVar == null) {
            throw new IllegalArgumentException("params must be not null.");
        }
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        if (com.bytedance.ms.xr.x.ms.ah(context)) {
            return;
        }
        x.ms(context, kaVar);
        com.bytedance.ms.xr.ka.ms.ka.ms(context);
        if (z || z2) {
            com.bytedance.ms.xr.d.ms msVarMs = com.bytedance.ms.xr.d.ms.ms();
            if (z) {
                msVarMs.ms(new com.bytedance.ms.xr.d.ah(context));
            }
            xr = true;
        }
        d = z3;
        f546ms = true;
        ah = z4;
        com.bytedance.ms.xr.ka.ab.xr().post(new Runnable() { // from class: com.bytedance.ms.xr.ab.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.ms.xr.xr.ms.ms().ms(context);
                com.bytedance.ms.xr.ab.d.ms(context);
                if (z4) {
                    com.bytedance.ms.xr.ms.c.ms(context).ms();
                }
            }
        });
    }

    public static void ms(c cVar) {
        x.xr().ms(cVar);
    }

    public static void ms(Map<? extends String, ? extends String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        x.xr().ms(map);
    }

    public static void ms(final com.bytedance.ms.ms.xr xrVar) {
        com.bytedance.ms.xr.ka.ab.xr().post(new Runnable() { // from class: com.bytedance.ms.xr.ab.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.ms.ms.ms.ms(xrVar);
            }
        });
    }
}
