package com.byazt.vku;

import com.byazt.rcj.fs;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_TIMESTAMP_MONOTONIC, 5})
public class q implements com.byazt.jjq.s {
    public final com.byazt.llp.q n = new com.byazt.llp.q();
    public boolean qg;

    public interface n {
        void n(boolean z);
    }

    @Override // com.byazt.jjq.s
    public boolean n(Map<String, Object> map, Map<String, Object> map2, com.byazt.dm.n nVar) {
        this.qg = com.byazt.ph.q.tj();
        com.byazt.ukb.qg.n(this.n, nVar.s(), nVar.qg(), map2);
        if (!n(map2)) {
            com.byazt.ukb.qg.n(map2, com.byazt.wr.w.q);
            nVar.qg(map2, null);
            return true;
        }
        boolean zN = n(map2, nVar).n(new HashMap());
        if (!this.qg) {
            if (zN) {
                com.byazt.ukb.qg.n(map2, com.byazt.wr.w.s);
                nVar.qg(map2);
            } else {
                nVar.qg(map2, null);
            }
        }
        return true;
    }

    private fs n(final Map<String, Object> map, final com.byazt.dm.n nVar) {
        com.byazt.llp.q qVar = this.n;
        fs fsVar = new fs(qVar, qVar.getContext(), this.n.qg(), this.n.s(), map, nVar, this.n.q(), true);
        if (this.qg) {
            fsVar.n(new n() { // from class: com.byazt.vku.q.1
                @Override // com.byazt.vku.q.n
                public void n(boolean z) {
                    if (z) {
                        com.byazt.ukb.qg.n((Map<String, Object>) map, com.byazt.wr.w.s);
                        nVar.qg(map);
                    } else {
                        nVar.qg(map, null);
                    }
                }
            });
        }
        return fsVar;
    }

    private boolean n(Map<String, Object> map) {
        return (com.byazt.ukb.qg.n(this.n, map) == null || this.n.getContext() == null || this.n.J_() == null) ? false : true;
    }
}
