package com.byazt.ya;

import android.content.ContentValues;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1039, 37})
public class pr {
    public static volatile pr hw;
    public hw pr;

    public static pr pr() {
        if (hw == null) {
            synchronized (pr.class) {
                if (hw == null) {
                    hw = new pr();
                }
            }
        }
        return hw;
    }

    private pr() {
        try {
            if (this.pr == null) {
                this.pr = new hw();
            }
        } catch (Throwable th) {
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1039, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE})
    public class hw {
        public hw() {
        }

        private SQLiteDatabase pr(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase != null) {
                try {
                    if (sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.setLockingEnabled(false);
                        return sQLiteDatabase;
                    }
                    return null;
                } catch (Throwable th) {
                    return null;
                }
            }
            return null;
        }

        public void pr(SQLiteDatabase sQLiteDatabase, String str, String str2) throws SQLException {
            try {
                SQLiteDatabase sQLiteDatabasePr = pr(sQLiteDatabase);
                if (sQLiteDatabasePr != null) {
                    sQLiteDatabasePr.execSQL(str);
                }
            } catch (Throwable th) {
                if (hw(sQLiteDatabase)) {
                    throw th;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Cursor query(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Cursor cursorQuery = null;
            Object[] objArr = 0;
            try {
                SQLiteDatabase sQLiteDatabasePr = pr(sQLiteDatabase);
                if (sQLiteDatabasePr != null) {
                    cursorQuery = sQLiteDatabasePr.query(str, strArr, str2, strArr2, str3, str4, str5);
                }
                return cursorQuery;
            } catch (Throwable th) {
                C0238pr c0238pr = new C0238pr();
                if (hw(sQLiteDatabase)) {
                    throw th;
                }
                return c0238pr;
            }
        }

        public int update(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues, String str2, String[] strArr) throws Exception {
            try {
                SQLiteDatabase sQLiteDatabasePr = pr(sQLiteDatabase);
                if (sQLiteDatabasePr == null) {
                    return 0;
                }
                return sQLiteDatabasePr.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                if (!hw(sQLiteDatabase)) {
                    return 0;
                }
                throw e;
            }
        }

        public long insert(SQLiteDatabase sQLiteDatabase, String str, String str2, ContentValues contentValues) throws Exception {
            try {
                SQLiteDatabase sQLiteDatabasePr = pr(sQLiteDatabase);
                if (sQLiteDatabasePr == null) {
                    return -1L;
                }
                return sQLiteDatabasePr.insert(str, str2, contentValues);
            } catch (Exception e) {
                if (!hw(sQLiteDatabase)) {
                    return -1L;
                }
                throw e;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x00c9, code lost:
        
            if (r0 != null) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x00cb, code lost:
        
            r0.endTransaction();
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00cf, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00e2, code lost:
        
            if (0 != 0) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00e6, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public synchronized void insert(android.database.sqlite.SQLiteDatabase r10, com.byazt.vkw.nt r11, java.lang.String r12, java.lang.String r13, java.util.List<com.byazt.hh.pr> r14) {
            /*
                Method dump skipped, instruction units count: 241
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.byazt.ya.pr.hw.insert(android.database.sqlite.SQLiteDatabase, com.byazt.vkw.nt, java.lang.String, java.lang.String, java.util.List):void");
        }

        public int delete(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) throws Exception {
            try {
                SQLiteDatabase sQLiteDatabasePr = pr(sQLiteDatabase);
                if (sQLiteDatabasePr == null) {
                    return 0;
                }
                return sQLiteDatabasePr.delete(str, str2, strArr);
            } catch (Exception e) {
                if (!hw(sQLiteDatabase)) {
                    return 0;
                }
                throw e;
            }
        }

        private boolean hw(SQLiteDatabase sQLiteDatabase) {
            SQLiteDatabase sQLiteDatabasePr = pr(sQLiteDatabase);
            return sQLiteDatabasePr != null && sQLiteDatabasePr.inTransaction();
        }
    }

    public hw hw() {
        return this.pr;
    }

    /* JADX INFO: renamed from: com.byazt.ya.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1039, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private class C0238pr extends AbstractCursor {
        private C0238pr() {
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
