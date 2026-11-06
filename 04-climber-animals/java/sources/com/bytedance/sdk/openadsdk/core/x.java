package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class x {
    private static final Object ah = new Object();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ah f3756ms;
    private Context xr;

    x(Context context) {
        try {
            this.xr = context == null ? re.getContext() : context.getApplicationContext();
            if (this.f3756ms == null) {
                this.f3756ms = new ah();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        Context context = this.xr;
        return context == null ? re.getContext() : context;
    }

    public class ah {
        private SQLiteDatabase xr = null;

        public ah() {
        }

        public void ms() {
            try {
                SQLiteDatabase sQLiteDatabase = this.xr;
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    return;
                }
                synchronized (x.ah) {
                    SQLiteDatabase sQLiteDatabase2 = this.xr;
                    if (sQLiteDatabase2 == null || !sQLiteDatabase2.isOpen()) {
                        x xVar = x.this;
                        this.xr = xVar.new ms(xVar.getContext()).getWritableDatabase();
                    }
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.sl.ms(th);
                if (c()) {
                    throw th;
                }
            }
        }

        public SQLiteDatabase xr() {
            return this.xr;
        }

        public void ms(String str) throws SQLException {
            try {
                ms();
                this.xr.execSQL(str);
            } catch (Throwable th) {
                if (c()) {
                    throw th;
                }
            }
        }

        public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            try {
                ms();
                return this.xr.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                xr xrVar = new xr();
                if (c()) {
                    throw th;
                }
                return xrVar;
            }
        }

        public int update(String str, ContentValues contentValues, String str2, String[] strArr) throws Exception {
            try {
                ms();
                return this.xr.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
                if (c()) {
                    throw e;
                }
                return 0;
            }
        }

        public long insert(String str, String str2, ContentValues contentValues) throws Exception {
            try {
                ms();
                return this.xr.insert(str, str2, contentValues);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
                if (c()) {
                    throw e;
                }
                return -1L;
            }
        }

        public int delete(String str, String str2, String[] strArr) throws Exception {
            try {
                ms();
                return this.xr.delete(str, str2, strArr);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
                if (c()) {
                    throw e;
                }
                return 0;
            }
        }

        public void ah() {
            ms();
            SQLiteDatabase sQLiteDatabase = this.xr;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.beginTransaction();
        }

        public void d() {
            ms();
            SQLiteDatabase sQLiteDatabase = this.xr;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.setTransactionSuccessful();
        }

        public void ka() {
            ms();
            SQLiteDatabase sQLiteDatabase = this.xr;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.endTransaction();
        }

        private boolean c() {
            SQLiteDatabase sQLiteDatabase = this.xr;
            return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
        }
    }

    private class ms extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final Context f3758ms;

        public ms(Context context) {
            super(new com.bytedance.sdk.openadsdk.api.plugin.ms(context), "ttopensdk.db", (SQLiteDatabase.CursorFactory) null, 12);
            this.f3758ms = context;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                ms(sQLiteDatabase, this.f3758ms);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.sl.d("DBHelper", th.getMessage());
            }
        }

        private void ms(SQLiteDatabase sQLiteDatabase, Context context) {
            com.bytedance.sdk.openadsdk.core.t.xr.ah.get();
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.x.xr.ms.ms.xr.c.d("adevent"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.x.xr.ms.ms.xr.d.xr("loghighpriority"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.x.xr.ms.ms.xr.ab.d("logstats"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.x.xr.ms.ms.xr.ms.xr("logstatsbatch"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.x.xr.c.c.xr());
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.ms.xr.xr.ah());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tools.xr.ah());
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_base_info (_id INTEGER PRIMARY KEY,value TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_global_info (_id INTEGER PRIMARY KEY,value TEXT)");
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.nativeexpress.ms.ah.ah());
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS meta_cache (id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT,uuid TEXT,create_time TEXT,meta_data TEXT,save_version TEXT,expire_time TEXT,slot_type TEXT,is_using INTEGER,priority TEXT)");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i > i2) {
                ms(sQLiteDatabase);
                ms(sQLiteDatabase, x.this.xr);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i > i2) {
                try {
                    ms(sQLiteDatabase);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.sl.d("DBHelper", th.getMessage());
                    return;
                }
            }
            ms(sQLiteDatabase, x.this.xr);
            switch (i) {
                case 1:
                    ms(sQLiteDatabase, i, i2);
                    break;
                case 2:
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                    ms(sQLiteDatabase, i, i2);
                    break;
                case 3:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.component.x.xr.ms.ms.xr.ab.d("logstats"));
                    ms(sQLiteDatabase, i, i2);
                    break;
                case 4:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.ms.xr.xr.ah());
                    ms(sQLiteDatabase, i, i2);
                    break;
                case 5:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.component.x.xr.ms.ms.xr.ms.xr("logstatsbatch"));
                    ms(sQLiteDatabase, i, i2);
                    break;
                case 6:
                case 8:
                case 9:
                    ms(sQLiteDatabase, i, i2);
                    break;
                case 7:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tools.xr.ah());
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_base_info (_id INTEGER PRIMARY KEY,value TEXT)");
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_global_info (_id INTEGER PRIMARY KEY,value TEXT)");
                    ms(sQLiteDatabase, i, i2);
                    break;
                case 10:
                case 11:
                    xr(sQLiteDatabase, i, i2);
                    break;
                default:
                    break;
            }
        }

        private void ms(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.x.xr.ms.ms.xr.c.ka("adevent"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.x.xr.ms.ms.xr.d.ah("loghighpriority"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.x.xr.ms.ms.xr.ab.ka("logstats"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.x.xr.ms.ms.xr.ms.ah("logstatsbatch"));
            xr(sQLiteDatabase, i, i2);
        }

        private void xr(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.x.xr.c.c.ah());
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.x.xr.c.c.d());
        }

        private void ms(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> arrayListXr = xr(sQLiteDatabase);
            if (arrayListXr == null || arrayListXr.size() <= 0) {
                return;
            }
            Iterator<String> it = arrayListXr.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
            }
        }

        private ArrayList<String> xr(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
                if (cursorRawQuery != null) {
                    while (cursorRawQuery.moveToNext()) {
                        String string = cursorRawQuery.getString(0);
                        if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                            arrayList.add(string);
                        }
                    }
                    cursorRawQuery.close();
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }
    }

    public ah ms() {
        return this.f3756ms;
    }

    private class xr extends AbstractCursor {
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

        private xr() {
        }
    }
}
