package com.byazt.yb;

import android.content.Context;
import android.content.SharedPreferences;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
public final class a {
    public final SharedPreferences n;

    public a(Context context) {
        this.n = com.byazt.qyu.qg.qg(context, "device_register_oaid_refine", 0);
    }

    public void n(um umVar) {
        if (umVar == null) {
            return;
        }
        this.n.edit().putString("oaid", umVar.qg().toString()).apply();
    }

    public um n() {
        return um.n(this.n.getString("oaid", ""));
    }
}
