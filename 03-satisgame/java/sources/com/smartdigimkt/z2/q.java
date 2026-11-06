package com.smartdigimkt.z2;

import android.database.Cursor;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends b {
    public static volatile q b;

    public q(d dVar) {
        super(dVar);
    }

    public static q a(d dVar) {
        if (b == null) {
            synchronized (q.class) {
                if (b == null) {
                    b = new q(dVar);
                }
            }
        }
        return b;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0032 A[Catch: all -> 0x0036, PHI: r11
      0x0032: PHI (r11v4 android.database.Cursor) = (r11v3 android.database.Cursor), (r11v5 android.database.Cursor) binds: [B:15:0x0030, B:12:0x002c] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0036, blocks: (B:9:0x0027, B:16:0x0032), top: B:26:0x0002 }] */
    public final synchronized boolean a(String str) {
        Cursor cursorQuery;
        try {
            try {
                cursorQuery = a().query(com.anythink.core.common.f.i.a.a, new String[]{"placement_id"}, "bid_id=?", new String[]{str}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.close();
                            cursorQuery.close();
                            return true;
                        }
                    } catch (Throwable unused) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        return false;
    }
}
