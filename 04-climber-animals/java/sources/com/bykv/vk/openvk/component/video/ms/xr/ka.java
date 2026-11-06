package com.bykv.vk.openvk.component.video.ms.xr;

import android.content.Context;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ka {
    static volatile boolean c;
    private static volatile com.bykv.vk.openvk.component.video.ms.xr.xr.ah ch;
    public static volatile boolean d;
    private static volatile Context hi;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static volatile com.bykv.vk.openvk.component.video.ms.xr.ms.xr f83ms;
    public static volatile Integer ny;
    static volatile com.bykv.vk.openvk.component.video.ms.xr.ms.ah xr;
    public static final boolean ah = com.bytedance.sdk.component.utils.sl.ah();
    static volatile boolean ka = true;
    static volatile int ab = 0;
    public static volatile int x = 3;

    public static Context getContext() {
        return hi;
    }

    public static void ms(boolean z) {
        ka = z;
    }

    public static void xr(boolean z) {
        c = z;
    }

    public static void ms(int i) {
        ab = i;
    }

    public static void ms(com.bykv.vk.openvk.component.video.ms.xr.ms.ah ahVar, Context context) {
        if (ahVar == null || context == null) {
            throw new IllegalArgumentException("DiskLruCache and Context can't be null !!!");
        }
        hi = context.getApplicationContext();
        if (xr != null) {
            return;
        }
        com.bykv.vk.openvk.component.video.ms.xr.ms.xr xrVar = f83ms;
        if (xrVar != null && xrVar.f98ms.getAbsolutePath().equals(ahVar.f90ms.getAbsolutePath())) {
            throw new IllegalArgumentException("DiskLruCache and DiskCache can't use the same dir");
        }
        xr = ahVar;
        ch = com.bykv.vk.openvk.component.video.ms.xr.xr.ah.ms(context);
        xr.ms(new com.bykv.vk.openvk.component.video.ms.xr.ms.ah.ms() { // from class: com.bykv.vk.openvk.component.video.ms.xr.ka.1
            @Override // com.bykv.vk.openvk.component.video.ms.xr.ms.ah.ms
            public void ms(String str) {
                if (ka.ah) {
                    com.bytedance.sdk.component.utils.sl.ms("TAG_PROXY_DiskLruCache", "new cache created: ".concat(String.valueOf(str)));
                }
            }

            @Override // com.bykv.vk.openvk.component.video.ms.xr.ms.ah.ms
            public void ms(Set<String> set) {
                ka.ch.ms(set, 0);
                if (ka.ah) {
                    com.bytedance.sdk.component.utils.sl.ms("TAG_PROXY_DiskLruCache", "cache file removed, ".concat(String.valueOf(set)));
                }
            }
        });
        c cVarMs = c.ms();
        cVarMs.ms(ahVar);
        cVarMs.ms(ch);
        d dVarAh = d.ah();
        dVarAh.ms(ahVar);
        dVarAh.ms(ch);
    }

    public static com.bykv.vk.openvk.component.video.ms.xr.ms.ah ms() {
        return xr;
    }

    public static com.bykv.vk.openvk.component.video.ms.xr.ms.xr xr() {
        return f83ms;
    }
}
