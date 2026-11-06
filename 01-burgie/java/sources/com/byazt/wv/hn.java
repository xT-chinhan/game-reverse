package com.byazt.wv;

import android.app.Activity;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 20})
public class hn extends pr {
    public boolean lb;
    public com.byazt.nc.uc yb;

    public hn(Activity activity, of ofVar, boolean z) {
        super(activity, ofVar);
        this.yb = null;
        this.lb = z;
    }

    @Override // com.byazt.wv.pr, com.byazt.wv.hw
    public hw.pr hw(final vk vkVar) {
        if (!this.lb) {
            hw.pr prVarHw = super.hw(vkVar);
            if (prVarHw.hn()) {
                return prVarHw;
            }
        }
        final com.byazt.nc.uc ucVar = new com.byazt.nc.uc(this.zo);
        this.yb = ucVar;
        ucVar.c("tt_retain_gift").pr(zo()).hn("继续观看").x("坚持退出");
        this.yb.pr(com.byazt.sdv.c.aj(this.zo));
        this.yb.pr(new com.byazt.nc.uc.pr() { // from class: com.byazt.wv.hn.1
            @Override // com.byazt.nc.uc.pr
            public void pr() {
                ucVar.dismiss();
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
        this.yb.show();
        return new hw.pr(true, 0, "", this.yb);
    }

    @Override // com.byazt.wv.hw
    public String pr() {
        if (!(this.pr <= 0) && this.c) {
            return "再看" + this.pr + "s，并点击一下广告可领取奖励";
        }
        if (this.c) {
            return "忘记点击广告领取奖励啦～";
        }
        return "再看" + this.pr + "s可领取奖励";
    }

    @Override // com.byazt.wv.hw
    public boolean hw() {
        com.byazt.nc.uc ucVar = this.yb;
        return ucVar != null && ucVar.isShowing();
    }

    @Override // com.byazt.wv.hw
    public void hn() {
        com.byazt.nc.uc ucVar = this.yb;
        if (ucVar != null) {
            ucVar.dismiss();
        }
    }
}
