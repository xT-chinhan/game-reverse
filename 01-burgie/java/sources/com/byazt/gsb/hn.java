package com.byazt.gsb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_FORMAT, 20})
public class hn {
    public static final Object hn = new Object();
    public Context hw;
    public pr pr;

    public hn(Context context) {
        this.hw = context;
        try {
            if (this.pr == null) {
                this.pr = new pr();
            }
        } catch (Throwable th) {
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_FORMAT, 116})
    public class pr {
        public SQLiteDatabase hw = null;

        public pr() {
        }

        private void hw() {
            try {
                synchronized (hn.hn) {
                    SQLiteDatabase sQLiteDatabase = this.hw;
                    if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                        SQLiteDatabase writableDatabase = new hw(hn.this.hw, "tt_mediation_open_sdk.db", 4).getWritableDatabase();
                        this.hw = writableDatabase;
                        writableDatabase.setLockingEnabled(false);
                    }
                }
            } catch (Throwable th) {
                hn();
            }
        }

        public SQLiteDatabase pr() {
            hw();
            return this.hw;
        }

        private boolean hn() {
            SQLiteDatabase sQLiteDatabase = this.hw;
            return sQLiteDatabase != null && sQLiteDatabase.isOpen() && sQLiteDatabase.inTransaction();
        }
    }

    public pr pr() {
        return this.pr;
    }
}
