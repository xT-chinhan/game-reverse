package com.smartdigimkt.t;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.q2.g;
import com.smartdigimkt.r4.h;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.sdk.core.bridge.entity.DeviceInfoEntity;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {
    public static String a = "";
    public static boolean b = false;
    public static boolean c = false;
    public static volatile long g;
    public static final AtomicInteger d = new AtomicInteger(0);
    public static final AtomicLong e = new AtomicLong(0);
    public static final Object f = new Object();
    public static volatile boolean h = false;

    public static void a(Context context, String str, boolean z) {
        a = str;
        String str2 = h.a;
        if (!TextUtils.isEmpty(str)) {
            d.set(11);
        }
        if (z) {
            y.a(context, "sdm_adx_rp_sdk", "oaid", str);
        }
    }

    public static String a(Context context) {
        if (!SDKContext.getInstance().a("oaid")) {
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            synchronized (f) {
                if (!c) {
                    c = true;
                    a = y.c(context, "sdm_adx_rp_sdk", "oaid");
                }
                if (!TextUtils.isEmpty(a)) {
                    return a;
                }
                if (!g.e && b && !SDKContext.getInstance().l) {
                    a(g.f ? 3 : 2, "");
                    return "";
                }
                if (b) {
                    return a;
                }
                b = true;
                g = System.currentTimeMillis();
                Object obj = new Object();
                boolean[] zArr = {false};
                d.incrementAndGet();
                e.set(System.currentTimeMillis());
                com.smartdigimkt.q.e.a(context, new b(context, obj, zArr));
                if (!zArr[0]) {
                    try {
                        synchronized (obj) {
                            obj.wait(1500L);
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (!zArr[0] && TextUtils.isEmpty(a)) {
                    a(4, "");
                }
                String str = a;
                if (str == null) {
                    str = "";
                }
                return str;
            }
        }
        a(1, "");
        return "";
    }

    public static String a() {
        if (SDKContext.getInstance().a("oaid")) {
            return "";
        }
        if (TextUtils.isEmpty(a)) {
            DeviceInfoEntity deviceInfoEntity = h.W;
            if (deviceInfoEntity != null) {
                return deviceInfoEntity.getOaid();
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            AtomicLong atomicLong = e;
            if (jCurrentTimeMillis - atomicLong.get() > 5000) {
                AtomicInteger atomicInteger = d;
                if (atomicInteger.get() < 10 && SDKContext.getInstance().l) {
                    atomicInteger.incrementAndGet();
                    atomicLong.set(System.currentTimeMillis());
                    com.smartdigimkt.q3.f.a().c(new d());
                }
            }
        }
        return a;
    }

    public static void a(int i, String str) {
        if (!h || i == 6) {
            h = true;
            com.smartdigimkt.q3.f.a().c(new e(i, str, g > 0 ? System.currentTimeMillis() - g : 0L));
        }
    }
}
