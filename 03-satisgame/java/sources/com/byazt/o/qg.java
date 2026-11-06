package com.byazt.o;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY, 26})
public class qg extends n {
    public qg(Context context) {
        super(context, null, null);
    }

    @Override // com.byazt.o.l
    public Intent qg() {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.n.getPackageName()));
        intent.addFlags(C.ENCODING_PCM_32BIT);
        intent.addFlags(8388608);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        return intent;
    }
}
