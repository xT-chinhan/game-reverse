package com.tapsdk.tapad.internal.download.core.breakpoint;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.SparseArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class e extends SQLiteOpenHelper {
    private static final String a = "okdownload-breakpoint.db";
    private static final int b = 3;
    private static final String c = "okdownloadResponseFilename";
    private static final String d = "breakpoint";
    private static final String e = "block";
    static final String f = "taskFileDirty";

    private interface a {
        public static final String a = "CREATE TABLE IF NOT EXISTS breakpoint( id INTEGER PRIMARY KEY, url VARCHAR NOT NULL, etag VARCHAR, parent_path VARCHAR NOT NULL, filename VARCHAR, task_only_parent_path TINYINT(1) DEFAULT 0, chunked TINYINT(1) DEFAULT 0)";
        public static final String b = "CREATE TABLE IF NOT EXISTS block( id INTEGER PRIMARY KEY AUTOINCREMENT, breakpoint_id INTEGER, block_index INTEGER, start_offset INTEGER, content_length INTEGER, current_offset INTEGER)";
        public static final String c = "CREATE TABLE IF NOT EXISTS okdownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)";
        public static final String d = "CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)";
    }

    private interface b {
        public static final String a = "CREATE TABLE IF NOT EXISTS okdownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)";
        public static final String b = "CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)";
    }

    private interface c {
        public static final String a = "SELECT * FROM taskFileDirty";
        public static final String b = "SELECT * FROM breakpoint";
        public static final String c = "SELECT * FROM block";
        public static final String d = "SELECT * FROM okdownloadResponseFilename";
        public static final String e = "SELECT filename FROM okdownloadResponseFilename WHERE url = ?";
        public static final String f = "SELECT id FROM breakpoint WHERE id = ? LIMIT 1";
    }

    public e(Context context) {
        super(context, a, (SQLiteDatabase.CursorFactory) null, 3);
    }

    private static ContentValues a(int i, int i2, com.tapsdk.tapad.internal.download.core.breakpoint.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("breakpoint_id", Integer.valueOf(i));
        contentValues.put("block_index", Integer.valueOf(i2));
        contentValues.put("start_offset", Long.valueOf(aVar.f()));
        contentValues.put("content_length", Long.valueOf(aVar.b()));
        contentValues.put("current_offset", Long.valueOf(aVar.c()));
        return contentValues;
    }

    private static ContentValues b(com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(cVar.a));
        contentValues.put("url", cVar.j());
        contentValues.put("etag", cVar.c());
        contentValues.put("parent_path", cVar.d.getAbsolutePath());
        contentValues.put("filename", cVar.e());
        contentValues.put("task_only_parent_path", Integer.valueOf(cVar.m() ? 1 : 0));
        contentValues.put("chunked", Integer.valueOf(cVar.k() ? 1 : 0));
        return contentValues;
    }

    public List<Integer> a() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = getWritableDatabase().rawQuery("SELECT * FROM taskFileDirty", null);
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(Integer.valueOf(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("id"))));
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public void a(int i) {
        getWritableDatabase().delete(f, "id = ?", new String[]{String.valueOf(i)});
    }

    public void a(com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) throws IOException {
        int iB = cVar.b();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        for (int i = 0; i < iB; i++) {
            com.tapsdk.tapad.internal.download.core.breakpoint.a aVarB = cVar.b(i);
            if (writableDatabase.insert(e, null, a(cVar.a, i, aVarB)) == -1) {
                throw new com.tapsdk.tapad.internal.download.m.f.h("insert block " + aVarB + " failed!");
            }
        }
        if (writableDatabase.insert(d, null, b(cVar)) == -1) {
            throw new com.tapsdk.tapad.internal.download.m.f.h("insert info " + cVar + " failed!");
        }
    }

    public void a(com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("current_offset", Long.valueOf(j));
        getWritableDatabase().update(e, contentValues, "breakpoint_id = ? AND block_index = ?", new String[]{Integer.toString(cVar.a), Integer.toString(i)});
    }

    public void a(String str, String str2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("url", str);
        contentValues.put("filename", str2);
        synchronized (str.intern()) {
            Cursor cursor = null;
            try {
                try {
                    Cursor cursorRawQuery = writableDatabase.rawQuery("SELECT filename FROM okdownloadResponseFilename WHERE url = ?", new String[]{str});
                    try {
                        if (!cursorRawQuery.moveToFirst()) {
                            writableDatabase.insert(c, null, contentValues);
                        } else if (!str2.equals(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("filename")))) {
                            writableDatabase.replace(c, null, contentValues);
                        }
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorRawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public HashMap<String, String> b() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        HashMap<String, String> map = new HashMap<>();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = writableDatabase.rawQuery("SELECT * FROM okdownloadResponseFilename", null);
            while (cursorRawQuery.moveToNext()) {
                map.put(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("url")), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("filename")));
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return map;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public void b(int i) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("id", Integer.valueOf(i));
        writableDatabase.insert(f, null, contentValues);
    }

    public SparseArray<com.tapsdk.tapad.internal.download.core.breakpoint.c> c() throws Throwable {
        Cursor cursor;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            Cursor cursorRawQuery2 = writableDatabase.rawQuery("SELECT * FROM breakpoint", null);
            while (cursorRawQuery2.moveToNext()) {
                try {
                    arrayList.add(new d(cursorRawQuery2));
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorRawQuery;
                    cursorRawQuery = cursorRawQuery2;
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            cursorRawQuery = writableDatabase.rawQuery("SELECT * FROM block", null);
            while (cursorRawQuery.moveToNext()) {
                arrayList2.add(new com.tapsdk.tapad.internal.download.core.breakpoint.b(cursorRawQuery));
            }
            if (cursorRawQuery2 != null) {
                cursorRawQuery2.close();
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            SparseArray<com.tapsdk.tapad.internal.download.core.breakpoint.c> sparseArray = new SparseArray<>();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                com.tapsdk.tapad.internal.download.core.breakpoint.c cVarH = ((d) it.next()).h();
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    com.tapsdk.tapad.internal.download.core.breakpoint.b bVar = (com.tapsdk.tapad.internal.download.core.breakpoint.b) it2.next();
                    if (bVar.a() == cVarH.a) {
                        cVarH.a(bVar.e());
                        it2.remove();
                    }
                }
                sparseArray.put(cVarH.a, cVarH);
            }
            return sparseArray;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public void c(int i) {
        getWritableDatabase().delete(e, "breakpoint_id = ?", new String[]{String.valueOf(i)});
    }

    public void c(com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) throws IOException {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = getWritableDatabase().rawQuery("SELECT id FROM breakpoint WHERE id = ? LIMIT 1", new String[]{Integer.toString(cVar.a)});
            if (cursorRawQuery.moveToNext()) {
                d(cVar.a);
                a(cVar);
                writableDatabase.setTransactionSuccessful();
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            writableDatabase.endTransaction();
        }
    }

    public void d(int i) {
        getWritableDatabase().delete(d, "id = ?", new String[]{String.valueOf(i)});
        c(i);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS breakpoint( id INTEGER PRIMARY KEY, url VARCHAR NOT NULL, etag VARCHAR, parent_path VARCHAR NOT NULL, filename VARCHAR, task_only_parent_path TINYINT(1) DEFAULT 0, chunked TINYINT(1) DEFAULT 0)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS block( id INTEGER PRIMARY KEY AUTOINCREMENT, breakpoint_id INTEGER, block_index INTEGER, start_offset INTEGER, content_length INTEGER, current_offset INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS okdownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        setWriteAheadLoggingEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1 && i2 == 2) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS okdownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)");
        }
        if (i <= 2) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)");
        }
    }
}
