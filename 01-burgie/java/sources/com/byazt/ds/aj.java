package com.byazt.ds;

import android.os.Build;
import com.byazt.eld.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES, 61})
public class aj {
    public static boolean pr(com.byazt.tia.pr prVar) {
        return com.byazt.now.c.c() && Build.VERSION.SDK_INT < 29 && k.k() != null && k.k().pr() && com.byazt.uk.c.pr(prVar).hw("invoke_app_form_background_switch") == 1 && prVar.yb();
    }
}
