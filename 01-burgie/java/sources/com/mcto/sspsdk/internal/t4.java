package com.mcto.sspsdk.internal;

import android.database.sqlite.SQLiteDatabase;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class t4 {
    public static s4 b;
    public static volatile t4 c;
    public static final AtomicInteger d = new AtomicInteger(0);
    public SQLiteDatabase a;

    public t4() {
        b = new s4(jd.a);
    }

    public static synchronized t4 b() {
        if (c == null) {
            try {
                c = new t4();
            } catch (Exception e) {
                c = null;
                r9.a("ssp_sdk", "DBHelper", e);
            }
        }
        return c;
    }

    public final synchronized void a() {
        SQLiteDatabase sQLiteDatabase;
        if (b == null) {
            r9.a("DBHelper", t4.class.getSimpleName().concat(" is not initialized, call initialize(..) method first."), null);
            return;
        }
        if (d.decrementAndGet() == 0 && (sQLiteDatabase = this.a) != null && sQLiteDatabase.isOpen()) {
            try {
                this.a.close();
            } catch (Exception e) {
                r9.a("ssp_sdk", "DBHelper", e);
            }
        }
    }

    public final synchronized SQLiteDatabase c() {
        if (b == null) {
            r9.a("DBHelper", t4.class.getSimpleName().concat(" is not initialized, call initialize(..) method first."), null);
            return null;
        }
        if (d.incrementAndGet() == 1) {
            try {
                this.a = b.getWritableDatabase();
            } catch (Exception e) {
                r9.a("ssp_sdk", "DBHelper", e);
                this.a = null;
                d.decrementAndGet();
            }
        }
        return this.a;
    }
}
