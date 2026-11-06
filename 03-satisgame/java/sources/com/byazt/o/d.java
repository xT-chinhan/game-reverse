package com.byazt.o;

import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY, 113})
public class d extends n {
    public d(Context context, com.byazt.f.n nVar, String str) {
        super(context, nVar, str);
    }

    @Override // com.byazt.o.l
    public Intent qg() {
        String strS = this.qg.s(com.anythink.core.common.s.a);
        String strN = com.byazt.bk.s.n(this.qg.s("ag"), strS);
        String strN2 = com.byazt.bk.s.n(this.qg.s("ah"), strS);
        String strN3 = com.byazt.bk.s.n(this.qg.s("ai"), strS);
        String strN4 = com.byazt.bk.s.n(this.qg.s("aj"), strS);
        Intent intent = new Intent();
        intent.putExtra(strN, this.s);
        intent.putExtra(strN2, "*/*");
        intent.putExtra(strN3, true);
        intent.setAction(strN4);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.addFlags(32768);
        return intent;
    }
}
