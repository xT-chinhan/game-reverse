package com.byazt.sds;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1663, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public final class zo {
    public SharedPreferences pr;

    public zo(Context context) {
        this.pr = com.byazt.mg.hw.hw(context, "npth", 0);
    }

    public void pr(String str) {
        this.pr.edit().putString("device_id", str).apply();
    }

    public String pr() {
        String strC = com.byazt.vlj.zo.pr().c();
        if (TextUtils.isEmpty(strC) || "0".equals(strC)) {
            return this.pr.getString("device_id", "0");
        }
        return strC;
    }
}
