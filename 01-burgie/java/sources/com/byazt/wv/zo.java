package com.byazt.wv;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import com.byazt.hg.lb;
import com.byazt.hg.nw;
import com.byazt.hg.of;
import com.byazt.wt.ny;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo extends pr {
    public String lb;
    public com.byazt.nc.uc yb;

    public zo(Activity activity, of ofVar) {
        super(activity, ofVar);
        this.yb = null;
    }

    @Override // com.byazt.wv.pr, com.byazt.wv.hw
    public hw.pr hw(final vk vkVar) {
        final com.byazt.nc.uc ucVar = new com.byazt.nc.uc(this.zo);
        this.yb = ucVar;
        pr(ucVar, this.x);
        this.yb.pr(new com.byazt.nc.uc.pr() { // from class: com.byazt.wv.zo.1
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
        return this.lb;
    }

    private void pr(com.byazt.nc.uc ucVar, boolean z) {
        int intExtra;
        if (!ny.hw(this.fw)) {
        }
        int iEj = this.fw.ej();
        int iPr = nw.pr(this.fw);
        switch (iEj) {
            case 0:
                String str = "试玩时长达标才能领取奖励";
                if (iPr != 1 && !z && !this.hn) {
                    str = "试玩后才能领取奖励";
                }
                this.lb = str;
                ucVar.c("tt_retain_gift").pr(zo()).hn("继续试玩").x("坚持退出");
                ucVar.pr(com.byazt.sdv.c.aj(this.zo));
                break;
            case 1:
                boolean zHn = lb.hn(this.fw);
                if (iPr != 0 || zHn) {
                    this.lb = String.format("再看%s秒可得奖励", Integer.valueOf(this.pr));
                } else {
                    this.lb = "未满足奖励要求，需要继续浏览";
                }
                if (zHn) {
                    ucVar.hw("确定退出吗?");
                    pr(ucVar, zo(), "继续观看", "坚持退出");
                } else {
                    ucVar.c("tt_reward_coin").pr(Color.parseColor("#FC1D56")).pr(zo()).hn("继续观看").x("坚持退出");
                    ucVar.pr(com.byazt.sdv.c.aj(this.zo));
                }
                break;
            case 3:
                this.lb = "确定退出吗?";
                if (this.zo != null) {
                    Intent intent = this.zo.getIntent();
                    if (intent == null) {
                        intExtra = 0;
                    } else {
                        intExtra = intent.getIntExtra("remainTime", 0);
                    }
                    this.lb = String.format("再看%s秒可得奖励", Integer.valueOf(intExtra));
                }
                pr(ucVar, zo(), "继续观看", "坚持退出");
                ucVar.pr(Color.parseColor("#FC1D56"));
                break;
        }
    }

    private void pr(com.byazt.nc.uc ucVar, String str, String str2, String str3) {
        ucVar.c("tt_reward_browse_multi_icon").pr(str).hn(str2).x(str3);
        ucVar.pr(com.byazt.sdv.c.n(this.zo));
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
