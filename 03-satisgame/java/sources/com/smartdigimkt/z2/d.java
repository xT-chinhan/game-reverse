package com.smartdigimkt.z2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static d b;
    public final c a;

    public d(Context context) {
        this.a = new c(this, context);
    }

    public final synchronized SQLiteDatabase a() {
        return this.a.getReadableDatabase();
    }

    public final synchronized SQLiteDatabase b() {
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = this.a.getWritableDatabase();
        } catch (Exception unused) {
            writableDatabase = null;
        }
        return writableDatabase;
    }

    public static d a(Context context) {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d(context.getApplicationContext());
                }
            }
        }
        return b;
    }

    public static void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            if (i == 1) {
                sQLiteDatabase.execSQL(com.anythink.core.common.f.e.a.f);
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS request_info(id TEXT, req_type INTEGER, req_url TEXT, req_head TEXT, req_content TEXT, time INTEGER, extra TEXT )");
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS offer_action_record(adsource_id TEXT ,type INTEGER ,unit_id TEXT ,click_count INTEGER ,show_count INTEGER ,expire_time INTEGER )");
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS offer_data_cache(placement_id TEXT ,bid_id TEXT ,adsource_id TEXT ,network_firm_id INTEGER ,bid_result TEXT ,offer_data TEXT ,out_date_timestamp INTEGER)");
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS dsp_offer_show_record(dsp_id TEXT ,dsp_offer_id TEXT ,show_limit INTEGER ,show_count INTEGER ,create_time INTEGER ,last_update_time INTEGER)");
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS dsp_offer_install_record(dsp_id TEXT ,dsp_offer_id TEXT ,package_name TEXT ,last_update_time INTEGER)");
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS inspect_info(inspect_id TEXT, inspect_result INTEGER, inspect_name TEXT, update_time INTEGER )");
                sQLiteDatabase.execSQL(com.anythink.core.common.f.k.a.h);
                sQLiteDatabase.execSQL(com.anythink.core.common.f.h.b.i);
                sQLiteDatabase.execSQL(f.d);
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS adx_offer_tracking(placement_id TEXT ,dsp_id TEXT ,offer_id TEXT ,tk_type INTEGER ,extra_info TEXT ,create_time INTEGER)");
            }
            i++;
        }
    }
}
