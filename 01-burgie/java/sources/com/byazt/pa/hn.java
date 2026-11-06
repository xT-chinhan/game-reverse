package com.byazt.pa;

import com.byazt.vkw.g;
import com.byazt.vkw.k;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_LOW_THRESHOLD, 20})
public class hn implements com.byazt.mqu.hw<com.byazt.hh.pr> {
    public g hn = (g) uc.pr("device_info_new");
    public com.byazt.vkw.pr hw;
    public com.byazt.hh.hw pr;
    public k x;

    public hn(com.byazt.vkw.pr prVar, com.byazt.hh.hw hwVar) {
        this.hw = prVar;
        this.pr = hwVar;
        this.x = (k) uc.pr("csj_settings", prVar);
    }

    @Override // com.byazt.mqu.hw
    public com.byazt.mqu.pr pr(List<com.byazt.hh.pr> list, com.byazt.hh.c cVar) {
        return new hw(this.hw, this.pr, this.x, this.hn, cVar).pr(list);
    }

    @Override // com.byazt.mqu.hw
    public com.byazt.mqu.pr hw(List<com.byazt.hh.pr> list, com.byazt.hh.c cVar) {
        return new c(this.hw, this.pr, this.x, this.hn, cVar).pr(list);
    }

    @Override // com.byazt.mqu.hw
    public com.byazt.mqu.pr hn(List<com.byazt.hh.pr> list, com.byazt.hh.c cVar) {
        return new x(this.hw, this.pr, this.x, this.hn, cVar).pr(list);
    }

    @Override // com.byazt.mqu.hw
    public List<hw.pr> x(List<com.byazt.hh.pr> list, com.byazt.hh.c cVar) {
        return new hw(this.hw, this.pr, this.x, this.hn, cVar).hw(list);
    }
}
