package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

/* JADX INFO: compiled from: UMDBCreater.java */
/* JADX INFO: loaded from: classes3.dex */
class f extends SQLiteOpenHelper {
    private static Context b = null;
    private String a;

    /* JADX INFO: compiled from: UMDBCreater.java */
    private static class a {
        private static final f a = new f(f.b, h.b(f.b), e.b, null, 2);

        private a() {
        }
    }

    public static f a(Context context) {
        if (b == null) {
            b = context.getApplicationContext();
        }
        return a.a;
    }

    private f(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(new c(context, str), str2, cursorFactory, i);
    }

    private f(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, TextUtils.isEmpty(str) ? e.b : str, cursorFactory, i);
        this.a = null;
        a();
    }

    public void a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!h.a(e.d.a, writableDatabase)) {
                c(writableDatabase);
            }
            if (!h.a(e.c.a, writableDatabase)) {
                d(writableDatabase);
            }
            if (!h.a(e.b.a, writableDatabase)) {
                b(writableDatabase);
            }
            if (!h.a(e.a.a, writableDatabase)) {
                a(writableDatabase);
            }
        } catch (Exception e) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v4 */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase th) {
        try {
            try {
                th.beginTransaction();
                c(th);
                d(th);
                b(th);
                a(th);
                th.setTransactionSuccessful();
                if (th != 0) {
                    th.endTransaction();
                }
            } catch (SQLiteDatabaseCorruptException e) {
                h.a(b);
                if (th != 0) {
                    th.endTransaction();
                }
            } catch (Throwable th2) {
                if (th == 0) {
                } else {
                    th.endTransaction();
                }
            }
        } catch (Throwable th3) {
            if (th != 0) {
                try {
                    th.endTransaction();
                } catch (Throwable th4) {
                }
            }
            throw th3;
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.a);
        } catch (SQLException e) {
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.a);
        } catch (SQLException e) {
        }
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.a);
        } catch (SQLException e) {
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.a);
        } catch (SQLException e) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 > i && i == 1) {
            try {
                e(sQLiteDatabase);
            } catch (Exception e) {
                try {
                    e(sQLiteDatabase);
                } catch (Exception e2) {
                    f(sQLiteDatabase);
                }
            }
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (!h.a(sQLiteDatabase, e.d.a, "__av")) {
            h.a(sQLiteDatabase, e.d.a, "__sp", "TEXT");
            h.a(sQLiteDatabase, e.d.a, "__pp", "TEXT");
            h.a(sQLiteDatabase, e.d.a, "__av", "TEXT");
            h.a(sQLiteDatabase, e.d.a, "__vc", "TEXT");
        }
        if (!h.a(sQLiteDatabase, e.b.a, "__av")) {
            h.a(sQLiteDatabase, e.b.a, "__av", "TEXT");
            h.a(sQLiteDatabase, e.b.a, "__vc", "TEXT");
        }
        if (!h.a(sQLiteDatabase, e.a.a, "__av")) {
            h.a(sQLiteDatabase, e.a.a, "__av", "TEXT");
            h.a(sQLiteDatabase, e.a.a, "__vc", "TEXT");
        }
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, e.d.a);
        a(sQLiteDatabase, e.b.a);
        a(sQLiteDatabase, e.a.a);
        a();
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        } catch (SQLException e) {
        }
    }
}
