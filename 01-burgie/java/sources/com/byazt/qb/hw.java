package com.byazt.qb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.byazt.ca.ho;
import com.byazt.yd.x;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2279, 13})
public class hw extends hn {
    public final String hw;

    public hw(Context context, int i) {
        super(context, "ttopensdk.db", i);
        this.hw = "OldSqliteDatabase";
    }

    @Override // com.byazt.qb.hn
    public void pr(SQLiteDatabase sQLiteDatabase, Context context) {
        sQLiteDatabase.execSQL(com.byazt.fhc.hw.hn("adevent"));
        sQLiteDatabase.execSQL(com.byazt.fhc.hw.hn("loghighpriority"));
        sQLiteDatabase.execSQL(com.byazt.fhc.hw.hn("logstats"));
        sQLiteDatabase.execSQL(com.byazt.fhc.hw.hn("logstatsbatch"));
        sQLiteDatabase.execSQL(x.hw());
        sQLiteDatabase.execSQL(com.byazt.ce.hw.hn());
        sQLiteDatabase.execSQL(com.byazt.hs.hn.hn());
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_base_info (_id INTEGER PRIMARY KEY,value TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_global_info (_id INTEGER PRIMARY KEY,value TEXT)");
        sQLiteDatabase.execSQL(com.byazt.ir.hn.x());
    }

    @Override // com.byazt.qb.hn
    public void pr(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            switch (i) {
                case 1:
                    hw(sQLiteDatabase, i, i2);
                    break;
                case 2:
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                    hw(sQLiteDatabase, i, i2);
                    break;
                case 3:
                    sQLiteDatabase.execSQL(com.byazt.fhc.hw.hn("logstats"));
                    hw(sQLiteDatabase, i, i2);
                    break;
                case 4:
                    sQLiteDatabase.execSQL(com.byazt.ce.hw.hn());
                    hw(sQLiteDatabase, i, i2);
                    break;
                case 5:
                    sQLiteDatabase.execSQL(com.byazt.fhc.hw.hn("logstatsbatch"));
                    hw(sQLiteDatabase, i, i2);
                    break;
                case 6:
                case 8:
                case 9:
                    hw(sQLiteDatabase, i, i2);
                    break;
                case 7:
                    sQLiteDatabase.execSQL(com.byazt.hs.hn.hn());
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_base_info (_id INTEGER PRIMARY KEY,value TEXT)");
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_global_info (_id INTEGER PRIMARY KEY,value TEXT)");
                    hw(sQLiteDatabase, i, i2);
                    break;
                case 10:
                case 11:
                    try {
                        hn(sQLiteDatabase, i, i2);
                    } catch (Exception e) {
                        ho.hw("OldSqliteDatabase", "database onUpgrade error version: " + i + ", msg: " + e.getMessage());
                    }
                    break;
            }
            i++;
        }
    }

    private void hw(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(com.byazt.fhc.hw.hw("adevent"));
        sQLiteDatabase.execSQL(com.byazt.fhc.hw.hw("loghighpriority"));
        sQLiteDatabase.execSQL(com.byazt.fhc.hw.hw("logstats"));
        sQLiteDatabase.execSQL(com.byazt.fhc.hw.hw("logstatsbatch"));
        hn(sQLiteDatabase, i, i2);
    }

    private void hn(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(x.hn());
        sQLiteDatabase.execSQL(x.x());
    }
}
