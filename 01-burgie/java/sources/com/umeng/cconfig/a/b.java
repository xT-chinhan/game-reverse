package com.umeng.cconfig.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.e;
import com.umeng.cconfig.b.d;
import com.umeng.commonsdk.statistics.common.ULog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
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
        try {
            try {
                try {
                    a();
                    this.a.beginTransaction();
                    String str2 = "update  __cc set __a=\"1\" where __ts=\"" + str + "\"";
                    ULog.i("jessie", "[DbManager] updateCloudConfigByTimestamp：".concat(String.valueOf(str2)));
                    this.a.execSQL(str2);
                    this.a.setTransactionSuccessful();
                    if (this.a != null) {
                        this.a.endTransaction();
                    }
                } catch (Throwable th) {
                    try {
                        if (this.a != null) {
                            this.a.endTransaction();
                        }
                    } catch (Throwable th2) {
                    }
                    b();
                    throw th;
                }
            } catch (SQLiteDatabaseCorruptException e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.endTransaction();
                    }
                } catch (Throwable th3) {
                }
                b();
                return false;
            } catch (Throwable th4) {
                if (this.a != null) {
                    this.a.endTransaction();
                }
            }
        } catch (Throwable th5) {
        }
        b();
        return true;
    }

    public final synchronized void b() {
        try {
            if (this.b.decrementAndGet() == 0) {
                this.a.close();
            }
        } catch (Throwable th) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0141 A[Catch: Throwable -> 0x013b, TRY_LEAVE, TryCatch #0 {Throwable -> 0x013b, blocks: (B:48:0x0137, B:51:0x013d, B:53:0x0141), top: B:65:0x0137 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0156 A[Catch: Throwable -> 0x0150, TRY_LEAVE, TryCatch #4 {Throwable -> 0x0150, blocks: (B:57:0x014c, B:60:0x0152, B:62:0x0156), top: B:68:0x014c }] */
    public final boolean b(String str) throws Throwable {
        Cursor cursorRawQuery;
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                try {
                    a();
                    this.a.beginTransaction();
                    cursorRawQuery = this.a.rawQuery("select *  from __cc where __a=\"1\" group by __ts", null);
                    if (cursorRawQuery != null) {
                        while (cursorRawQuery.moveToNext()) {
                            try {
                                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__ts"));
                                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(e.d.a.d));
                                String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__a"));
                                String string4 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("id"));
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(String.format("timeStamp = %s, content = %s, active = %s, id = %s", string, string2, string3, string4));
                                sb2.append("\n");
                                d dVar = new d();
                                dVar.a = string;
                                dVar.b = string2;
                                dVar.c = string3;
                                if (!TextUtils.isEmpty(string) && !str.equals(string)) {
                                    arrayList.add(dVar);
                                }
                            } catch (SQLiteDatabaseCorruptException e) {
                                e = e;
                                cursor = cursorRawQuery;
                                e.printStackTrace();
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                        if (this.a != null) {
                                            this.a.endTransaction();
                                        }
                                    } catch (Throwable th) {
                                        b();
                                        return false;
                                    }
                                } else if (this.a != null) {
                                    this.a.endTransaction();
                                }
                                b();
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                if (cursorRawQuery != null) {
                                    try {
                                        cursorRawQuery.close();
                                        if (this.a != null) {
                                            this.a.endTransaction();
                                        }
                                    } catch (Throwable th3) {
                                        b();
                                        throw th;
                                    }
                                } else if (this.a != null) {
                                    this.a.endTransaction();
                                }
                                b();
                                throw th;
                            }
                        }
                    }
                    int size = arrayList.size();
                    String string5 = "";
                    for (int i = 0; i < size; i++) {
                        d dVar2 = (d) arrayList.get(i);
                        if (i != size - 1) {
                            sb = new StringBuilder();
                            sb.append(string5);
                            sb.append("__ts=\"");
                            sb.append(dVar2.a);
                            sb.append("\" or ");
                        } else {
                            sb = new StringBuilder();
                            sb.append(string5);
                            sb.append("__ts=\"");
                            sb.append(dVar2.a);
                            sb.append("\"");
                        }
                        string5 = sb.toString();
                        String str2 = "update  __cc set __a=\"0\" where " + string5;
                        ULog.i("jessie", "[DbManager] updateOtherCloudConfigInfo : ".concat(String.valueOf(str2)));
                        this.a.execSQL(str2);
                        this.a.setTransactionSuccessful();
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    if (this.a != null) {
                        this.a.endTransaction();
                    }
                } catch (Throwable th4) {
                }
            } catch (SQLiteDatabaseCorruptException e2) {
                e = e2;
            } catch (Throwable th5) {
            }
            b();
            return true;
        } catch (Throwable th6) {
            th = th6;
            cursorRawQuery = cursor;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0096 A[Catch: Throwable -> 0x0090, TRY_LEAVE, TryCatch #4 {Throwable -> 0x0090, blocks: (B:9:0x008c, B:12:0x0092, B:14:0x0096), top: B:61:0x008c }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00f1 A[Catch: Throwable -> 0x00ef, TryCatch #1 {Throwable -> 0x00ef, blocks: (B:51:0x00eb, B:54:0x00f1, B:56:0x00f5), top: B:59:0x00eb }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00f5 A[Catch: Throwable -> 0x00ef, TRY_LEAVE, TryCatch #1 {Throwable -> 0x00ef, blocks: (B:51:0x00eb, B:54:0x00f1, B:56:0x00f5), top: B:59:0x00eb }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final d c() throws Throwable {
        Cursor cursorRawQuery;
        SQLiteDatabaseCorruptException e;
        d dVar = new d();
        Cursor cursor = null;
        try {
            try {
                try {
                    a();
                    this.a.beginTransaction();
                    cursorRawQuery = this.a.rawQuery("select *  from __cc where __a=\"1\" group by __ts", null);
                    if (cursorRawQuery != null) {
                        try {
                            if (cursorRawQuery.moveToNext()) {
                                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__ts"));
                                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(e.d.a.d));
                                String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__a"));
                                ULog.i("jessie", "[DbManager] selectRecentActiveOne".concat(String.valueOf(String.format("timeStamp = %s, content = %s, active = %s, id = %s", string, string2, string3, cursorRawQuery.getString(cursorRawQuery.getColumnIndex("id"))) + "\n")));
                                d dVar2 = new d();
                                dVar2.a = string;
                                dVar2.b = string2;
                                dVar2.c = string3;
                                if (cursorRawQuery != null) {
                                    try {
                                        cursorRawQuery.close();
                                        if (this.a != null) {
                                            this.a.endTransaction();
                                        }
                                    } catch (Throwable th) {
                                    }
                                } else if (this.a != null) {
                                    this.a.endTransaction();
                                }
                                b();
                                return dVar2;
                            }
                        } catch (SQLiteDatabaseCorruptException e2) {
                            e = e2;
                            e.printStackTrace();
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                            if (this.a != null) {
                                this.a.endTransaction();
                            }
                        } catch (Throwable th2) {
                            cursor = cursorRawQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (this.a != null) {
                                this.a.endTransaction();
                            }
                        }
                    }
                    this.a.setTransactionSuccessful();
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    if (this.a != null) {
                        this.a.endTransaction();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (0 != 0) {
                        try {
                            cursor.close();
                            if (this.a != null) {
                                this.a.endTransaction();
                            }
                        } catch (Throwable th4) {
                            b();
                            throw th;
                        }
                    } else if (this.a != null) {
                        this.a.endTransaction();
                    }
                    b();
                    throw th;
                }
            } catch (SQLiteDatabaseCorruptException e3) {
                cursorRawQuery = null;
                e = e3;
            } catch (Throwable th5) {
            }
        } catch (Throwable th6) {
        }
        b();
        return dVar;
    }

    /* JADX WARN: Code duplicated, block: B:57:0x0100 A[Catch: Throwable -> 0x00fa, TRY_LEAVE, TryCatch #1 {Throwable -> 0x00fa, blocks: (B:52:0x00f6, B:55:0x00fc, B:57:0x0100), top: B:60:0x00f6 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v5 */
    public final boolean d() throws Throwable {
        ?? r3;
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        Object obj = null;
        Cursor cursor = null;
        Cursor cursor2 = null;
        obj = null;
        try {
            try {
                try {
                    a();
                    this.a.beginTransaction();
                    Cursor cursorRawQuery = this.a.rawQuery("select *  from __cc where __a=\"0\" order by __ts asc", null);
                    if (cursorRawQuery != null) {
                        while (cursorRawQuery.moveToNext()) {
                            try {
                                arrayList.add(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__ts")));
                            } catch (SQLiteDatabaseCorruptException e) {
                                e = e;
                                cursor = cursorRawQuery;
                                e.printStackTrace();
                                if (cursor != null) {
                                    cursor.close();
                                }
                                obj = cursor;
                                if (this.a != null) {
                                    this.a.endTransaction();
                                    obj = cursor;
                                }
                            } catch (Throwable th) {
                                cursor2 = cursorRawQuery;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                if (this.a != null) {
                                    this.a.endTransaction();
                                }
                                b();
                                return false;
                            }
                        }
                    }
                    int size = arrayList.size() - 5;
                    Object obj2 = "delete from __cc where ";
                    if (size > 0) {
                        String string = "";
                        for (int i = 0; i < size; i++) {
                            if (i != size - 1) {
                                sb = new StringBuilder();
                                sb.append(string);
                                sb.append("__ts=\"");
                                sb.append((String) arrayList.get(i));
                                sb.append("\" or ");
                            } else {
                                sb = new StringBuilder();
                                sb.append(string);
                                sb.append("__ts=\"");
                                sb.append((String) arrayList.get(i));
                                sb.append("\"");
                            }
                            string = sb.toString();
                        }
                        String str = "delete from __cc where " + string;
                        ULog.i("jessie", "[DbManager] deleteExtraCloudConfigInfo: ".concat(String.valueOf(str)));
                        SQLiteDatabase sQLiteDatabase = this.a;
                        sQLiteDatabase.execSQL(str);
                        this.a.setTransactionSuccessful();
                        obj2 = sQLiteDatabase;
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    obj = obj2;
                    if (this.a != null) {
                        this.a.endTransaction();
                        obj = obj2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r3 = obj;
                }
            } catch (SQLiteDatabaseCorruptException e2) {
                e = e2;
            } catch (Throwable th3) {
            }
        } catch (Throwable th4) {
        }
        b();
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0093 A[Catch: Throwable -> 0x008d, TRY_LEAVE, TryCatch #0 {Throwable -> 0x008d, blocks: (B:10:0x0089, B:13:0x008f, B:15:0x0093), top: B:60:0x0089 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x00a7 A[Catch: Throwable -> 0x00d6, TRY_ENTER, TryCatch #7 {Throwable -> 0x00d6, blocks: (B:33:0x00bc, B:34:0x00bf, B:36:0x00c3, B:42:0x00d2, B:45:0x00d8, B:47:0x00dc, B:24:0x00a7, B:25:0x00aa, B:27:0x00ae), top: B:65:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x00ae A[Catch: Throwable -> 0x00d6, TryCatch #7 {Throwable -> 0x00d6, blocks: (B:33:0x00bc, B:34:0x00bf, B:36:0x00c3, B:42:0x00d2, B:45:0x00d8, B:47:0x00dc, B:24:0x00a7, B:25:0x00aa, B:27:0x00ae), top: B:65:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00ee A[Catch: Throwable -> 0x00ec, TryCatch #1 {Throwable -> 0x00ec, blocks: (B:52:0x00e8, B:55:0x00ee, B:57:0x00f2), top: B:62:0x00e8 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00f2 A[Catch: Throwable -> 0x00ec, TRY_LEAVE, TryCatch #1 {Throwable -> 0x00ec, blocks: (B:52:0x00e8, B:55:0x00ee, B:57:0x00f2), top: B:62:0x00e8 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final d e() throws Throwable {
        Cursor cursorRawQuery;
        SQLiteDatabaseCorruptException e;
        d dVar = new d();
        Cursor cursor = null;
        try {
            try {
                try {
                    a();
                    this.a.beginTransaction();
                    cursorRawQuery = this.a.rawQuery("select *  from __cc order by __ts desc", null);
                    if (cursorRawQuery != null) {
                        while (cursorRawQuery.moveToNext()) {
                            try {
                                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__ts"));
                                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(e.d.a.d));
                                String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("__a"));
                                ULog.i("jessie", "[DbManager] getLastestConfigInfo".concat(String.valueOf(String.format("timeStamp = %s, content = %s, active = %s, id = %s", string, string2, string3, cursorRawQuery.getString(cursorRawQuery.getColumnIndex("id"))) + "\n")));
                                dVar.a = string;
                                dVar.b = string2;
                                dVar.c = string3;
                                if (string != null) {
                                    if (cursorRawQuery != null) {
                                        try {
                                            cursorRawQuery.close();
                                            if (this.a != null) {
                                                this.a.endTransaction();
                                            }
                                        } catch (Throwable th) {
                                        }
                                    } else if (this.a != null) {
                                        this.a.endTransaction();
                                    }
                                    b();
                                    return dVar;
                                }
                            } catch (SQLiteDatabaseCorruptException e2) {
                                e = e2;
                                e.printStackTrace();
                                if (cursorRawQuery != null) {
                                    cursorRawQuery.close();
                                }
                                if (this.a != null) {
                                    this.a.endTransaction();
                                }
                            } catch (Throwable th2) {
                                cursor = cursorRawQuery;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (this.a != null) {
                                    this.a.endTransaction();
                                }
                            }
                        }
                        this.a.setTransactionSuccessful();
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        if (this.a != null) {
                            this.a.endTransaction();
                        }
                    } else {
                        this.a.setTransactionSuccessful();
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        if (this.a != null) {
                            this.a.endTransaction();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (0 != 0) {
                        try {
                            cursor.close();
                            if (this.a != null) {
                                this.a.endTransaction();
                            }
                        } catch (Throwable th4) {
                            b();
                            throw th;
                        }
                    } else if (this.a != null) {
                        this.a.endTransaction();
                    }
                    b();
                    throw th;
                }
            } catch (SQLiteDatabaseCorruptException e3) {
                cursorRawQuery = null;
                e = e3;
            } catch (Throwable th5) {
                th = th5;
                if (0 != 0) {
                    cursor.close();
                    if (this.a != null) {
                        this.a.endTransaction();
                    }
                } else if (this.a != null) {
                    this.a.endTransaction();
                }
                b();
                throw th;
            }
        } catch (Throwable th6) {
        }
        b();
        return dVar;
    }
}
