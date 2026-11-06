package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

/* JADX INFO: compiled from: UMDBCreater.java */
/* JADX INFO: loaded from: classes4.dex */
class i extends SQLiteOpenHelper {
    private static Context b;
    private String a;

    /* JADX INFO: compiled from: UMDBCreater.java */
    private static class a {
        private static final i a = new i(i.b, k.b(i.b), h.b, null, 2);

        private a() {
        }
    }

    public static i a(Context context) {
        if (b == null) {
            b = context.getApplicationContext();
        }
        return a.a;
    }

    private i(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(new f(context, str), str2, cursorFactory, i);
    }

    private i(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, TextUtils.isEmpty(str) ? h.b : str, cursorFactory, i);
        this.a = null;
        a();
    }

    public void a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!k.a(h.d.a, writableDatabase)) {
                c(writableDatabase);
            }
            if (!k.a(h.c.a, writableDatabase)) {
                d(writableDatabase);
            }
            if (!k.a(h.b.a, writableDatabase)) {
                b(writableDatabase);
            }
            if (k.a(h.a.a, writableDatabase)) {
                return;
            }
            a(writableDatabase);
        } catch (Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                c(sQLiteDatabase);
                d(sQLiteDatabase);
                b(sQLiteDatabase);
                a(sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase == null) {
                }
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            k.a(b);
        } catch (Throwable unused3) {
            if (sQLiteDatabase == null) {
            }
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 <= i || i != 1) {
            return;
        }
        try {
            try {
                e(sQLiteDatabase);
            } catch (Exception unused) {
                f(sQLiteDatabase);
            }
        } catch (Exception unused2) {
            e(sQLiteDatabase);
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (!k.a(sQLiteDatabase, h.d.a, "__av")) {
            k.a(sQLiteDatabase, h.d.a, "__sp", "TEXT");
            k.a(sQLiteDatabase, h.d.a, "__pp", "TEXT");
            k.a(sQLiteDatabase, h.d.a, "__av", "TEXT");
            k.a(sQLiteDatabase, h.d.a, "__vc", "TEXT");
        }
        if (!k.a(sQLiteDatabase, h.b.a, "__av")) {
            k.a(sQLiteDatabase, h.b.a, "__av", "TEXT");
            k.a(sQLiteDatabase, h.b.a, "__vc", "TEXT");
        }
        if (k.a(sQLiteDatabase, h.a.a, "__av")) {
            return;
        }
        k.a(sQLiteDatabase, h.a.a, "__av", "TEXT");
        k.a(sQLiteDatabase, h.a.a, "__vc", "TEXT");
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, h.d.a);
        a(sQLiteDatabase, h.b.a);
        a(sQLiteDatabase, h.a.a);
        a();
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        } catch (SQLException unused) {
        }
    }
}
