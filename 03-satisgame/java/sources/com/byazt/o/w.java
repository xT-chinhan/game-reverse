package com.byazt.o;

import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY, 13})
public class w extends n {
    public w(Context context) {
        super(context, null, null);
    }

    @Override // com.byazt.o.l
    public Intent qg() {
        Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.addFlags(C.ENCODING_PCM_32BIT);
        intent.addFlags(8388608);
        return intent;
    }
}
