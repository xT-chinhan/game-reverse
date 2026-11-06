package com.byazt.tb;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND, 20})
public class hn implements com.byazt.mc.hw {
    public List<com.byazt.mn.hw> pr = new CopyOnWriteArrayList();

    @Override // com.byazt.mc.hw
    public void pr(com.byazt.pv.hw hwVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.x.pr(zoVar);
        com.byazt.mn.hw hwVar2 = new com.byazt.mn.hw("ad_load", "started", zoVar != null ? zoVar.pr() : System.currentTimeMillis());
        this.pr.add(hwVar2);
        com.byazt.mn.hn.pr(hwVar2, hwVar.ho, hwVar);
    }

    @Override // com.byazt.mc.hw
    public void hw(com.byazt.pv.hw hwVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.x.pr(zoVar);
        com.byazt.mn.hw hwVar2 = new com.byazt.mn.hw("ad_load", "reqed", zoVar != null ? zoVar.pr() : System.currentTimeMillis());
        this.pr.add(hwVar2);
        com.byazt.mn.hn.pr(hwVar2, hwVar.ho, hwVar);
    }

    @Override // com.byazt.mc.hw
    public void hn(com.byazt.pv.hw hwVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.hw hwVar2 = new com.byazt.mn.hw("ad_load", "received", zoVar != null ? zoVar.pr() : System.currentTimeMillis(), hwVar.hw ? 1 : 2);
        this.pr.add(hwVar2);
        com.byazt.mn.hn.pr(hwVar2, hwVar.ho, hwVar);
    }

    @Override // com.byazt.mc.hw
    public void x(com.byazt.pv.hw hwVar, com.byazt.ewt.zo zoVar) {
        com.byazt.mn.hw hwVar2 = new com.byazt.mn.hw("ad_load", "loaded", zoVar != null ? zoVar.pr() : System.currentTimeMillis(), hwVar.hn ? 1 : 2);
        this.pr.add(hwVar2);
        com.byazt.mn.hn.pr(hwVar2, hwVar.ho, hwVar);
        Iterator<String> it = hwVar.c.iterator();
        while (it.hasNext()) {
            ((com.byazt.dc.hn) com.byazt.ewt.c.pr(1)).pr(it.next(), new com.byazt.ewt.x.pr() { // from class: com.byazt.tb.hn.1
                @Override // com.byazt.ewt.x.pr
                public void pr(com.byazt.ewt.hw hwVar3) {
                    if (hwVar3 instanceof com.byazt.pv.hn) {
                        ((com.byazt.pv.hn) hwVar3).aj.addAll(0, hn.this.pr);
                    }
                }
            });
        }
    }
}
