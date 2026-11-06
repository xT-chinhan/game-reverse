package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.debug.UMRTLog;

/* JADX INFO: compiled from: CacheDBHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class ap extends SQLiteOpenHelper {
    private static final Object b = new Object();
    private static ap c = null;
    private static final String d = "CREATE TABLE IF NOT EXISTS stf(_id INTEGER PRIMARY KEY AUTOINCREMENT, _tp TEXT, _hd TEXT, _bd TEXT, _ts TEXT, _uuid TEXT, _re1 TEXT, _re2 TEXT)";
    private static final String e = "DROP TABLE IF EXISTS stf";
    private static final String f = "DELETE FROM stf WHERE _id IN( SELECT _id FROM stf ORDER BY _id LIMIT 1)";
    private final Context a;

    public static ap a(Context context) {
        ap apVar;
        synchronized (b) {
            if (c == null) {
                c = new ap(context, ar.b, null, 1);
            }
            apVar = c;
        }
        return apVar;
    }

    private ap(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.a = context;
    }

    public static final int a() {
        return 1;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(e);
            sQLiteDatabase.execSQL(d);
        } catch (SQLException e2) {
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(d);
        } catch (SQLiteDatabaseCorruptException e2) {
            a(sQLiteDatabase);
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]创建二级缓存数据库失败: " + th.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void b() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null && writableDatabase.isOpen()) {
                writableDatabase.close();
            }
        } catch (Throwable th) {
        }
    }

    public void a(String str, ContentValues contentValues) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null && writableDatabase.isOpen()) {
                try {
                    writableDatabase.beginTransaction();
                    writableDatabase.insert(str, null, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]插入二级缓存数据记录 成功。");
                    if (writableDatabase != null) {
                        writableDatabase.endTransaction();
                        writableDatabase.close();
                    }
                } catch (Throwable th) {
                    if (writableDatabase != null) {
                        writableDatabase.endTransaction();
                        writableDatabase.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
        }
    }

    public void a(String str, String str2, String[] strArr) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null && writableDatabase.isOpen()) {
                try {
                    try {
                        writableDatabase.beginTransaction();
                        writableDatabase.delete(str, str2, strArr);
                        writableDatabase.setTransactionSuccessful();
                        if (writableDatabase != null) {
                            writableDatabase.endTransaction();
                        }
                    } catch (Throwable th) {
                        if (writableDatabase != null) {
                            writableDatabase.endTransaction();
                        }
                    }
                } finally {
                    if (writableDatabase != null) {
                        writableDatabase.endTransaction();
                        writableDatabase.close();
                    }
                }
            }
        } catch (Throwable th2) {
        }
    }

    private void d() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null && writableDatabase.isOpen()) {
                try {
                    writableDatabase.execSQL(f);
                    if (writableDatabase == null) {
                        return;
                    }
                } catch (Throwable th) {
                    if (writableDatabase != null) {
                        writableDatabase.close();
                    }
                    throw th;
                }
                writableDatabase.close();
            }
        } catch (Throwable th2) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x008e  */
    /* JADX WARN: Code duplicated, block: B:27:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:42:? A[SYNTHETIC] */
    public aq a(String str) {
        Throwable th;
        Cursor cursor;
        aq aqVar;
        Throwable th2;
        try {
            Cursor cursorA = a(str, new String[]{ar.i, ar.e, ar.f, ar.g, ar.j, ar.k}, null, null, null, null, null, "1");
            if (cursorA != null) {
                try {
                    try {
                        if (cursorA.moveToFirst()) {
                            aq aqVar2 = new aq();
                            try {
                                aqVar2.a = cursorA.getString(0);
                                aqVar2.b = cursorA.getString(1);
                                String string = cursorA.getString(2);
                                String string2 = cursorA.getString(3);
                                aqVar2.c = i.a(this.a).d(string);
                                aqVar2.d = i.a(this.a).d(string2);
                                aqVar2.e = cursorA.getString(4);
                                aqVar2.f = cursorA.getString(5);
                                aqVar = aqVar2;
                            } catch (Throwable th3) {
                                cursor = cursorA;
                                aqVar = aqVar2;
                                try {
                                    d();
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                } catch (Throwable th4) {
                                    th2 = th4;
                                    th = th2;
                                    if (cursor == null) {
                                        throw th;
                                    }
                                    cursor.close();
                                    throw th;
                                }
                            }
                        } else {
                            aqVar = null;
                        }
                    } catch (Throwable th5) {
                        cursor = cursorA;
                        aqVar = null;
                        d();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return aqVar;
                    }
                } catch (Throwable th6) {
                    th2 = th6;
                    cursor = cursorA;
                    th = th2;
                    if (cursor == null) {
                        throw th;
                    }
                    cursor.close();
                    throw th;
                }
            } else {
                aqVar = null;
            }
            if (cursorA != null) {
                cursorA.close();
            }
        } catch (Throwable th7) {
            th = th7;
            cursor = null;
            if (cursor == null) {
                throw th;
            }
            cursor.close();
            throw th;
        }
        return aqVar;
    }

    public void a(String str, String str2) {
        a(str, "_uuid=?", new String[]{str2});
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return null;
            }
            return writableDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
        } catch (Throwable th) {
            return null;
        }
    }

    public boolean b(String str) throws Throwable {
        SQLiteDatabase writableDatabase;
        Cursor cursorQuery = null;
        try {
            writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    if (writableDatabase.isOpen()) {
                        cursorQuery = writableDatabase.query(str, null, null, null, null, null, null, null);
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (writableDatabase != null) {
                        writableDatabase.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (writableDatabase != null) {
                    writableDatabase.close();
                }
                return true;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (writableDatabase == null) {
                return false;
            }
            writableDatabase.close();
            return false;
        } catch (Throwable th2) {
            th = th2;
            writableDatabase = null;
        }
    }

    public boolean c() {
        if (!b(ar.c)) {
            return true;
        }
        return false;
    }
}
