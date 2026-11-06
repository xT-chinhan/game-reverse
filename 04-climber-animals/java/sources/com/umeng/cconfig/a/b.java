package com.umeng.cconfig.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.h;
import com.umeng.cconfig.b.d;
import com.umeng.commonsdk.statistics.common.ULog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static SQLiteOpenHelper c;
    private static Context d;
    public SQLiteDatabase a;
    private AtomicInteger b;

    static class a {
        private static final b a = new b(0);
    }

    private b() {
        this.b = new AtomicInteger();
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static b a(Context context) {
        if (d == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            d = applicationContext;
            c = com.umeng.cconfig.a.a.a(applicationContext);
        }
        return a.a;
    }

    public final synchronized SQLiteDatabase a() {
        if (this.b.incrementAndGet() == 1) {
            this.a = c.getWritableDatabase();
        }
        return this.a;
    }

    public final boolean a(String str) {
        SQLiteDatabase sQLiteDatabase;
        try {
            try {
                a();
                this.a.beginTransaction();
                String str2 = "update  __cc set __a=\"1\" where __ts=\"" + str + "\"";
                ULog.i("jessie", "[DbManager] updateCloudConfigByTimestamp：".concat(String.valueOf(str2)));
                this.a.execSQL(str2);
                this.a.setTransactionSuccessful();
                sQLiteDatabase = this.a;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Throwable unused) {
            }
        } catch (SQLiteDatabaseCorruptException e) {
            try {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    if (this.a != null) {
                        this.a.endTransaction();
                    }
                } catch (Throwable unused2) {
                }
                b();
            }
        } catch (Throwable unused3) {
            sQLiteDatabase = this.a;
            if (sQLiteDatabase != null) {
            }
        }
        b();
        return true;
    }

    public final synchronized void b() {
        try {
            if (this.b.decrementAndGet() == 0) {
                this.a.close();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0126 A[Catch: all -> 0x0129, DONT_GENERATE, TRY_LEAVE, TryCatch #3 {all -> 0x0129, blocks: (B:36:0x011f, B:37:0x0122, B:39:0x0126), top: B:55:0x011f }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0137 A[Catch: all -> 0x013a, FINALLY_INSNS, TRY_LEAVE, TryCatch #4 {all -> 0x013a, blocks: (B:44:0x0130, B:45:0x0133, B:47:0x0137), top: B:57:0x0130 }] */
    public final boolean b(String str) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            try {
                a();
                this.a.beginTransaction();
                cursorRawQuery = this.a.rawQuery("select *  from __cc where __a=\"1\" group by __ts", null);
                if (cursorRawQuery != null) {
                    while (cursorRawQuery.moveToNext()) {
                        String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__ts"));
                        String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(h.d.a.d));
                        String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__a"));
                        new StringBuilder().append(String.format("timeStamp = %s, content = %s, active = %s, id = %s", string, string2, string3, cursorRawQuery.getString(cursorRawQuery.getColumnIndex("id"))));
                        d dVar = new d();
                        dVar.a = string;
                        dVar.b = string2;
                        dVar.c = string3;
                        if (!TextUtils.isEmpty(string) && !str.equals(string)) {
                            arrayList.add(dVar);
                        }
                    }
                }
                int size = arrayList.size();
                String string4 = "";
                int i = 0;
                while (i < size) {
                    d dVar2 = (d) arrayList.get(i);
                    string4 = (i != size + (-1) ? new StringBuilder().append(string4).append("__ts=\"").append(dVar2.a).append("\" or ") : new StringBuilder().append(string4).append("__ts=\"").append(dVar2.a).append("\"")).toString();
                    String str2 = "update  __cc set __a=\"0\" where " + string4;
                    ULog.i("jessie", "[DbManager] updateOtherCloudConfigInfo : ".concat(String.valueOf(str2)));
                    this.a.execSQL(str2);
                    this.a.setTransactionSuccessful();
                    i++;
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                sQLiteDatabase = this.a;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Throwable unused) {
            }
        } catch (SQLiteDatabaseCorruptException e) {
            try {
                e.printStackTrace();
                if (cursorRawQuery != null) {
                    try {
                    } catch (Throwable unused2) {
                        return false;
                    }
                }
                return false;
            } finally {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                        sQLiteDatabase2 = this.a;
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.endTransaction();
                        }
                    } catch (Throwable unused3) {
                        b();
                    }
                } else {
                    sQLiteDatabase2 = this.a;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.endTransaction();
                    }
                }
                b();
            }
        } catch (Throwable unused4) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            sQLiteDatabase = this.a;
            if (sQLiteDatabase != null) {
            }
        }
        b();
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0095 A[Catch: all -> 0x0098, TRY_LEAVE, TryCatch #3 {all -> 0x0098, blocks: (B:9:0x008e, B:10:0x0091, B:12:0x0095), top: B:49:0x008e }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00d3 A[Catch: all -> 0x00d6, TRY_LEAVE, TryCatch #2 {all -> 0x00d6, blocks: (B:37:0x00cc, B:38:0x00cf, B:40:0x00d3), top: B:47:0x00cc }] */
    public final d c() {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        SQLiteDatabase sQLiteDatabase3;
        d dVar = new d();
        Cursor cursor = null;
        try {
            try {
                a();
                this.a.beginTransaction();
                Cursor cursorRawQuery = this.a.rawQuery("select *  from __cc where __a=\"1\" group by __ts", null);
                if (cursorRawQuery == null || !cursorRawQuery.moveToNext()) {
                    this.a.setTransactionSuccessful();
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    sQLiteDatabase = this.a;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                    return dVar;
                }
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__ts"));
                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(h.d.a.d));
                String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__a"));
                ULog.i("jessie", "[DbManager] selectRecentActiveOne".concat(String.valueOf(String.format("timeStamp = %s, content = %s, active = %s, id = %s", string, string2, string3, cursorRawQuery.getString(cursorRawQuery.getColumnIndex("id"))) + "\n")));
                d dVar2 = new d();
                dVar2.a = string;
                dVar2.b = string2;
                dVar2.c = string3;
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                        sQLiteDatabase3 = this.a;
                        if (sQLiteDatabase3 != null) {
                            sQLiteDatabase3.endTransaction();
                        }
                    } catch (Throwable unused) {
                    }
                } else {
                    sQLiteDatabase3 = this.a;
                    if (sQLiteDatabase3 != null) {
                        sQLiteDatabase3.endTransaction();
                    }
                }
                b();
                return dVar2;
            } catch (Throwable unused2) {
            }
        } catch (SQLiteDatabaseCorruptException e) {
            try {
                e.printStackTrace();
                if (0 != 0) {
                    cursor.close();
                }
                sQLiteDatabase = this.a;
                if (sQLiteDatabase != null) {
                }
            } finally {
                if (0 != 0) {
                    try {
                        cursor.close();
                        sQLiteDatabase2 = this.a;
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.endTransaction();
                        }
                    } catch (Throwable unused3) {
                        b();
                    }
                } else {
                    sQLiteDatabase2 = this.a;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.endTransaction();
                    }
                }
                b();
            }
        } catch (Throwable unused4) {
            if (0 != 0) {
                cursor.close();
            }
            sQLiteDatabase = this.a;
            if (sQLiteDatabase != null) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00e6 A[Catch: all -> 0x00e9, TRY_LEAVE, TryCatch #2 {all -> 0x00e9, blocks: (B:40:0x00df, B:41:0x00e2, B:43:0x00e6), top: B:50:0x00df }] */
    public final boolean d() {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            try {
                a();
                this.a.beginTransaction();
                cursorRawQuery = this.a.rawQuery("select *  from __cc where __a=\"0\" order by __ts asc", null);
                if (cursorRawQuery != null) {
                    while (cursorRawQuery.moveToNext()) {
                        arrayList.add(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__ts")));
                    }
                }
                int size = arrayList.size() - 5;
                String string = "";
                if (size > 0) {
                    int i = 0;
                    while (i < size) {
                        string = (i != size + (-1) ? new StringBuilder().append(string).append("__ts=\"").append((String) arrayList.get(i)).append("\" or ") : new StringBuilder().append(string).append("__ts=\"").append((String) arrayList.get(i)).append("\"")).toString();
                        i++;
                    }
                    String str = "delete from __cc where " + string;
                    ULog.i("jessie", "[DbManager] deleteExtraCloudConfigInfo: ".concat(String.valueOf(str)));
                    this.a.execSQL(str);
                    this.a.setTransactionSuccessful();
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                sQLiteDatabase = this.a;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Throwable unused) {
            }
        } catch (SQLiteDatabaseCorruptException e) {
            try {
                e.printStackTrace();
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                sQLiteDatabase = this.a;
                if (sQLiteDatabase != null) {
                }
            } finally {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                        sQLiteDatabase2 = this.a;
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.endTransaction();
                        }
                    } catch (Throwable unused2) {
                        b();
                    }
                } else {
                    sQLiteDatabase2 = this.a;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.endTransaction();
                    }
                }
                b();
            }
        } catch (Throwable unused3) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            sQLiteDatabase = this.a;
            if (sQLiteDatabase != null) {
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0092 A[Catch: all -> 0x0095, TRY_LEAVE, TryCatch #2 {all -> 0x0095, blocks: (B:10:0x008b, B:11:0x008e, B:13:0x0092), top: B:51:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00d0 A[Catch: all -> 0x00d3, TRY_LEAVE, TryCatch #1 {all -> 0x00d3, blocks: (B:38:0x00c9, B:39:0x00cc, B:41:0x00d0), top: B:49:0x00c9 }] */
    public final d e() {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        SQLiteDatabase sQLiteDatabase3;
        d dVar = new d();
        Cursor cursorRawQuery = null;
        try {
            try {
                try {
                    a();
                    this.a.beginTransaction();
                    cursorRawQuery = this.a.rawQuery("select *  from __cc order by __ts desc", null);
                    if (cursorRawQuery != null) {
                        while (cursorRawQuery.moveToNext()) {
                            String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__ts"));
                            String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(h.d.a.d));
                            String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__a"));
                            ULog.i("jessie", "[DbManager] getLastestConfigInfo".concat(String.valueOf(String.format("timeStamp = %s, content = %s, active = %s, id = %s", string, string2, string3, cursorRawQuery.getString(cursorRawQuery.getColumnIndex("id"))) + "\n")));
                            dVar.a = string;
                            dVar.b = string2;
                            dVar.c = string3;
                            if (string != null) {
                                if (cursorRawQuery != null) {
                                    try {
                                        cursorRawQuery.close();
                                        sQLiteDatabase3 = this.a;
                                        if (sQLiteDatabase3 != null) {
                                            sQLiteDatabase3.endTransaction();
                                        }
                                    } catch (Throwable unused) {
                                    }
                                } else {
                                    sQLiteDatabase3 = this.a;
                                    if (sQLiteDatabase3 != null) {
                                        sQLiteDatabase3.endTransaction();
                                    }
                                }
                                b();
                                return dVar;
                            }
                        }
                    }
                    this.a.setTransactionSuccessful();
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    sQLiteDatabase2 = this.a;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.endTransaction();
                    }
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                sQLiteDatabase2 = this.a;
                if (sQLiteDatabase2 != null) {
                }
            }
        } catch (SQLiteDatabaseCorruptException e) {
            try {
                e.printStackTrace();
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                sQLiteDatabase2 = this.a;
                if (sQLiteDatabase2 != null) {
                }
            } finally {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                        sQLiteDatabase = this.a;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Throwable unused4) {
                        b();
                    }
                } else {
                    sQLiteDatabase = this.a;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                }
                b();
            }
        }
        return dVar;
    }
}
