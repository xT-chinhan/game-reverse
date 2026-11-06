package com.byazt.kh;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 913, 26})
public class qg extends SQLiteOpenHelper {
    private static String n() {
        return "CREATE TABLE IF NOT EXISTS adevent (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0, encrypt INTEGER default 0)";
    }

    private static String q() {
        return "ALTER TABLE adevent_applog ADD COLUMN encrypt INTEGER default 0";
    }

    private static String qg() {
        return "CREATE TABLE IF NOT EXISTS adevent_applog (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0, encrypt INTEGER default 0)";
    }

    private static String s() {
        return "ALTER TABLE adevent ADD COLUMN encrypt INTEGER default 0";
    }

    public qg(Context context, String str, int i) {
        super(new com.byazt.qyu.n(context), str, (SQLiteDatabase.CursorFactory) null, i);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            n(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    private void n(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(n());
        } catch (Throwable unused) {
        }
        try {
            sQLiteDatabase.execSQL(qg());
        } catch (Throwable unused2) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1 || i == 2) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'show_freqctl';");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'show_pacing';");
            } catch (Throwable unused) {
                return;
            }
        } else if (i != 3) {
            return;
        }
        sQLiteDatabase.execSQL(qg());
        n(sQLiteDatabase, i, i2);
    }

    private void n(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL(s());
        } catch (Throwable unused) {
        }
        try {
            sQLiteDatabase.execSQL(q());
        } catch (Throwable unused2) {
        }
    }
}
