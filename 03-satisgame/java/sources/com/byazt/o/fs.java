package com.byazt.o;

import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY, 101})
public class fs extends n {
    public fs(Context context, com.byazt.f.n nVar, String str) {
        super(context, nVar, str);
    }

    @Override // com.byazt.o.l
    public Intent qg() {
        Intent intent = new Intent(com.byazt.sk.l.s + ".intent.action.OPEN_FILEMANAGER");
        intent.putExtra("CurrentDir", this.s);
        intent.putExtra("first_position", 1);
        intent.putExtra("CurrentMode", 1);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.addFlags(32768);
        intent.addFlags(C.ENCODING_PCM_32BIT);
        return intent;
    }
}
