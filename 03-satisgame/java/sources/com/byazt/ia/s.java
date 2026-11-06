package com.byazt.ia;

import android.content.Context;
import android.view.ViewGroup;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_STRENGTH_OPTION, 8})
public class s extends q {
    public s(Context context, ViewGroup viewGroup, pk pkVar, String str, boolean z, boolean z2, boolean z3) {
        super(context, viewGroup, pkVar, str, z, z2, z3);
    }

    @Override // com.byazt.ia.q
    public void n(int i, int i2) {
        super.n(i, i2);
        if (this.l == null || i <= 0 || i2 <= 0) {
            return;
        }
        this.l.s(i, i2);
        this.l.n(i, i2);
        qg(-1, -1);
    }

    @Override // com.byazt.ia.q
    public com.byazt.hlq.qg m() {
        if (this.l != null) {
            return this.l.hd();
        }
        return null;
    }
}
