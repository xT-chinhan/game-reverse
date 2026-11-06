package com.byazt.aqe;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import com.byazt.gct.b;
import com.byazt.gct.cd;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEIDA_PLAYER_OPTION_IGNORE_DIRECTLY_BUFFERING, 101})
public class fs extends n {
    public String cd;
    public com.byazt.mr.w hd;

    public fs(Activity activity, pk pkVar) {
        super(activity, pkVar);
        this.hd = null;
    }

    @Override // com.byazt.aqe.n, com.byazt.aqe.qg
    public qg.n qg(final tj tjVar) {
        final com.byazt.mr.w wVar = new com.byazt.mr.w(this.fs);
        this.hd = wVar;
        n(wVar, this.q);
        this.hd.n(new com.byazt.mr.w.n() { // from class: com.byazt.aqe.fs.1
            @Override // com.byazt.mr.w.n
            public void n() {
                wVar.dismiss();
                tj tjVar2 = tjVar;
                if (tjVar2 != null) {
                    tjVar2.n();
                }
            }

            @Override // com.byazt.mr.w.n
            public void qg() {
                wVar.dismiss();
                tj tjVar2 = tjVar;
                if (tjVar2 != null) {
                    tjVar2.qg();
                }
            }
        });
        this.hd.show();
        return new qg.n(true, 0, "", this.hd);
    }

    @Override // com.byazt.aqe.qg
    public String n() {
        return this.cd;
    }

    private void n(com.byazt.mr.w wVar, boolean z) {
        if (com.byazt.qq.qg.qg(this.x)) {
            int iTs = this.x.ts();
            int iN = b.n(this.x);
            if (iTs == 0) {
                String str = "试玩时长达标才能领取奖励";
                if (iN != 1 && !z && !this.s) {
                    str = "试玩后才能领取奖励";
                }
                this.cd = str;
                wVar.l("tt_retain_gift").n(fs()).s("继续试玩").q("坚持退出");
                wVar.n(com.byazt.cb.qg.rv(this.fs));
                return;
            }
            if (iTs != 1) {
                if (iTs != 3) {
                    return;
                }
                this.cd = "确定退出吗?";
                if (this.fs != null) {
                    Intent intent = this.fs.getIntent();
                    this.cd = String.format("再看%s秒可得奖励", Integer.valueOf(intent != null ? intent.getIntExtra("remainTime", 0) : 0));
                }
                n(wVar, fs(), "继续观看", "坚持退出");
                wVar.n(Color.parseColor("#FC1D56"));
                return;
            }
            boolean zS = cd.s(this.x);
            if (iN != 0 || zS) {
                this.cd = String.format("再看%s秒可得奖励", Integer.valueOf(this.n));
            } else {
                this.cd = "未满足奖励要求，需要继续浏览";
            }
            if (zS) {
                wVar.qg("确定退出吗?");
                n(wVar, fs(), "继续观看", "坚持退出");
            } else {
                wVar.l("tt_reward_coin").n(Color.parseColor("#FC1D56")).n(fs()).s("继续观看").q("坚持退出");
                wVar.n(com.byazt.cb.qg.rv(this.fs));
            }
        }
    }

    private void n(com.byazt.mr.w wVar, String str, String str2, String str3) {
        wVar.l("tt_reward_browse_multi_icon").n(str).s(str2).q(str3);
        wVar.n(com.byazt.cb.qg.j(this.fs));
    }

    @Override // com.byazt.aqe.qg
    public boolean qg() {
        com.byazt.mr.w wVar = this.hd;
        return wVar != null && wVar.isShowing();
    }

    @Override // com.byazt.aqe.qg
    public void s() {
        com.byazt.mr.w wVar = this.hd;
        if (wVar != null) {
            wVar.dismiss();
        }
    }
}
