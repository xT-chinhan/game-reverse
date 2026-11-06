package com.byazt.jp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME, 110})
public class sz {
    public rv n() {
        return null;
    }

    public boolean qg() {
        return true;
    }

    public static sz n(final com.byazt.mt.s sVar) {
        return new sz() { // from class: com.byazt.jp.sz.1
            @Override // com.byazt.jp.sz
            public rv n() {
                com.byazt.mt.q qVarK;
                com.byazt.mt.s sVar2 = sVar;
                if (sVar2 != null && (qVarK = sVar2.k()) != null && qVarK.n() != 0.0d && qVarK.qg() != 0.0d) {
                    return new rv(qVarK.n(), qVarK.qg());
                }
                return super.n();
            }

            @Override // com.byazt.jp.sz
            public boolean qg() {
                com.byazt.mt.s sVar2 = sVar;
                if (sVar2 != null) {
                    return sVar2.fs();
                }
                return super.qg();
            }
        };
    }
}
