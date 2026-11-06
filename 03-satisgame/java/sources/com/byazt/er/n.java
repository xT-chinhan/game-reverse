package com.byazt.er;

import android.content.ContentValues;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.anythink.core.common.f.e;
import com.byazt.hls.q;
import com.byazt.hls.x;
import com.byazt.vf.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 717, 19})
public class n {
    public static volatile n qg;
    public qg n;

    public static n n() {
        if (qg == null) {
            synchronized (n.class) {
                if (qg == null) {
                    qg = new n();
                }
            }
        }
        return qg;
    }

    private n() {
        try {
            if (this.n == null) {
                this.n = new qg();
            }
        } catch (Throwable unused) {
        }
    }

    @com.byazt.cp.n(n = {0, 1, 717, 226})
    public class qg {
        public qg() {
        }

        private SQLiteDatabase n(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase == null) {
                return null;
            }
            try {
                if (!sQLiteDatabase.isOpen()) {
                    return null;
                }
                sQLiteDatabase.setLockingEnabled(false);
                return sQLiteDatabase;
            } catch (Throwable unused) {
                return null;
            }
        }

        public void n(SQLiteDatabase sQLiteDatabase, String str, String str2) throws SQLException {
            try {
                SQLiteDatabase sQLiteDatabaseN = n(sQLiteDatabase);
                if (sQLiteDatabaseN != null) {
                    sQLiteDatabaseN.execSQL(str);
                }
            } catch (Throwable th) {
                if (qg(sQLiteDatabase)) {
                    throw th;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Cursor query(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Object[] objArr = 0;
            try {
                SQLiteDatabase sQLiteDatabaseN = n(sQLiteDatabase);
                return sQLiteDatabaseN != null ? sQLiteDatabaseN.query(str, strArr, str2, strArr2, str3, str4, str5) : null;
            } catch (Throwable th) {
                C0170n c0170n = new C0170n();
                if (qg(sQLiteDatabase)) {
                    throw th;
                }
                return c0170n;
            }
        }

        public int update(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues, String str2, String[] strArr) throws Exception {
            try {
                SQLiteDatabase sQLiteDatabaseN = n(sQLiteDatabase);
                if (sQLiteDatabaseN != null) {
                    return sQLiteDatabaseN.update(str, contentValues, str2, strArr);
                }
                return 0;
            } catch (Exception e) {
                if (qg(sQLiteDatabase)) {
                    throw e;
                }
                return 0;
            }
        }

        public long insert(SQLiteDatabase sQLiteDatabase, String str, String str2, ContentValues contentValues) throws Exception {
            try {
                SQLiteDatabase sQLiteDatabaseN = n(sQLiteDatabase);
                if (sQLiteDatabaseN != null) {
                    return sQLiteDatabaseN.insert(str, str2, contentValues);
                }
                return -1L;
            } catch (Exception e) {
                if (qg(sQLiteDatabase)) {
                    throw e;
                }
                return -1L;
            }
        }

        public synchronized void insert(SQLiteDatabase sQLiteDatabase, k kVar, String str, String str2, List<com.byazt.vr.n> list) {
            SQLiteDatabase sQLiteDatabase2 = null;
            try {
                try {
                    SQLiteDatabase sQLiteDatabaseN = n(sQLiteDatabase);
                    if (sQLiteDatabaseN != null) {
                        sQLiteDatabaseN.beginTransaction();
                        ContentValues contentValues = new ContentValues();
                        for (int i = 0; i < list.size(); i++) {
                            com.byazt.vr.n nVar = list.get(i);
                            if (nVar == null) {
                                x.n("DBHelper", "adEvent == null");
                            } else {
                                JSONObject jSONObjectN = nVar.n();
                                if (jSONObjectN == null) {
                                    x.n("DBHelper", "event == null");
                                } else {
                                    x.n("DBHelper", "table:" + str + " db:" + sQLiteDatabaseN.getPath());
                                    q.n(nVar, "_db");
                                    contentValues.put("id", nVar.w());
                                    String strS = kVar.s(jSONObjectN.toString());
                                    if (!TextUtils.isEmpty(strS)) {
                                        contentValues.put(e.a.d, strS);
                                        contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                                        contentValues.put("retry", (Integer) 0);
                                        contentValues.put("encrypt", (Integer) 1);
                                        x.n("DBHelper", "insert:".concat(String.valueOf(sQLiteDatabaseN.insert(str, str2, contentValues))));
                                    } else {
                                        x.n("DBHelper", "encryptEvent is null");
                                    }
                                    contentValues.clear();
                                }
                            }
                        }
                        sQLiteDatabaseN.setTransactionSuccessful();
                    } else {
                        com.byazt.tk.k.qg("DBHelper", "db is null");
                    }
                    if (sQLiteDatabaseN != null) {
                        sQLiteDatabaseN.endTransaction();
                    }
                } catch (Exception e) {
                    com.byazt.tk.k.qg("DBHelper", e.getMessage());
                    if (qg(sQLiteDatabase)) {
                        throw e;
                    }
                    if (0 != 0) {
                        sQLiteDatabase2.endTransaction();
                    }
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    sQLiteDatabase2.endTransaction();
                }
                throw th;
            }
        }

        public int delete(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) throws Exception {
            try {
                SQLiteDatabase sQLiteDatabaseN = n(sQLiteDatabase);
                if (sQLiteDatabaseN != null) {
                    return sQLiteDatabaseN.delete(str, str2, strArr);
                }
                return 0;
            } catch (Exception e) {
                if (qg(sQLiteDatabase)) {
                    throw e;
                }
                return 0;
            }
        }

        private boolean qg(SQLiteDatabase sQLiteDatabase) {
            SQLiteDatabase sQLiteDatabaseN = n(sQLiteDatabase);
            return sQLiteDatabaseN != null && sQLiteDatabaseN.inTransaction();
        }
    }

    public qg qg() {
        return this.n;
    }

    /* JADX INFO: renamed from: com.byazt.er.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 717, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private class C0170n extends AbstractCursor {
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

        private C0170n() {
        }
    }
}
