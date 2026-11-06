package com.byazt.rte;

import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 580, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo extends pr {
    public zo(Context context, com.byazt.ew.pr prVar, String str) {
        super(context, prVar, str);
    }

    @Override // com.byazt.rte.c
    public Intent hw() {
        Intent intent = new Intent(com.byazt.mrs.c.hn + ".intent.action.OPEN_FILEMANAGER");
        intent.putExtra("CurrentDir", this.hn);
        intent.putExtra("first_position", 1);
        intent.putExtra("CurrentMode", 1);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
