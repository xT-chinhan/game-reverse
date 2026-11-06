package com.byazt.i;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv implements com.byazt.xv.cp {
    @Override // com.byazt.xv.cp
    public int n(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String strL = com.byazt.ta.w.l(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(strL)) {
            return 0;
        }
        return strL.hashCode();
    }
}
