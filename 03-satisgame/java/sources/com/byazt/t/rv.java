package com.byazt.t;

import android.os.Build;
import com.byazt.ug.d;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DOLBY_MIX_LEVEL, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public static boolean n(com.byazt.h.n nVar) {
        return com.byazt.bk.l.l() && Build.VERSION.SDK_INT < 29 && d.d() != null && d.d().n() && com.byazt.rz.l.n(nVar).qg("invoke_app_form_background_switch") == 1 && nVar.hd();
    }
}
