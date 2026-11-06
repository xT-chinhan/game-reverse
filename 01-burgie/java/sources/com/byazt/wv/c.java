package com.byazt.wv;

import android.app.Activity;
import android.view.View;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends pr {
    public com.byazt.nc.uc yb;

    public c(Activity activity, of ofVar) {
        super(activity, ofVar);
        this.yb = null;
    }

    @Override // com.byazt.wv.pr, com.byazt.wv.hw
    public hw.pr hw(final vk vkVar) {
        final com.byazt.nc.uc ucVar = new com.byazt.nc.uc(this.zo);
        this.yb = ucVar;
        ucVar.c("tt_retain_gift").pr(zo()).hn("继续观看").x("坚持退出");
        ucVar.pr(com.byazt.sdv.c.m(this.zo));
        this.yb.pr(new com.byazt.nc.uc.pr() { // from class: com.byazt.wv.c.1
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
        this.yb.pr(new View.OnClickListener() { // from class: com.byazt.wv.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ucVar.dismiss();
                vk vkVar2 = vkVar;
                if (vkVar2 != null) {
                    vkVar2.hn();
                }
            }
        });
        this.yb.show();
        return new hw.pr(true, 0, "", this.yb);
    }

    @Override // com.byazt.wv.hw
    public String pr() {
        return "继续观看" + this.pr + "秒可获得奖励\n确定要退出吗？";
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
