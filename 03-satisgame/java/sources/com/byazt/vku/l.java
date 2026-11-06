package com.byazt.vku;

import com.byazt.llp.fs;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_TIMESTAMP_MONOTONIC, 18})
public class l implements com.byazt.jjq.s {
    public final fs n = new fs();
    public boolean qg;

    public interface n {
        void n(boolean z);
    }

    @Override // com.byazt.jjq.s
    public boolean n(Map<String, Object> map, Map<String, Object> map2, com.byazt.dm.n nVar) {
        this.qg = com.byazt.ph.q.cp();
        com.byazt.ukb.qg.n(this.n, nVar.s(), nVar.qg(), map2);
        com.byazt.rcj.x xVar = new com.byazt.rcj.x(this.n.k(), this.n.getContext(), this.n, map2);
        xVar.n(this.n.rv());
        boolean zN = n(xVar, map2, nVar).n(map2);
        if (this.qg) {
            return true;
        }
        if (zN) {
            com.byazt.ukb.qg.n(map2, com.byazt.wr.l.s);
            nVar.qg(map2);
            return true;
        }
        nVar.qg(map2, null);
        return true;
    }

    private com.byazt.rcj.s n(com.byazt.rcj.x xVar, final Map<String, Object> map, final com.byazt.dm.n nVar) {
        fs fsVar = this.n;
        com.byazt.rcj.s sVar = new com.byazt.rcj.s(xVar, fsVar, fsVar.rv(), this.n.sz(), this.n.getContext(), map, true, this.qg);
        sVar.qg(this.n.cp());
        sVar.n(this.n.tj());
        sVar.n(this.n.d());
        sVar.n(this.n.cy());
        sVar.s(this.n.x());
        if (this.qg) {
            sVar.n(new n() { // from class: com.byazt.vku.l.1
                @Override // com.byazt.vku.l.n
                public void n(boolean z) {
                    if (z) {
                        com.byazt.ukb.qg.n((Map<String, Object>) map, com.byazt.wr.l.s);
                        nVar.qg(map);
                    } else {
                        nVar.qg(map, null);
                    }
                }
            });
        }
        return sVar;
    }
}
