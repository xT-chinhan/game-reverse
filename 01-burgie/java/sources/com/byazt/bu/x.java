package com.byazt.bu;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.byazt.sd.iu;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 873, 121})
public class x {
    public static final Object hw = new Object();
    public final Context hn;
    public SQLiteDatabase pr = null;
    public final String x;

    public x(Context context, String str) {
        this.hn = context;
        this.x = str;
    }

    public void pr() {
        try {
            SQLiteDatabase sQLiteDatabase = this.pr;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                return;
            }
            synchronized (hw) {
                SQLiteDatabase sQLiteDatabase2 = this.pr;
                if (sQLiteDatabase2 == null || !sQLiteDatabase2.isOpen()) {
                    com.byazt.qb.hn prVar = null;
                    if (TextUtils.equals(this.x, "ttopensdk.db")) {
                        prVar = new com.byazt.qb.hw(this.hn, iu.x >= 7100 ? 13 : 12);
                    } else if (TextUtils.equals(this.x, "ttopensdk2.db")) {
                        prVar = new com.byazt.qb.pr(this.hn);
                    }
                    if (prVar != null) {
                        this.pr = prVar.getWritableDatabase();
                    }
                }
            }
        } catch (Throwable th) {
            if (uc()) {
                throw th;
            }
        }
    }

    public SQLiteDatabase hw() {
        return this.pr;
    }

    public void pr(String str) throws SQLException {
        try {
            pr();
            this.pr.execSQL(str);
        } catch (Throwable th) {
            if (uc()) {
                throw th;
            }
        }
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        try {
            pr();
            return this.pr.query(str, strArr, str2, strArr2, str3, str4, str5);
        } catch (Throwable th) {
            pr prVar = new pr();
            if (uc()) {
                throw th;
            }
            return prVar;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) throws Exception {
        try {
            pr();
            return this.pr.update(str, contentValues, str2, strArr);
        } catch (Exception e) {
            if (!uc()) {
                return 0;
            }
            throw e;
        }
    }

    public long insert(String str, String str2, ContentValues contentValues) throws Exception {
        try {
            pr();
            return this.pr.insert(str, str2, contentValues);
        } catch (Exception e) {
            if (!uc()) {
                return -1L;
            }
            throw e;
        }
    }

    public int delete(String str, String str2, String[] strArr) throws Exception {
        try {
            pr();
            return this.pr.delete(str, str2, strArr);
        } catch (Exception e) {
            if (!uc()) {
                return 0;
            }
            throw e;
        }
    }

    public void hn() {
        pr();
        SQLiteDatabase sQLiteDatabase = this.pr;
        if (sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.beginTransaction();
    }

    public void x() {
        pr();
        SQLiteDatabase sQLiteDatabase = this.pr;
        if (sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.setTransactionSuccessful();
    }

    public void c() {
        pr();
        SQLiteDatabase sQLiteDatabase = this.pr;
        if (sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.endTransaction();
    }

    private boolean uc() {
        SQLiteDatabase sQLiteDatabase = this.pr;
        return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
    }

    @com.byazt.vzx.pr(pr = {0, 1, 873, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    private class pr extends AbstractCursor {
        private pr() {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i) {
            return (short) 0;
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
        public float getFloat(int i) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i) {
            return true;
        }
    }
}
