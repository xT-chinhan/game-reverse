package com.byazt.al;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 60, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class yb<K, A> extends pr<K, A> {
    public final A x;

    @Override // com.byazt.al.pr
    public void pr(float f) {
        this.hw = f;
    }

    @Override // com.byazt.al.pr
    public float uc() {
        return 1.0f;
    }

    @Override // com.byazt.al.pr
    public void hw() {
        if (this.hn != null) {
            super.hw();
        }
    }

    @Override // com.byazt.al.pr
    public A fw() {
        com.byazt.cz.hn<A> hnVar = this.hn;
        A a = this.x;
        return hnVar.pr(0.0f, 0.0f, a, a, zo(), zo(), zo());
    }

    @Override // com.byazt.al.pr
    public A pr(com.byazt.cz.pr<K> prVar, float f) {
        return fw();
    }
}
