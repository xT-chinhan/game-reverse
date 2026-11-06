package com.byazt.bd;

import android.graphics.Path;
import com.byazt.sp.um;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 893, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa extends n<com.byazt.aw.sz, Path> {
    public final Path l;
    public final com.byazt.aw.sz q;
    public List<um> w;

    public oa(List<com.byazt.yt.n<com.byazt.aw.sz>> list) {
        super(list);
        this.q = new com.byazt.aw.sz();
        this.l = new Path();
    }

    @Override // com.byazt.bd.n
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public Path n(com.byazt.yt.n<com.byazt.aw.sz> nVar, float f) {
        this.q.n(nVar.n, nVar.qg, f);
        com.byazt.aw.sz szVarN = this.q;
        List<um> list = this.w;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                szVarN = this.w.get(size).n(szVarN);
            }
        }
        com.byazt.nu.rv.n(szVarN, this.l);
        return this.l;
    }

    public void n(List<um> list) {
        this.w = list;
    }
}
