package com.byazt.xu;

import android.app.Activity;
import com.byazt.hg.hs;
import com.byazt.hg.of;
import com.byazt.nc.uc;
import com.byazt.sdv.c;
import com.byazt.wv.vk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEIDA_PLAYER_OPTION_IGNORE_DIRECTLY_BUFFERING, 13})
public class hw extends pr {
    public uc hw;

    public hw(Activity activity, of ofVar) {
        super(activity, ofVar);
        this.hw = null;
    }

    @Override // com.byazt.xu.pr, com.byazt.wv.hw
    public com.byazt.wv.hw.pr pr(final vk vkVar) {
        com.byazt.wv.hw.pr prVarPr = super.pr(vkVar);
        if (prVarPr.hn()) {
            return prVarPr;
        }
        final uc ucVar = new uc(this.zo);
        this.hw = ucVar;
        ucVar.c("tt_retain_gift").pr(pr()).hn(hs.pr(this.fw, this.w, this.k)).x("坚持退出");
        ucVar.pr(c.aj(this.zo));
        this.hw.pr(new uc.pr() { // from class: com.byazt.xu.hw.1
            @Override // com.byazt.nc.uc.pr
            public void pr() {
                vk vkVar2 = vkVar;
                if (vkVar2 != null) {
                    vkVar2.pr();
                }
            }

            @Override // com.byazt.nc.uc.pr
            public void hw() {
                ucVar.dismiss();
                vk vkVar2 = vkVar;
                if (vkVar2 != null) {
                    vkVar2.hw();
                }
            }
        });
        this.hw.show();
        return new com.byazt.wv.hw.pr(true, 0, "", this.hw);
    }

    @Override // com.byazt.wv.hw
    public String pr() {
        return "恭喜您已经获得奖励，是否要继续观看视频，再得超值奖励";
    }

    @Override // com.byazt.wv.hw
    public boolean hw() {
        uc ucVar = this.hw;
        return ucVar != null && ucVar.isShowing();
    }

    @Override // com.byazt.wv.hw
    public void hn() {
        uc ucVar = this.hw;
        if (ucVar != null) {
            ucVar.dismiss();
        }
    }

    @Override // com.byazt.wv.hw
    public void x() {
        uc ucVar = this.hw;
        if (ucVar != null) {
            ucVar.pr();
        }
    }

    @Override // com.byazt.wv.hw
    public void c() {
        uc ucVar = this.hw;
        if (ucVar != null) {
            ucVar.hw();
        }
    }
}
