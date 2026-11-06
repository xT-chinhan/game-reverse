package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: UMDBManager.java */
/* JADX INFO: loaded from: classes3.dex */
class g {
    private static SQLiteOpenHelper b;
    private static Context d;
    private AtomicInteger a;
    private SQLiteDatabase c;

    private g() {
        this.a = new AtomicInteger();
    }

    /* JADX INFO: compiled from: UMDBManager.java */
    private static class a {
        private static final g a = new g();

        private a() {
        }
    }

    public static g a(Context context) {
        if (d == null && context != null) {
            d = context.getApplicationContext();
            b = f.a(d);
        }
        return a.a;
    }

    public synchronized SQLiteDatabase a() {
        if (this.a.incrementAndGet() == 1) {
            this.c = b.getWritableDatabase();
        }
        return this.c;
    }

    public synchronized void b() {
        try {
            if (this.a.decrementAndGet() == 0) {
                this.c.close();
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
