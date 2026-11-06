package com.byazt.cf;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 440, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static void insert(ContentValues contentValues) {
        if (contentValues == null) {
            return;
        }
        com.byazt.ad.pr.insert(a.getContext(), "union_tmax_record", contentValues);
    }

    public static void pr(ContentValues contentValues) {
        if (contentValues == null) {
            return;
        }
        String asString = contentValues.getAsString("load_id");
        if (!TextUtils.isEmpty(asString) && com.byazt.ad.pr.update(a.getContext(), "union_tmax_record", contentValues, "load_id=?", new String[]{asString}) <= 0) {
            com.byazt.ad.pr.insert(a.getContext(), "union_tmax_record", contentValues);
        }
    }

    public static Cursor pr(int i, String str, long j, String str2) {
        if (TextUtils.isEmpty(str) || j <= 0) {
            return null;
        }
        return com.byazt.ad.pr.query(a.getContext(), "union_tmax_record", null, "ad_slot_type=? AND ad_slot_id=? AND record_time>=?", new String[]{String.valueOf(i), str, String.valueOf(j)}, null, null, str2);
    }

    public static Cursor pr(int i, long j, String str) {
        if (j <= 0) {
            return null;
        }
        return com.byazt.ad.pr.query(a.getContext(), "union_tmax_record", null, "ad_slot_type=? AND record_time>=?", new String[]{String.valueOf(i), String.valueOf(j)}, null, null, str);
    }

    public static int pr(long j) {
        return com.byazt.ad.pr.delete(a.getContext(), "union_tmax_record", "record_time<?", new String[]{String.valueOf(j)});
    }
}
