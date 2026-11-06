package com.byazt.hs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 983, 19})
public class n extends s {
    @Override // com.byazt.hs.s, android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public n(Context context) {
        super(context, "ttopensdk2.db", 5);
    }

    @Override // com.byazt.hs.s, android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            n(sQLiteDatabase, this.n);
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.hs.s, android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            n(sQLiteDatabase, this.n);
        } catch (Exception unused) {
        }
        while (i < i2) {
            if (i == 4) {
                qg(sQLiteDatabase);
            }
            i++;
        }
    }

    private void qg(SQLiteDatabase sQLiteDatabase) {
        n(sQLiteDatabase, "ALTER TABLE union_tmax_record ADD COLUMN ad_price INTEGER DEFAULT 0");
        n(sQLiteDatabase, "ALTER TABLE union_tmax_record ADD COLUMN priority INTEGER DEFAULT 0");
        n(sQLiteDatabase, "ALTER TABLE union_tmax_record ADD COLUMN pre_time INTEGER DEFAULT 0");
        n(sQLiteDatabase, "ALTER TABLE union_tmax_record ADD COLUMN after_time INTEGER DEFAULT 0");
    }

    private void n(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.hs.s
    public void n(SQLiteDatabase sQLiteDatabase, Context context) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sdk_launch (id INTEGER PRIMARY KEY AUTOINCREMENT,dev1 INTEGER,dev2 INTEGER,dev3 INTEGER,dev4 INTEGER,dev5 INTEGER,dev6 INTEGER,dev7 INTEGER,dev8 INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS union_meta_cache (id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT,uuid TEXT,create_time TEXT,meta_data TEXT,save_version TEXT,expire_time TEXT,slot_type TEXT,is_using INTEGER,priority TEXT,ad_index INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS meta_req_record_v1 (id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT,appid TEXT,slot_type TEXT,create_time TEXT,status TEXT,cache_type TEXT,event_type TEXT,request_count INTEGER,response_count INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS dpl_status_record (id INTEGER PRIMARY KEY AUTOINCREMENT,create_time TEXT,status TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS union_tmax_record (id INTEGER PRIMARY KEY AUTOINCREMENT,load_id TEXT UNIQUE,ad_slot_type INTEGER,ad_slot_id TEXT,loaded_duration INTEGER DEFAULT 0,cached_duration INTEGER DEFAULT 0,shown_duration INTEGER DEFAULT 0,is_shown INTEGER DEFAULT 0,ad_price INTEGER DEFAULT 0,priority INTEGER DEFAULT 0,record_time INTEGER DEFAULT 0,pre_time INTEGER DEFAULT 0,after_time INTEGER DEFAULT 0)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hty_show (day INTEGER,load_component_id TEXT,s_page_name TEXT,s_t_name TEXT,show_id TEXT,show_count INTEGER,update_time INTEGER,PRIMARY KEY(day,load_component_id,s_page_name,s_t_name))");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS tt_feature_bucket (id TEXT PRIMARY KEY,rule_id TEXT,rule_version INTEGER,group_key TEXT,bucket_key INTEGER,bucket_size INTEGER,as_name TEXT,value REAL,function TEXT,cnt INTEGER,result_value TEXT,timestamp INTEGER)");
    }
}
