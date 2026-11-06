package com.byazt.vku;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_TIMESTAMP_MONOTONIC, 19})
public class n implements com.byazt.jjq.s {
    public final com.byazt.llp.qg n = new com.byazt.llp.qg();

    @Override // com.byazt.jjq.s
    public boolean n(Map<String, Object> map, Map<String, Object> map2, com.byazt.dm.n nVar) {
        com.byazt.ukb.qg.n(this.n, nVar.s(), map, map2);
        if (!n(map2)) {
            nVar.qg(map2, null);
            return true;
        }
        if (new com.byazt.xwj.qg(n(map2, com.byazt.rcj.n.q(map2)), this.n.hd()).n(map2)) {
            com.byazt.ukb.qg.n(map2, com.byazt.wr.qg.s);
            nVar.qg(map2);
        } else {
            nVar.qg(map2, null);
        }
        return true;
    }

    private com.byazt.rcj.n n(Map<String, Object> map, int i) {
        com.byazt.llp.qg qgVar = this.n;
        com.byazt.rcj.q qVar = new com.byazt.rcj.q(qgVar, qgVar.getContext(), this.n.fs(), this.n.tj(), this.n.sz(), this.n.a(), map, true);
        qVar.qg(this.n.oa());
        qVar.n(this.n.d(), i);
        qVar.n(this.n.rv());
        qVar.n(this.n.x());
        qVar.n(this.n.cp());
        qVar.n(this.n.cy());
        qVar.n(this.n.D_());
        return qVar;
    }

    private boolean n(Map<String, Object> map) {
        if (com.byazt.ukb.qg.n(this.n, map) == null || this.n.getContext() == null) {
            return false;
        }
        if (TextUtils.isEmpty(this.n.sz())) {
            com.byazt.gct.l lVarK = this.n.k();
            if (lVarK != null) {
                this.n.n(lVarK.qg());
            }
            if (TextUtils.isEmpty(this.n.sz())) {
                return false;
            }
        }
        return (TextUtils.isEmpty(this.n.fs()) || this.n.tj() == null) ? false : true;
    }
}
