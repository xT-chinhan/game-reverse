package com.byazt.bd;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 893, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT})
public class hd<K, A> extends n<K, A> {
    public final A q;

    @Override // com.byazt.bd.n
    public float w() {
        return 1.0f;
    }

    @Override // com.byazt.bd.n
    public void n(float f) {
        this.qg = f;
    }

    @Override // com.byazt.bd.n
    public void qg() {
        if (this.s != null) {
            super.qg();
        }
    }

    @Override // com.byazt.bd.n
    public A x() {
        com.byazt.yt.s<A> sVar = this.s;
        A a = this.q;
        return sVar.n(0.0f, 0.0f, a, a, fs(), fs(), fs());
    }

    @Override // com.byazt.bd.n
    public A n(com.byazt.yt.n<K> nVar, float f) {
        return x();
    }
}
