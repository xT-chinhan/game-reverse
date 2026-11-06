package com.byazt.kh;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 913, 8})
public class s {
    public static final Object s = new Object();
    public n n;
    public Context qg;

    public s(Context context) {
        this.qg = context;
        try {
            if (this.n == null) {
                this.n = new n();
            }
        } catch (Throwable unused) {
        }
    }

    @com.byazt.cp.n(n = {0, 1, 913, 546})
    public class n {
        public SQLiteDatabase qg = null;

        public n() {
        }

        private void qg() {
            try {
                synchronized (s.s) {
                    SQLiteDatabase sQLiteDatabase = this.qg;
                    if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                        SQLiteDatabase writableDatabase = new qg(s.this.qg, "tt_mediation_open_sdk.db", 4).getWritableDatabase();
                        this.qg = writableDatabase;
                        writableDatabase.setLockingEnabled(false);
                    }
                }
            } catch (Throwable unused) {
                s();
            }
        }

        public SQLiteDatabase n() {
            qg();
            return this.qg;
        }

        private boolean s() {
            SQLiteDatabase sQLiteDatabase = this.qg;
            return sQLiteDatabase != null && sQLiteDatabase.isOpen() && sQLiteDatabase.inTransaction();
        }
    }

    public n n() {
        return this.n;
    }
}
