package com.byazt.xu;

import android.app.Activity;
import com.byazt.hg.hs;
import com.byazt.hg.of;
import com.byazt.hg.pj;
import com.byazt.wv.vk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEIDA_PLAYER_OPTION_IGNORE_DIRECTLY_BUFFERING, 121})
public class x extends pr {
    public pr hw;

    public x(Activity activity, of ofVar) {
        super(activity, ofVar);
    }

    @Override // com.byazt.xu.pr, com.byazt.wv.hw
    public com.byazt.wv.hw.pr pr(vk vkVar) {
        ArrayList<pj> arrayListC = hs.c(this.fw);
        if (arrayListC == null) {
            return new com.byazt.wv.hw.pr(false, 0, "");
        }
        for (pj pjVar : arrayListC) {
            switch (pjVar.hn()) {
                case 1:
                    this.hw = new hn(this.zo, this.fw, pjVar);
                    break;
            }
            pr prVar = this.hw;
            if (prVar != null) {
                prVar.hn(this.k);
                this.hw.x(this.w);
                this.hw.pr(this.pr);
                this.hw.hw(zo());
                this.hw.pr(this.nt);
                com.byazt.wv.hw.pr prVarPr = this.hw.pr(vkVar);
                if (prVarPr.hn()) {
                    return prVarPr;
                }
            }
        }
        return new com.byazt.wv.hw.pr(false, 0, "");
    }

    @Override // com.byazt.wv.hw
    public String pr() {
        pr prVar = this.hw;
        if (prVar == null) {
            return null;
        }
        return prVar.pr();
    }

    @Override // com.byazt.wv.hw
    public void hw(String str) {
        super.hw(str);
        pr prVar = this.hw;
        if (prVar == null) {
            return;
        }
        prVar.hw(str);
    }
}
