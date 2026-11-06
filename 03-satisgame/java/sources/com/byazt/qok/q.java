package com.byazt.qok;

import android.graphics.Bitmap;
import com.byazt.si.lh;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_IGNORE_BACKGROUND_RENDERSTALL, 5})
public class q implements lh {
    public final lh n;
    public final com.byazt.dl.qg qg;

    public q(lh lhVar) {
        this(lhVar, null);
    }

    public q(lh lhVar, com.byazt.dl.qg qgVar) {
        this.n = lhVar;
        this.qg = qgVar;
    }

    @Override // com.byazt.si.n
    public boolean n(String str, Bitmap bitmap) {
        boolean zN = this.n.n(str, bitmap);
        if (this.qg != null) {
            Boolean.valueOf(zN);
        }
        return zN;
    }

    @Override // com.byazt.si.n
    public Bitmap n(String str) {
        return this.n.n(str);
    }

    @Override // com.byazt.si.n
    public void n() {
        this.n.n();
    }

    @Override // com.byazt.si.n
    public boolean qg(String str) {
        return this.n.qg(str);
    }

    @Override // com.byazt.si.n
    public void n(double d) {
        this.n.n(d);
    }
}
