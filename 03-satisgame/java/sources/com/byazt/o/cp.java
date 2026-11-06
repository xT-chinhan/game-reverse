package com.byazt.o;

import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY, 29})
public class cp extends n {
    public cp(Context context, com.byazt.f.n nVar, String str) {
        super(context, nVar, str);
    }

    @Override // com.byazt.o.l
    public Intent qg() {
        Intent intent = new Intent("com.android.filemanager.OPEN_FOLDER");
        intent.putExtra("com.android.filemanager.OPEN_FOLDER", this.s);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.addFlags(32768);
        intent.addFlags(C.ENCODING_PCM_32BIT);
        return intent;
    }
}
