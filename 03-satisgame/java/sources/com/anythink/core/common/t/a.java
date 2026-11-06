package com.anythink.core.common.t;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.anythink.core.common.h.bx;
import com.anythink.core.common.h.n;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String a = "a";
    private static final long b = 500;
    private static final Map<String, Long> c = new WeakHashMap();

    public static void a(Context context, MotionEvent motionEvent, bx bxVar) {
        if (motionEvent == null || bxVar == null || context == null) {
            return;
        }
        try {
            if (motionEvent.getAction() == 0 && (bxVar instanceof n)) {
                String strA = ((n) bxVar).A();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                Map<String, Long> map = c;
                Long l = map.get(strA);
                if (l == null || jElapsedRealtime - l.longValue() >= 500) {
                    map.put(strA, Long.valueOf(jElapsedRealtime));
                    com.anythink.core.common.u.c.a().b().b(bxVar);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(String str) {
        try {
            c.remove(str);
        } catch (Throwable unused) {
        }
    }
}
