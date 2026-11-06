package com.byazt.rft;

import android.text.TextUtils;
import com.byazt.tbt.d;
import com.byazt.tbt.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_PARAMS, 8})
public final class s extends d {
    public q d;

    public s(d.n nVar) {
        super(nVar);
        this.d = new q();
    }

    @Override // com.byazt.tbt.d
    public com.byazt.tbt.q n() {
        return this.d;
    }

    @Override // com.byazt.tbt.d
    public com.byazt.tbt.qg n(sz szVar) {
        if (szVar == null || TextUtils.isEmpty(szVar.s())) {
            return null;
        }
        szVar.n(this);
        return new n(szVar, this.d);
    }
}
