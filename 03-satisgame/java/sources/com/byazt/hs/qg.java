package com.byazt.hs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.byazt.tk.k;
import com.byazt.tzz.q;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 983, 26})
public class qg extends s {
    public final String qg;

    public qg(Context context, int i) {
        super(context, "ttopensdk.db", i);
        this.qg = "OldSqliteDatabase";
    }

    @Override // com.byazt.hs.s
    public void n(SQLiteDatabase sQLiteDatabase, Context context) {
        sQLiteDatabase.execSQL(com.byazt.vga.qg.s("adevent"));
        sQLiteDatabase.execSQL(com.byazt.vga.qg.s("loghighpriority"));
        sQLiteDatabase.execSQL(com.byazt.vga.qg.s("logstats"));
        sQLiteDatabase.execSQL(com.byazt.vga.qg.s("logstatsbatch"));
        sQLiteDatabase.execSQL(q.qg());
        sQLiteDatabase.execSQL(com.byazt.mzw.qg.s());
        sQLiteDatabase.execSQL(com.byazt.lq.s.s());
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_base_info (_id INTEGER PRIMARY KEY,value TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_global_info (_id INTEGER PRIMARY KEY,value TEXT)");
        sQLiteDatabase.execSQL(com.byazt.ysr.s.q());
    }

    @Override // com.byazt.hs.s
    public void n(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            switch (i) {
                case 1:
                    qg(sQLiteDatabase, i, i2);
                    break;
                case 2:
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                    qg(sQLiteDatabase, i, i2);
                    break;
                case 3:
                    sQLiteDatabase.execSQL(com.byazt.vga.qg.s("logstats"));
                    qg(sQLiteDatabase, i, i2);
                    break;
                case 4:
                    sQLiteDatabase.execSQL(com.byazt.mzw.qg.s());
                    qg(sQLiteDatabase, i, i2);
                    break;
                case 5:
                    sQLiteDatabase.execSQL(com.byazt.vga.qg.s("logstatsbatch"));
                    qg(sQLiteDatabase, i, i2);
                    break;
                case 6:
                case 8:
                case 9:
                    qg(sQLiteDatabase, i, i2);
                    break;
                case 7:
                    sQLiteDatabase.execSQL(com.byazt.lq.s.s());
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_base_info (_id INTEGER PRIMARY KEY,value TEXT)");
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_global_info (_id INTEGER PRIMARY KEY,value TEXT)");
                    qg(sQLiteDatabase, i, i2);
                    break;
                case 10:
                case 11:
                    try {
                        s(sQLiteDatabase, i, i2);
                    } catch (Exception e) {
                        k.qg("OldSqliteDatabase", "database onUpgrade error version: " + i + ", msg: " + e.getMessage());
                    }
                    break;
            }
            i++;
        }
    }

    private void qg(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(com.byazt.vga.qg.qg("adevent"));
        sQLiteDatabase.execSQL(com.byazt.vga.qg.qg("loghighpriority"));
        sQLiteDatabase.execSQL(com.byazt.vga.qg.qg("logstats"));
        sQLiteDatabase.execSQL(com.byazt.vga.qg.qg("logstatsbatch"));
        s(sQLiteDatabase, i, i2);
    }

    private void s(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(q.s());
        sQLiteDatabase.execSQL(q.q());
    }
}
