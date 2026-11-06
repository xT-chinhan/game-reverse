package com.byazt.ye;

import com.byazt.af.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 475, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements com.byazt.ni.pr {
    public w c;
    public Map<String, Object> hn;
    public com.byazt.hws.pr hw;
    public com.byazt.ni.pr pr;
    public String x;

    public c(com.byazt.ni.pr prVar, w wVar, com.byazt.hws.pr prVar2, Map<String, Object> map, String str) {
        this.c = wVar;
        this.pr = prVar;
        this.hw = prVar2;
        this.hn = map;
        this.x = str;
    }

    @Override // com.byazt.ni.pr
    public boolean pr(final Map<String, Object> map) {
        int iPr = com.byazt.eg.hw.pr().pr(this.c, new com.byazt.zr.hn() { // from class: com.byazt.ye.c.1
            @Override // com.byazt.zr.hn
            public void pr(int i) {
                if (!(c.this.pr != null && c.this.pr.pr(map))) {
                    c.this.hw.pr(c.this.hn, (com.byazt.rs.pr) null);
                }
            }
        }, this.x, this.hn);
        if (iPr == 1 || iPr == 2) {
            pr();
            return true;
        }
        com.byazt.ni.pr prVar = this.pr;
        return prVar != null && prVar.pr(map);
    }

    private void pr() {
        Map<String, Object> map;
        Map<String, Object> map2 = this.hn;
        if (map2 != null) {
            Object obj = map2.get("click_chain");
            Object obj2 = this.hn.get("handle_chain_data");
            if (obj != null && (obj instanceof com.byazt.ln.hn)) {
                com.byazt.ln.hn hnVar = (com.byazt.ln.hn) obj;
                com.byazt.yx.pr prVar = (com.byazt.yx.pr) hnVar.pr(com.byazt.yx.pr.class);
                if (prVar != null) {
                    if (obj2 != null && (obj2 instanceof Map)) {
                        map = (Map) obj2;
                    } else {
                        map = new HashMap<>();
                    }
                    prVar.pr(map, hnVar);
                }
            }
        }
    }
}
