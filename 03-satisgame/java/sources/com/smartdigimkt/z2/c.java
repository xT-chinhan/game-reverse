package com.smartdigimkt.z2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends SQLiteOpenHelper {
    public final /* synthetic */ d a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, Context context) {
        super(context, "sdm_adx_rp.db", (SQLiteDatabase.CursorFactory) null, 2);
        this.a = dVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.a.getClass();
        try {
            d.a(sQLiteDatabase, 1, 2);
        } catch (Throwable th) {
            th.printStackTrace();
            th.getMessage();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.a.getClass();
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'sdkconfig'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'request_info'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'offer_action_record'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'offer_data_cache'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'dsp_offer_show_record'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'dsp_offer_install_record'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'inspect_info'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'video_res_cache_info'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'notice_url_fail_info'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'download_task'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'adx_offer_tracking'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            d.a(sQLiteDatabase, 1, 2);
        } catch (Throwable th) {
            th.printStackTrace();
            th.getMessage();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.a.getClass();
        d.a(sQLiteDatabase, i, i2);
    }
}
