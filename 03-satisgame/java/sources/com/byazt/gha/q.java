package com.byazt.gha;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.byazt.nf.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 960, 5})
public class q {
    public static final Object qg = new Object();
    public SQLiteDatabase n = null;
    public final String q;
    public final Context s;

    public q(Context context, String str) {
        this.s = context;
        this.q = str;
    }

    public void n() {
        com.byazt.hs.s nVar;
        try {
            SQLiteDatabase sQLiteDatabase = this.n;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                return;
            }
            synchronized (qg) {
                SQLiteDatabase sQLiteDatabase2 = this.n;
                if (sQLiteDatabase2 == null || !sQLiteDatabase2.isOpen()) {
                    if (TextUtils.equals(this.q, "ttopensdk.db")) {
                        nVar = new com.byazt.hs.qg(this.s, tj.l >= 7100 ? 13 : 12);
                    } else {
                        nVar = TextUtils.equals(this.q, "ttopensdk2.db") ? new com.byazt.hs.n(this.s) : null;
                    }
                    if (nVar != null) {
                        this.n = nVar.getWritableDatabase();
                    }
                }
            }
        } catch (Throwable th) {
            if (w()) {
                throw th;
            }
        }
    }

    public SQLiteDatabase qg() {
        return this.n;
    }

    public void n(String str) throws SQLException {
        try {
            n();
            this.n.execSQL(str);
        } catch (Throwable th) {
            if (w()) {
                throw th;
            }
        }
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        try {
            n();
            return this.n.query(str, strArr, str2, strArr2, str3, str4, str5);
        } catch (Throwable th) {
            n nVar = new n();
            if (w()) {
                throw th;
            }
            return nVar;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) throws Exception {
        try {
            n();
            return this.n.update(str, contentValues, str2, strArr);
        } catch (Exception e) {
            if (w()) {
                throw e;
            }
            return 0;
        }
    }

    public long insert(String str, String str2, ContentValues contentValues) throws Exception {
        try {
            n();
            return this.n.insert(str, str2, contentValues);
        } catch (Exception e) {
            if (w()) {
                throw e;
            }
            return -1L;
        }
    }

    public int delete(String str, String str2, String[] strArr) throws Exception {
        try {
            n();
            return this.n.delete(str, str2, strArr);
        } catch (Exception e) {
            if (w()) {
                throw e;
            }
            return 0;
        }
    }

    public void s() {
        n();
        SQLiteDatabase sQLiteDatabase = this.n;
        if (sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.beginTransaction();
    }

    public void q() {
        n();
        SQLiteDatabase sQLiteDatabase = this.n;
        if (sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.setTransactionSuccessful();
    }

    public void l() {
        n();
        SQLiteDatabase sQLiteDatabase = this.n;
        if (sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.endTransaction();
    }

    private boolean w() {
        SQLiteDatabase sQLiteDatabase = this.n;
        return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
    }

    @com.byazt.cp.n(n = {0, 1, 960, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    private class n extends AbstractCursor {
        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i) {
            return true;
        }

        private n() {
        }
    }
}
