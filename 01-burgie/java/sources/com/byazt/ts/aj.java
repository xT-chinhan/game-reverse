package com.byazt.ts;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 61})
public class aj implements com.byazt.lj.w {
    @Override // com.byazt.lj.w
    public int pr(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String strC = com.byazt.tuy.uc.c(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(strC)) {
            return 0;
        }
        return strC.hashCode();
    }
}
