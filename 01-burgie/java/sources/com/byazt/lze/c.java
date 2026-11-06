package com.byazt.lze;

import com.byazt.af.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 936, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements com.byazt.lf.hn {
    public final zo pr = new zo();

    @Override // com.byazt.lf.hn
    public boolean pr(Map<String, Object> map, Map<String, Object> map2, com.byazt.hws.pr prVar) {
        com.byazt.lx.hw.pr(this.pr, prVar.hn(), prVar.hw(), map2);
        com.byazt.ye.fw fwVar = new com.byazt.ye.fw(this.pr.ho(), this.pr.getContext(), this.pr, map2);
        fwVar.pr(this.pr.aj());
        if (pr(fwVar, map2, prVar).pr(map2)) {
            com.byazt.lx.hw.pr(map2, com.byazt.wb.c.hn);
            prVar.hw(map2);
            return true;
        }
        prVar.hw(map2, null);
        return true;
    }

    private com.byazt.ye.hn pr(com.byazt.ye.fw fwVar, Map<String, Object> map, com.byazt.hws.pr prVar) {
        zo zoVar = this.pr;
        com.byazt.ye.hn hnVar = new com.byazt.ye.hn(fwVar, zoVar, zoVar.aj(), this.pr.g(), this.pr.getContext(), map, true);
        hnVar.hw(this.pr.w());
        hnVar.pr(this.pr.vk());
        hnVar.pr(this.pr.k());
        hnVar.pr(this.pr.nt());
        hnVar.hn(this.pr.fw());
        return hnVar;
    }
}
