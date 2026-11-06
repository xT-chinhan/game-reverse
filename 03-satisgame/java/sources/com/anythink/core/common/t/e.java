package com.anythink.core.common.t;

import android.content.Context;
import com.anythink.core.common.h.bx;
import com.anythink.core.common.h.by;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static volatile e b;
    protected Context a;

    private e(Context context) {
        this.a = context.getApplicationContext();
    }

    public static e a(Context context) {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e(context);
                }
            }
        }
        return b;
    }

    public static void a(int i, bx bxVar) {
        a(i, bxVar, null, -1L);
    }

    public static void a(int i, bx bxVar, by byVar) {
        a(i, bxVar, byVar, -1L);
    }

    public static void a(int i, bx bxVar, by byVar, long j) {
        if (bxVar == null) {
            return;
        }
        synchronized (bxVar) {
            com.anythink.core.common.t.c.b.a(i, byVar, true);
            com.anythink.core.common.t.c.b.a(i, bxVar);
        }
        com.anythink.core.common.t.a.a.a().a(i, bxVar, byVar, j);
    }
}
