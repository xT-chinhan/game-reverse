package com.byazt.xev;

import android.content.Context;
import android.content.SharedPreferences;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 75, MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD})
public final class a {
    public final SharedPreferences pr;

    public a(Context context) {
        this.pr = com.byazt.mg.hw.hw(context, "device_register_oaid_refine", 0);
    }

    public void pr(qa qaVar) {
        if (qaVar == null) {
            return;
        }
        this.pr.edit().putString("oaid", qaVar.hw().toString()).apply();
    }

    public qa pr() {
        return qa.pr(this.pr.getString("oaid", ""));
    }
}
