package com.bytedance.ms.xr;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class x {
    private static String ah = "default";
    private static volatile int ch = 0;
    private static boolean d = false;
    private static volatile String hi;
    private static com.bytedance.ms.xr.ka.ms ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Context f588ms;
    private static volatile ConcurrentHashMap<Integer, String> x;
    private static long xr;
    private static com.bytedance.ms.xr.ka.xr c = new com.bytedance.ms.xr.ka.xr();
    private static xr ab = new xr();
    private static com.bytedance.ms.xr.ka.x ny = null;

    public static com.bytedance.ms.xr.ka.ms ms() {
        return ka;
    }

    public static xr xr() {
        return ab;
    }

    public static com.bytedance.ms.xr.ka.x ah() {
        if (ny == null) {
            synchronized (x.class) {
                ny = new com.bytedance.ms.xr.ka.x(f588ms);
            }
        }
        return ny;
    }

    static void ms(Context context, ka kaVar) {
        xr = System.currentTimeMillis();
        f588ms = context;
        ka = new com.bytedance.ms.xr.ka.ms(f588ms, kaVar);
    }

    public static Context d() {
        return f588ms;
    }

    public static com.bytedance.ms.xr.ka.xr ka() {
        return c;
    }

    public static long c() {
        return xr;
    }

    public static String ab() {
        return ah;
    }

    public static boolean x() {
        return d;
    }

    public static ConcurrentHashMap<Integer, String> ny() {
        return x;
    }

    public static int ch() {
        return ch;
    }

    public static String hi() {
        return hi;
    }
}
