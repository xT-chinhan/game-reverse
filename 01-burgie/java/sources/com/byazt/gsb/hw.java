package com.byazt.gsb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_FORMAT, 13})
public class hw extends SQLiteOpenHelper {
    public hw(Context context, String str, int i) {
        super(new com.byazt.mg.pr(context), str, (SQLiteDatabase.CursorFactory) null, i);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            pr(sQLiteDatabase);
        } catch (Throwable th) {
        }
    }

    private void pr(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(pr());
        } catch (Throwable th) {
        }
        try {
            sQLiteDatabase.execSQL(hw());
        } catch (Throwable th2) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        switch (i) {
            case 1:
            case 2:
                try {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'show_freqctl';");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'show_pacing';");
                    break;
                } catch (Throwable th) {
                }
            case 3:
                sQLiteDatabase.execSQL(hw());
                pr(sQLiteDatabase, i, i2);
                break;
        }
    }

    private void pr(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL(hn());
        } catch (Throwable th) {
        }
        try {
            sQLiteDatabase.execSQL(x());
        } catch (Throwable th2) {
        }
    }

    private static String pr() {
        return "CREATE TABLE IF NOT EXISTS adevent (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0, encrypt INTEGER default 0)";
    }

    private static String hw() {
        return "CREATE TABLE IF NOT EXISTS adevent_applog (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0, encrypt INTEGER default 0)";
    }

    private static String hn() {
        return "ALTER TABLE adevent ADD COLUMN encrypt INTEGER default 0";
    }

    private static String x() {
        return "ALTER TABLE adevent_applog ADD COLUMN encrypt INTEGER default 0";
    }
}
