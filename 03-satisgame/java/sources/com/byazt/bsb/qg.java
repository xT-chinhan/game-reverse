package com.byazt.bsb;

import android.content.Context;
import android.view.ViewGroup;
import com.byazt.gct.pk;
import com.byazt.ql.s;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ASYNC_INIT_CODEC, 26})
public class qg extends com.byazt.zx.n {
    public boolean f;

    @Override // com.byazt.zx.n
    public int m() {
        return 5;
    }

    @Override // com.byazt.zx.n
    public boolean y_() {
        return false;
    }

    public qg(Context context, ViewGroup viewGroup, pk pkVar, com.byazt.ys.n nVar) {
        super(context, viewGroup, pkVar, nVar);
        this.f = true;
        n(false);
    }

    @Override // com.byazt.zx.n
    public void w(boolean z) {
        super.w(z);
        if (this.f) {
            if (!s.n(this.w) || l()) {
                qg();
            }
        }
    }

    public void hu() {
        y();
    }

    public void x(boolean z) {
        this.f = z;
    }
}
