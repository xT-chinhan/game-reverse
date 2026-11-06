package com.byazt.vku;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_TIMESTAMP_MONOTONIC, 8})
public class s implements com.byazt.jjq.s {
    public final com.byazt.llp.x n = new com.byazt.llp.x();

    @Override // com.byazt.jjq.s
    public boolean n(Map<String, Object> map, Map<String, Object> map2, com.byazt.dm.n nVar) {
        int iS;
        com.byazt.ukb.qg.n(this.n, nVar.s(), map, map2);
        if (!n(map2)) {
            nVar.qg(map2, null);
            return true;
        }
        if (this.n.wm() != -1001) {
            iS = this.n.wm();
        } else {
            iS = com.byazt.wq.qg.n().s();
            this.n.n(iS);
            com.byazt.ukb.qg.n(this.n, map2).el(iS);
        }
        map2.put("saas_status_while_click", Integer.valueOf(iS));
        com.byazt.llp.x xVar = this.n;
        com.byazt.rcj.w wVar = new com.byazt.rcj.w(xVar, xVar.getContext(), this.n.qg(), this.n.s(), map2);
        if (this.n.x() != -1) {
            wVar.qg(this.n.x());
        }
        wVar.n(this.n.fs());
        wVar.qg(this.n.rv());
        if (new com.byazt.rcj.qg(new com.byazt.rcj.l(wVar, com.byazt.ukb.qg.n(this.n, map2), nVar, map2, this.n.qg()), this.n.getContext(), com.byazt.ukb.qg.n(this.n, map2), this.n.qg(), map2, nVar).n(new HashMap())) {
            com.byazt.ukb.qg.n(map2, com.byazt.wr.q.s);
            nVar.qg(map2);
            return false;
        }
        nVar.qg(map2, null);
        return false;
    }

    private boolean n(Map<String, Object> map) {
        return (com.byazt.ukb.qg.n(this.n, map) == null || this.n.getContext() == null) ? false : true;
    }
}
