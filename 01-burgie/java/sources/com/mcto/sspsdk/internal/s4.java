package com.mcto.sspsdk.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes2.dex */
public final class s4 extends SQLiteOpenHelper {
    public s4(Context context) {
        super(context, "ssp_sdk_x6t1f.db", (SQLiteDatabase.CursorFactory) null, 4);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase.isOpen()) {
            try {
                sQLiteDatabase.execSQL("create table if not exists A( _id integer not null primary key autoincrement,c TEXT,h TEXT,g TEXT,a TEXT,b TEXT,d TEXT,e TEXT,f INTEGER,j INTEGER,c_time INTEGER,k INTEGER,i INTEGER, l TEXT );");
            } catch (SQLiteFullException e) {
                r9.a("ssp_db", "createDownloadApkFileTable: ", e);
            } catch (Exception e2) {
                r9.a("ssp_db", "createDownloadApkFileTable: ", e2);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            r9.a("DBHelper", "onDowngrade: " + i, null);
            try {
                try {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS A");
                } catch (SQLiteFullException e) {
                    r9.a("ssp_db", "dropDownloadApkFileTable: ", e);
                }
            } catch (Exception e2) {
                r9.a("ssp_db", "dropDownloadApkFileTable: ", e2);
            }
            try {
                sQLiteDatabase.execSQL("create table if not exists A( _id integer not null primary key autoincrement,c TEXT,h TEXT,g TEXT,a TEXT,b TEXT,d TEXT,e TEXT,f INTEGER,j INTEGER,c_time INTEGER,k INTEGER,i INTEGER, l TEXT );");
            } catch (SQLiteFullException e3) {
                r9.a("ssp_db", "createDownloadApkFileTable: ", e3);
            } catch (Exception e4) {
                r9.a("ssp_db", "createDownloadApkFileTable: ", e4);
            }
        } catch (Exception e5) {
            r9.a("DBHelper", "onDowngrade: ", e5);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i >= i2) {
            return;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return;
                }
            }
            sQLiteDatabase.execSQL("alter table A add column l TEXT ");
        }
        try {
            sQLiteDatabase.execSQL("alter table A add column k integer ");
        } catch (Exception e) {
            return;
        }
        sQLiteDatabase.execSQL("alter table A add column i integer ");
        sQLiteDatabase.execSQL("alter table A add column l TEXT ");
    }
}
